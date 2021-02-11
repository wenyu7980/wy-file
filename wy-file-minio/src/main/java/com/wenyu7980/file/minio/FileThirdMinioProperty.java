package com.wenyu7980.file.minio;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 * @author wenyu
 */

@Component
@ConditionalOnProperty(prefix = "application.file.minio", name = "url")
@ConfigurationProperties(prefix = "application.file.minio")
public class FileThirdMinioProperty {
    private String url;
    private String accessKey;
    private String accessSecret;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getAccessSecret() {
        return accessSecret;
    }

    public void setAccessSecret(String accessSecret) {
        this.accessSecret = accessSecret;
    }
}
