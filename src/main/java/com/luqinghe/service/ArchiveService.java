package com.luqinghe.service;

import com.luqinghe.DO.Archive;
import com.luqinghe.dao.ArchiveDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by qinghe on 2017/12/17.
 */
public interface ArchiveService {

    /**
     * 根据姓名和毕业年份查询档案信息
     * @param stuName
     * @param year
     * @return
     */
    public List<Archive> findByStuNameAndYear(String stuName, Integer year);

    /**
     * 根据id查询档案信息
     * @param id
     * @return
     */
    public Archive findById(Integer id);
}
