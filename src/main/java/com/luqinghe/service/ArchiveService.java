package com.luqinghe.service;

import com.luqinghe.vo.Archive;

import java.util.List;

/**
 * Created by qinghe on 2017/12/17.
 * @author qinghe
 * @date 2017-12-28
 */
public interface ArchiveService {

    /**
     * 根据姓名和毕业年份查询档案信息
     * @param stuName 学生姓名
     * @param year 年份
     * @return
     */
    public List<Archive> findByStuNameAndYear(String stuName, Integer year);

    /**
     * 根据id查询档案信息
     * @param id 主键
     * @return
     */
    public Archive findById(Integer id);
}
