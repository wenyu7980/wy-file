package com.wenyu7980.file.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 *
 * @author wenyu
 */
@Table(name = "file_file")
@Entity
public class FileEntity {
    @Id
    @GenericGenerator(name = "UUID", strategy = "uuid32")
    @GeneratedValue(generator = "UUID")
    private String id;
    /** 文件名 */
    private String filename;
    /** bucketName */
    private String bucketName;
    /** 是否公开 */
    private Boolean publicFlag;
    /** 是否是待定 */
    private Boolean pendingFlag;
    /** 待定截止日期 */
    private LocalDateTime pendingDeadline;
    /** 创建时间 */
    private LocalDateTime createdDateTime;

    protected FileEntity() {
    }

    public FileEntity(String filename, String bucketName, Boolean publicFlag) {
        this.filename = filename;
        this.publicFlag = publicFlag;
        this.bucketName = bucketName;
        this.pendingFlag = false;
        this.createdDateTime = LocalDateTime.now();
    }

    public FileEntity(String bucketName, Boolean publicFlag, Integer timeout) {
        this.bucketName = bucketName;
        this.publicFlag = publicFlag;
        this.createdDateTime = LocalDateTime.now();
        this.pendingFlag = true;
        this.pendingDeadline = LocalDateTime.now().plusSeconds(timeout);
    }

    public void setFilename(String filename) {
        this.filename = filename;
        this.pendingFlag = false;
    }

    public void setPending() {
        this.pendingFlag = false;
    }

    public String getId() {
        return id;
    }

    public String getFilename() {
        return filename;
    }

    public String getBucketName() {
        return bucketName;
    }

    public Boolean getPublicFlag() {
        return publicFlag;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public Boolean getPendingFlag() {
        return pendingFlag;
    }

    public LocalDateTime getPendingDeadline() {
        return pendingDeadline;
    }
}
