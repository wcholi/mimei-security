package com.mimei.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wuchongliang
 * @create 2019-08-21 12:04:55
 * @description:
 */
@Target({ElementType.METHOD, ElementType.FIELD})   // 注解可以用在方法或字段上
@Retention(RetentionPolicy.RUNTIME)   // 运行时期的一个注解
@Constraint(validatedBy = MyConstraintValidator.class)  // 使用该注解时用哪个类进行校验
public @interface MyConstraint {

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
