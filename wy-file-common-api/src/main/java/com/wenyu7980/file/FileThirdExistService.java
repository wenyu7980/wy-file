package com.wenyu7980.file;

/**
 *
 * @author wenyu
 */
public interface FileThirdExistService {
    /**
     * 对象是否存在
     * @param bucketName
     * @param objectName
     * @return
     */
    boolean existObject(String bucketName, String objectName);
}
