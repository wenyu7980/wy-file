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
@Table(name = "wy_file_info")
@Entity
public class FileEntity {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;
    /** 文件名 */
    private String filename;
    /** bucketName */
    private String bucketName;
    /** 是否公开 */
    private Boolean publicFlag;
    private LocalDateTime createdDateTime;

    protected FileEntity() {
    }

    public FileEntity(String filename, String bucketName, Boolean publicFlag) {
        this.filename = filename;
        this.publicFlag = publicFlag;
        this.bucketName = bucketName;
        this.createdDateTime = LocalDateTime.now();
    }

    public FileEntity(String bucketName, Boolean publicFlag) {
        this.bucketName = bucketName;
        this.publicFlag = publicFlag;
        this.createdDateTime = LocalDateTime.now();
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
}
