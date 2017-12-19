package com.luqinghe.dao;

import com.luqinghe.DO.Archive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by qinghe on 2017/12/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArchiveDaoTest {

    private final Logger log = LoggerFactory.getLogger(ArchiveDaoTest.class);

    @Autowired
    private ArchiveDao archiveDao;

    @Test
    public void findOneTest() {
        Archive archive = archiveDao.findOne(2);
        log.info(archive.toString());
    }

    @Test
    public void findByStuNameAndYearTest() {
        List<Archive> archives = archiveDao.findByStuNameAndYear("李楠",2017);
        log.info(archives.toString());
    }
}