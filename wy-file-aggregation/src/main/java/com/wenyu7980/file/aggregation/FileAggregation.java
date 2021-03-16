package com.wenyu7980.file.aggregation;

import com.wenyu7980.aggregation.annotation.Aggregation;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 * @author wenyu
 */
@Aggregation
public class FileAggregation {
    @ApiModelProperty(value = "id", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private String id;
    @ApiModelProperty(value = "名称", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private String fileName;
    @ApiModelProperty(value = "路径", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private String path;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFilename() {
        return fileName;
    }

    public void setFilename(String filename) {
        this.fileName = filename;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
