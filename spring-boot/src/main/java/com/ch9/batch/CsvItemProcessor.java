/**
 * 文件名: CsvItemProcessor.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch9.batch;

import com.ch9.domain.Person;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;

/**
 * @description: 数据处理
 *
 * @author: ShenShuaihu
 * @version: 1.0
 * @data: 2019-10-20 22:23
 */
public class CsvItemProcessor extends ValidatingItemProcessor<Person> {

    @Override
    public Person process(Person item) throws ValidationException {

        // 执行之后才会调用自定义检验器
        super.process(item);

        if (item.getNation().equals("汉族")) {
            // 如果汉族则存01
            item.setNation("01");
        } else {
            item.setNation("02");
        }
        return item;
    }
}
