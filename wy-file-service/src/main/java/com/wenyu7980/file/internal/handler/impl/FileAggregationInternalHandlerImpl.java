package com.wenyu7980.file.internal.handler.impl;

import com.wenyu7980.file.aggregation.FileAggregation;
import com.wenyu7980.file.component.FileComponent;
import com.wenyu7980.file.domain.FileDomain;
import com.wenyu7980.file.internal.handler.FileAggregationInternalHandler;
import com.wenyu7980.file.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author wenyu
 */
@Component
public class FileAggregationInternalHandlerImpl implements FileAggregationInternalHandler {
    @Autowired
    private FileService fileService;
    @Autowired
    private FileComponent fileComponent;

    @Override
    public FileAggregation getFile(String id) {
        FileDomain fileDomain = fileComponent.getFileDomain(id);
        FileAggregation aggregation = new FileAggregation();
        aggregation.setFilename(fileDomain.getFileName());
        aggregation.setId(fileDomain.getId());
        aggregation.setPath(fileDomain.getPath());
        return aggregation;
    }
}
