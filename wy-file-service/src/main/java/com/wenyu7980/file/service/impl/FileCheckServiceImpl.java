package com.wenyu7980.file.service.impl;

import com.wenyu7980.file.service.FileCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author wenyu
 */
@Service
public class FileCheckServiceImpl implements FileCheckService {
    @Value("${application.file.check:#{true}}")
    private Boolean checkFlag;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void register(String id, String userId, Integer timeout) {
        if (this.checkFlag) {
            redisTemplate.opsForValue().set(getKey(id, userId), "", timeout, TimeUnit.SECONDS);
        }
    }

    @Override
    public boolean check(String id, String userId) {
        if (!this.checkFlag) {
            return true;
        }
        if (redisTemplate.hasKey(id)) {
            return true;
        }
        if (redisTemplate.hasKey(getKey(id, userId))) {
            return true;
        }
        return false;
    }

    private String getKey(String id, String userId) {
        return id + userId == null ? "" : userId;
    }
}
