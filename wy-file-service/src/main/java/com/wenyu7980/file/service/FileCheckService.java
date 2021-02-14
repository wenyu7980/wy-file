package com.wenyu7980.file.service;

/**
 *
 * @author wenyu
 */
public interface FileCheckService {
    /**
     * 注册
     * @param id
     * @param userId
     * @param getTimeout
     */
    void register(String id, String userId, Integer getTimeout);

    /**
     * check
     * @param id
     * @param userId
     * @return
     */
    boolean check(String id, String userId);
}
