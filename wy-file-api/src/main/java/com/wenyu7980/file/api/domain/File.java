package com.wenyu7980.file.api.domain;

/**
 *
 * @author wenyu
 */
public class File {
    /** 文件id */
    private String id;
    /** 文件名 */
    private String fileName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
