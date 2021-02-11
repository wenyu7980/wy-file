package com.wenyu7980.file.alioss;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 * @author wenyu
 */
@Component
@ConditionalOnProperty(prefix = "application.file.alioss", name = "accessKeyId")
@ConfigurationProperties(prefix = "application.file.alioss")
public class FileThirdAliOssProperty {
    /** 阿里云Endpoint */
    private Endpoint endpoint = new Endpoint();
    /** 阿里云key */
    private String accessKeyId;
    /** 阿里云secret */
    private String accessKeySecret;

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public String getInternal() {
        return endpoint.getInternal();
    }

    public String getWide() {
        return endpoint.getWide();
    }

    public void setEndpoint(Endpoint endpoint) {
        this.endpoint = endpoint;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public static class Endpoint {
        private String internal;
        private String wide;

        public String getInternal() {
            return internal;
        }

        public String getWide() {
            return wide;
        }

        public void setInternal(String internal) {
            this.internal = internal;
        }

        public void setWide(String wide) {
            this.wide = wide;
        }
    }
}
