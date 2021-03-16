package com.wenyu7980.file.starter.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.PARAMETER;

/**
 *
 * @author wenyu
 */
@Target({ ElementType.FIELD, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FileCheckValidator.class)
@Documented
public @interface FileCheck {
    String message() default "文件权限不足,请重新上传";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
