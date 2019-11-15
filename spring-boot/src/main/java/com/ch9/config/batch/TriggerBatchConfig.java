/**
 * 文件名: CsvBatchConfig.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch9.config.batch;

import com.ch9.batch.CsvBeanValidator;
import com.ch9.batch.CsvItemProcessor;
import com.ch9.batch.CsvJobListener;
import com.ch9.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.validator.Validator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @description: 好像这个类没有关系
 *
 * @author: ShenShuaihu
 * @version: 1.0
 * @data: 2019-11-05 22:22
 */
@Slf4j
@Configuration
@EnableBatchProcessing
public class TriggerBatchConfig {

    @Bean
    @StepScope
    public FlatFileItemReader<Person> reader(@Value("#{jobParameters['input.file.name']}") String pathToFile) throws Exception{

        FlatFileItemReader<Person> reader = new FlatFileItemReader<>();
        reader.setResource(new PathResource(pathToFile));
        reader.setLineMapper(new DefaultLineMapper<Person>() {
            {
                setLineTokenizer(new DelimitedLineTokenizer() {
                    {
                        setNames(new String[] {"name", "age", "nation", "address"});
                    }
                });
                setFieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {
                    {
                        setTargetType(Person.class);
                    }
                });
            }
        });
        return reader;
    }

    //@Bean
    //public ItemReader<Person> reader() throws Exception {
    //    // 文件是否存在
    //    PathResource pathResource = new PathResource("D:\\MyFile\\Develop\\IDEA\\demo\\spring\\spring-boot\\src\\main\\resources\\csv\\people.csv");
    //    if (!pathResource.exists()) {
    //        log.info("文件不存在。。。。。。。。。。");
    //    }
    //    log.info("文件不存在----------[]", pathResource.exists() );
    //    // 使用 FlatFileItemReader 读取文件
    //    FlatFileItemReader<Person> reader = new  FlatFileItemReader<Person>();
    //    reader.setResource(pathResource);
    //    // 模型映射
    //    reader.setLineMapper(new DefaultLineMapper<Person>(){
    //        {setLineTokenizer(new DelimitedLineTokenizer() {
    //            {
    //                setNames(new String[] {"name", "age", "nation", "address"});
    //            }
    //        });
    //        setFieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {
    //            {
    //                setTargetType(Person.class);
    //            }
    //        });
    //        }
    //    });
    //    return reader;
    //}

    @Bean
    public ItemProcessor<Person, Person> processor() {
        CsvItemProcessor processor = new CsvItemProcessor();
        processor.setValidator(csvBeanValidator());
        return processor;
    }

    @Bean
    public ItemWriter<Person> writer(DataSource dataSource) {
        JdbcBatchItemWriter<Person> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Person>());
        String sql = "insert into person " + "(id, name, age, nation, address)"
                + "values(hibernate_sequence.nextval, :name, :age, :nation, :address)";
        writer.setSql(sql);
        writer.setDataSource(dataSource);
        return writer;
    }

    @Bean
    public JobRepository jobRepository1(DataSource dataSource, PlatformTransactionManager transactionManager) throws Exception {
        JobRepositoryFactoryBean jobRepositoryFactoryBean = new JobRepositoryFactoryBean();
        jobRepositoryFactoryBean.setDataSource(dataSource);
        jobRepositoryFactoryBean.setTransactionManager(transactionManager);
        jobRepositoryFactoryBean.setDatabaseType("oracle");
        return jobRepositoryFactoryBean.getObject();
    }

    /**
     * JobListener定义
     *
     * @param dataSource
     * @param transactionManager
     * @return
     * @throws Exception
     */
    @Bean
    public SimpleJobLauncher jobLauncher1(DataSource dataSource, PlatformTransactionManager transactionManager) throws Exception {
        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
        jobLauncher.setJobRepository(jobRepository1(dataSource, transactionManager));
        return jobLauncher;
    }

    /**
     * JOB定义
     *
     * @param jobs
     * @param s1
     * @return
     */
    @Bean
    public Job importJob(JobBuilderFactory jobs, Step s1) {
        // 为job指定step 绑定监听器csvJobListener
        return jobs.get("importJob")
                .incrementer(new RunIdIncrementer())
                .flow(s1)
                .end()
                .listener(csvJobListener())
                .build();
    }

    /**
     * Step 定义
     * 批量处理数据  每次提交6500数据
     *
     * @param stepBuilderFactory
     * @param reader
     * @param writer
     * @param processor
     * @return
     */
    @Bean
    public Step step(StepBuilderFactory stepBuilderFactory, ItemReader<Person> reader, ItemWriter<Person> writer, ItemProcessor<Person, Person> processor) {
        // 给step绑定reader、processor和writer
        return stepBuilderFactory
                .get("step")
                .<Person, Person>chunk(6500)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean
    public CsvJobListener csvJobListener() {
        return new CsvJobListener();
    }

    @Bean
    public Validator<Person> csvBeanValidator() {
        return new CsvBeanValidator<Person>();
    }
}
