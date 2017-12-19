package com.luqinghe.service.impl;

import com.alibaba.fastjson.JSON;
import com.luqinghe.DO.Archive;
import com.luqinghe.dao.ArchiveDao;
import com.luqinghe.service.ArchiveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by qinghe on 2017/12/17.
 */
@Service
public class ArchiveServiceImpl implements ArchiveService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArchiveServiceImpl.class);

    @Autowired
    private ArchiveDao archiveDao;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public List<Archive> findByStuNameAndYear(String stuName, Integer year) {
        return archiveDao.findByStuNameAndYear(stuName, year);
    }

    @Override
    public Archive findById(Integer id) {
        String key = "archive_" + id;
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();

        Boolean hasKey = stringRedisTemplate.hasKey(key);
        if (hasKey) {
            Archive archive = JSON.parseObject(operations.get(key), Archive.class);
            LOGGER.info("从缓存中取得数据>>{}", archive);
            return archive;
        }
        Archive archive = archiveDao.findOne(id);
        operations.set(key, JSON.toJSONString(archive));
        LOGGER.info("将数据存入缓存>>{}", archive);
        return archive;
    }
}

