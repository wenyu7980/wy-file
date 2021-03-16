package com.wenyu7980.file.api.service;

import com.wenyu7980.file.aggregation.FileAggregation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author wenyu
 */
@FeignClient(name = "wy-file", path = "internal/aggregation", contextId = "wy-file-aggregation")
public interface FileAggregationInternalService {
    /**
     * 文件聚合查询
     * @param id
     * @return
     */
    @GetMapping("files/{id}}")
    FileAggregation getFile(@PathVariable("id") String id);
}
