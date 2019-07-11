package com.ch6.interfer;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//import org.springframework.boot.autoconfigure.condition.OnPropertyCondition;
import org.springframework.context.annotation.Conditional;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
//@Conditional({OnPropertyCondition.class})
public @interface ConditionalOnProperty {

    /**
     * 数组，获取对应property名称的值，与name不可同时使用
     *
     * @return
     */
    String[] value() default {};

    /**
     *  property名称的前缀，可有可无
     * @return
     */
    String prefix() default "";

    /**
     * 数组，property完整名称或部分名称（可与prefix组合使用，组成完整的property名称），与value不可同时使用
     * @return
     */
    String[] name() default {};

    /**
     * 可与name组合使用，比较获取到的属性值与havingValue给定的值是否相同，相同才加载配置
     * @return
     */
    String havingValue() default "";

    /**
     * 缺少该property时是否可以加载。如果为true，没有该property也会正常加载；反之报错
     * @return
     */
    boolean matchIfMissing() default false;
}

