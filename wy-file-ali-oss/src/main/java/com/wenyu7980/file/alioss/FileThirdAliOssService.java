package com.wenyu7980.file.alioss;

import com.aliyun.oss.HttpMethod;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.wenyu7980.file.FileThirdDownloadService;
import com.wenyu7980.file.FileThirdExistService;
import com.wenyu7980.file.FileThirdUploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author wenyu
 */
@Component
@ConditionalOnBean(FileThirdAliOssProperty.class)
public class FileThirdAliOssService implements FileThirdUploadService, FileThirdDownloadService, FileThirdExistService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileThirdAliOssService.class);
    private final OSS wideOssClient;
    private final OSS internalOssClient;

    @Autowired
    public FileThirdAliOssService(FileThirdAliOssProperty property) {
        this.wideOssClient = new OSSClientBuilder()
          .build(property.getInternal(), property.getAccessKeyId(), property.getAccessKeySecret());
        if (Objects.equals(property.getInternal(), property.getWide())) {
            this.internalOssClient = wideOssClient;
        } else {
            this.internalOssClient = new OSSClientBuilder()
              .build(property.getInternal(), property.getAccessKeyId(), property.getAccessKeySecret());
        }
        LOGGER.info("阿里云oss初始化成功");
    }

    @Override
    public InputStream getObject(String bucketName, String objectName) {
        return this.internalOssClient.getObject(bucketName, objectName).getObjectContent();
    }

    @Override
    public String getDownloadPresignedUrl(String bucketName, String objectName, long timeout) {
        Date expiration = new Date(System.currentTimeMillis() + timeout * 1000);
        return this.wideOssClient.generatePresignedUrl(bucketName, objectName, expiration, HttpMethod.GET).getPath();
    }

    @Override
    public boolean existObject(String bucketName, String objectName) {
        return this.internalOssClient.doesObjectExist(bucketName, objectName);
    }

    @Override
    public void putObject(String bucketName, String objectName, InputStream inputStream) {
        this.internalOssClient.putObject(bucketName, objectName, inputStream);
    }

    @Override
    public String getUploadPresignedUrl(String bucketName, String objectName, long timeout) {
        Date expiration = new Date(System.currentTimeMillis() + timeout * 1000);
        return this.wideOssClient.generatePresignedUrl(bucketName, objectName, expiration, HttpMethod.PUT).getPath();
    }
}
