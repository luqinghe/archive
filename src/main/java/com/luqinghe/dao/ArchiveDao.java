package com.luqinghe.dao;

import com.luqinghe.vo.Archive;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by qinghe on 2017/12/17.
 * @author qinghe
 * @date 2017-12-28
 */
public interface ArchiveDao extends JpaRepository<Archive, Integer> {


    /**
     * 根据名字和年份查询数据
     *
     * @param stuName
     * @param year
     * @return List<Archive>
     */
    public List<Archive> findByStuNameAndYear(String stuName, Integer year);

}
