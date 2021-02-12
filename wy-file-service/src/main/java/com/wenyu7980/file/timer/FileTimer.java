package com.wenyu7980.file.timer;

import com.wenyu7980.file.FileThirdExistService;
import com.wenyu7980.file.entity.FileEntity;
import com.wenyu7980.file.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author wenyu
 */
@Component
public class FileTimer {
    @Autowired
    private FileService fileService;
    @Autowired
    private FileThirdExistService fileThirdExistService;

    @Scheduled(fixedDelay = 5000)
    public void pendingDetermine() {
        List<FileEntity> pendings = fileService.findByPending(LocalDateTime.now());
        for (FileEntity pending : pendings) {
            if (fileThirdExistService.existObject(pending.getBucketName(), pending.getId())) {
                pending.setPending();
                fileService.save(pending);
            }
        }
    }

}
