package com.wenyu7980.file.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 *
 * @author wenyu
 */
public class FileDomain {
    @ApiModelProperty(value = "id", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private String id;
    @ApiModelProperty(value = "文件名", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private String fileName;
    @ApiModelProperty(value = "路径", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private String path;

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
