package com.wenyu7980.file.starter.validator;

import com.wenyu7980.file.starter.util.FileUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Collection;

/**
 *
 * @author wenyu
 */
public class FileCheckValidator implements ConstraintValidator<FileCheck, Object> {

    @Override
    public void initialize(FileCheck constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        if (value instanceof String) {
            return FileUtils.checkFileId((String) value);
        }
        if (value instanceof Collection) {
            for (Object ob : (Collection<?>) value) {
                if (!FileUtils.checkFileId((String) ob)) {
                    return false;
                }
            }
        }
        return true;
    }
}
