/**
 * 文件名: CustomerSpecs.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch8.specs;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;
import static com.google.common.collect.Iterables.toArray;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SingularAttribute;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 自定义Repository
 *
 * @author: Shenshuaihu
 * @version: 1.0
 * @data: 2019-08-27 15:29
 */
public class CustomerSpecs {

    /**
     *  定义方法
     *
     * @param entityManager
     * @param example  传入查询的实体
     * @param <T> 泛型实体 用于参入参数
     * @return
     */
    public static <T> Specification<T> byAuto(final EntityManager entityManager, final T example) {

        // 获取当前传入实体类对象类的类型
        final Class<T> type = (Class<T>) example.getClass();

        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                // Predicate类别用于储存查询条件
                List<Predicate> predicates = new ArrayList<>();

                // 获取实体类属性
                EntityType<T> entityType = entityManager.getMetamodel().entity(type);

                // 对实体属性进行循环
                for (Attribute<T, ?> attribute : entityType.getDeclaredAttributes()) {
                    //获取实体的属性
                    Object attrValue = getValue(example, attribute);
                    if (attrValue != null) {
                        //当前实体字符串类型
                        if (attribute.getJavaType() == String.class) {
                            // 字符串不为空
                            if (!StringUtils.isEmpty(attrValue)) {
                                // 构造当前属性like属性值查询添加，并添加到列表中

                                predicates.add(
                                        criteriaBuilder.like(
                                                root.get(attribute(entityType, attribute.getName(), String.class))
                                                , pattern((String) attrValue)
                                        )
                                );
                            }
                        } else {
                            // 其余情况下 构造属性和属性值equal 查询条件，并添加到条件列表中
                            predicates.add(criteriaBuilder.equal(root.get(attribute(entityType, attribute.getName(), String.class)), attrValue));
                        }
                    }

                }
                // 将列表转成 Predicate
                return predicates.isEmpty() ? criteriaBuilder.conjunction() : criteriaBuilder.and(toArray(predicates, Predicate.class));


            }

            /**
             * 通过反射获取实体类对于属性的属性值
             * @param example
             * @param attribute
             * @param <T>
             * @return
             */
            private <T> Object getValue(T example, Attribute<T, ?> attribute) {
                return ReflectionUtils.getField((Field) attribute.getJavaMember(), example);
            }

            /**
             * 获得实体类的当前属性的 SingularAttribute，包含的是实体类的某个单独属性
             *
             * @param entityType
             * @param fieldName
             * @param fileldClass
             * @param <E>
             * @param <T>
             * @return
             */
            private <E, T> SingularAttribute<T, E> attribute(EntityType<T> entityType, String fieldName, Class<E> fileldClass) {
                return entityType.getDeclaredSingularAttribute(fieldName, fileldClass);
            }
        };


    }


    /**
     * 构造like查询模式
     * @param str
     * @return
     */
    static private String pattern(String str) {
        return "%" + str + "%";
    }
}

