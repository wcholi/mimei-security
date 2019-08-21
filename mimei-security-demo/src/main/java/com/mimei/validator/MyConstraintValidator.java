package com.mimei.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author wuchongliang
 * @create 2019-08-21 14:05:22
 * @description:
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {

    @Override
    public void initialize(MyConstraint myConstraint) {
        System.out.println("my constraint init");
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println(value);
        return false;
    }
}
