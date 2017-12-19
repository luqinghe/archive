package com.luqinghe.service.impl;

import com.luqinghe.DO.Archive;
import com.luqinghe.service.ArchiveService;
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
public class ArchiveServiceImplTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArchiveServiceImplTest.class);

    @Autowired
    private ArchiveService archiveService;

    @Test
    public void findByStuNameAndYearTest() throws Exception {
        List<Archive> archives = archiveService.findByStuNameAndYear("1",1);
//        LOGGER.info(archives.toString());
        assertTrue(archives.size() == 0);
    }

    @Test
    public void findByIdTest() {
        Archive archive = archiveService.findById(2);
        LOGGER.info("test---over>>{}", archive);
        assertNotNull(archive);
    }

}