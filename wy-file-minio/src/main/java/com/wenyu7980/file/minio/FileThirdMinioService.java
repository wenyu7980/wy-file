package com.wenyu7980.file.minio;

import com.google.common.io.ByteStreams;
import com.wenyu7980.file.FileThirdDownloadService;
import com.wenyu7980.file.FileThirdExistService;
import com.wenyu7980.file.FileThirdUploadService;
import io.minio.MinioClient;
import io.minio.PutObjectOptions;
import io.minio.http.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 *
 * @author wenyu
 */
@Component
public class FileThirdMinioService implements FileThirdUploadService, FileThirdDownloadService, FileThirdExistService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileThirdMinioService.class);
    private final MinioClient minioClient;

    @Autowired
    public FileThirdMinioService(FileThirdMinioProperty property) {
        try {
            this.minioClient = new MinioClient(property.getUrl(), property.getAccessKey(), property.getAccessSecret());
            LOGGER.info("Minio初始化成功");
        } catch (Exception e) {
            throw new MinioRuntimeException("minio client 初始化失败", e);
        }
    }

    @Override
    public InputStream getObject(String bucketName, String objectName) {
        try {
            return this.minioClient.getObject(bucketName, objectName);
        } catch (Exception e) {
            throw new MinioRuntimeException("minio getObject失败", e);
        }
    }

    @Override
    public String getDownloadPresignedUrl(String bucketName, String objectName, int timeout) {
        try {
            return this.minioClient.getPresignedObjectUrl(Method.GET, bucketName, objectName, timeout, null);
        } catch (Exception e) {
            throw new MinioRuntimeException("minio getDownloadPresignedUrl失败", e);
        }
    }

    @Override
    public boolean existObject(String bucketName, String objectName) {
        try {
            this.minioClient.statObject(bucketName, objectName);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public void putObject(String bucketName, String objectName, InputStream inputStream) {
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(ByteStreams.toByteArray(inputStream));
            this.minioClient.putObject(bucketName, objectName, bais, new PutObjectOptions(bais.available(), 0));
        } catch (Exception exception) {
            throw new MinioRuntimeException("minio putObject失败", exception);
        }
    }

    @Override
    public String getUploadPresignedUrl(String bucketName, String objectName, int timeout) {
        try {
            return this.minioClient.getPresignedObjectUrl(Method.PUT, bucketName, objectName, timeout, null);
        } catch (Exception e) {
            throw new MinioRuntimeException("minio getUploadPresignedUrl失败", e);
        }
    }
}
