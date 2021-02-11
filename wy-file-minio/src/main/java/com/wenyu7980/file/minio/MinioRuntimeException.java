package com.wenyu7980.file.minio;

/**
 *
 * @author wenyu
 */
public class MinioRuntimeException extends RuntimeException {
    public MinioRuntimeException(String msg, Throwable throwable) {
        super(msg, throwable);
    }
}
