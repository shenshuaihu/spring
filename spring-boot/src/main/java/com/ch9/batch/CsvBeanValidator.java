/**
 * 文件名: CsvBeanValidator.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch9.batch;


import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import org.springframework.beans.factory.InitializingBean;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * @description:
 *
 * @author: ShenShuaihu
 * @version: 1.0
 * @data: 2019-11-05 21:49
 */
public class CsvBeanValidator<T> implements Validator<T>, InitializingBean {

    private javax.validation.Validator validator;


    @Override
    public void afterPropertiesSet() throws Exception {

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.usingContext().getValidator();
    }
    @Override
    public void validate(T value) throws ValidationException {

        // 使用 Validator的validate方法校验
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(value);

        if (constraintViolations.size() > 0) {
            StringBuffer message = new StringBuffer();
            for (ConstraintViolation<T> constraintViolation : constraintViolations) {
                message.append(constraintViolation.getMessage() + "\n");
            }
            throw new ValidationException(message.toString());
        }
    }

}
