package com.wenyu7980.file.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author wenyu
 */
@Component
@ConfigurationProperties(prefix = "application.file")
public class FileProperty {
    private Timeout timeout = new Timeout();
    private String defaultBucket;
    private Set<String> candidateBuckets;

    public String getDefaultBucket() {
        return defaultBucket;
    }

    public Set<String> getCandidateBuckets() {
        return candidateBuckets == null ? new HashSet<>() : candidateBuckets;
    }

    public Integer getGetTimeout() {
        return this.timeout.getGet();
    }

    public Integer getPutTimeout() {
        return this.timeout.getPut();
    }

    public void setTimeout(Timeout timeout) {
        this.timeout = timeout;
    }

    public void setDefaultBucket(String defaultBucket) {
        this.defaultBucket = defaultBucket;
    }

    public void setCandidateBuckets(Set<String> candidateBuckets) {
        this.candidateBuckets = candidateBuckets;
    }

    public static class Timeout {
        private Integer get;
        private Integer put;

        public Integer getGet() {
            return get;
        }

        public void setGet(Integer get) {
            this.get = get;
        }

        public Integer getPut() {
            return put;
        }

        public void setPut(Integer put) {
            this.put = put;
        }
    }
}
