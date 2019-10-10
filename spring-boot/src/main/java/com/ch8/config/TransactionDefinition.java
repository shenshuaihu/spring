package com.ch8.config;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.core.annotation.AliasFor;
import org.springframework.lang.Nullable;

public interface TransactionDefinition {
    // 返回事务的传播行为
    int getPropagationBehavior();
    // 返回事务的隔离级别，事务管理器根据它来控制另外一个事务可以看到本事务内的哪些数据
    int getIsolationLevel();
    // 返回事务必须在多少秒内完成
    int getTimeout();
    // 返回是否优化为只读事务。
    boolean isReadOnly();
    //返回事务的名字
    @Nullable
    String getName();

// TransactionDefinition 接口中定义了五个表示隔离级别的常量：

    /**
     * 使用后端数据库默认的隔离级别，
     *  Mysql 默认采用的 REPEATABLE_READ隔离级别
     *  Oracle 默认采用的 READ_COMMITTED隔离级别.
     */
    int ISOLATION_DEFAULT = -1;

    /**
     * 最低的隔离级别，允许读取尚未提交的数据变更，可能会导致脏读、幻读或不可重复读
     */
    int ISOLATION_READ_UNCOMMITTED = 1;

    /**
     * 允许读取并发事务已经提交的数据，可以阻止脏读，但是幻读或不可重复读仍有可能发生
     */
    int ISOLATION_READ_COMMITTED = 2;

    /**
     * 对同一字段的多次读取结果都是一致的，除非数据是被本身事务自己所修改，可以阻止脏读和不可重复读，但幻读仍有可能发生。
     */
    int ISOLATION_REPEATABLE_READ = 4;

    /**
     * 最高的隔离级别，完全服从ACID的隔离级别。
     * 所有的事务依次逐个执行，这样事务之间就完全不可能产生干扰，也就是说，该级别可以防止脏读、不可重复读以及幻读。
     * 但是这将严重影响程序的性能。通常情况下也不会用到该级别。
     */
    int ISOLATION_SERIALIZABLE = 8;



    // 支持当前事务的情况：

    /**
     *  如果当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。
     */
    int PROPAGATION_REQUIRED = 0;

    /**
     * 如果当前存在事务，则加入该事务；如果当前没有事务，则以非事务的方式继续运行。
     */
    int PROPAGATION_SUPPORTS = 1;

    /**
     * 如果当前存在事务，则加入该事务；如果当前没有事务，则抛出异常。（mandatory：强制性）
     */
    int PROPAGATION_MANDATORY = 2;

    // 不支持当前事务的情况：
    /**
     * 创建一个新的事务，如果当前存在事务，则把当前事务挂起。
     */
    int PROPAGATION_REQUIRES_NEW = 3;

    /**
     * 以非事务方式运行，如果当前存在事务，则把当前事务挂起。
     */
    int PROPAGATION_NOT_SUPPORTED = 4;

    /**
     * 以非事务方式运行，如果当前存在事务，则抛出异常。
     */
    int PROPAGATION_NEVER = 5;

    // 其他情况：
    /**
     * 如果当前存在事务，则创建一个事务作为当前事务的嵌套事务来运行；
     * 如果当前没有事务，则该取值等价于TransactionDefinition.PROPAGATION_REQUIRED。则以非事务的方式继续运行。
     */
    int PROPAGATION_NESTED = 6;

}
