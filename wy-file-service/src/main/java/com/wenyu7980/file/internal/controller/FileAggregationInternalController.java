package com.wenyu7980.file.internal.controller;

import com.wenyu7980.file.aggregation.FileAggregation;
import com.wenyu7980.file.api.service.FileAggregationInternalService;
import com.wenyu7980.file.internal.handler.FileAggregationInternalHandler;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 *
 * @author wenyu
 */
@ApiIgnore
@Api(tags = "文件管理（内部）")
@RestController
@RequestMapping("internal/aggregation/files")
public class FileAggregationInternalController implements FileAggregationInternalService {
    @Autowired
    private FileAggregationInternalHandler fileAggregationInternalHandler;
    @Override
    @GetMapping("{id}")
    public FileAggregation getFile(@PathVariable("id") String id) {
        return fileAggregationInternalHandler.getFile(id);
    }
}
