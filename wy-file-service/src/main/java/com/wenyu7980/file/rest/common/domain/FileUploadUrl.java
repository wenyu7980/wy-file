package com.wenyu7980.file.rest.common.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 *
 * @author wenyu
 */
public class FileUploadUrl {
    @ApiModelProperty(value = "id", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private String id;
    @ApiModelProperty(value = "路径", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private String path;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
