package com.wenyu7980.file.rest.internal.handler;

import com.wenyu7980.file.aggregation.FileAggregation;

/**
 *
 * @author wenyu
 */
public interface FileAggregationInternalHandler {
    /**
     * 查询
     * @param id
     * @return
     */
    FileAggregation getFile(String id);
}
