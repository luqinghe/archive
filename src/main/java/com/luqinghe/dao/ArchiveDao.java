package com.luqinghe.dao;

import com.luqinghe.DO.Archive;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by qinghe on 2017/12/17.
 */
public interface ArchiveDao extends JpaRepository<Archive, Integer> {


    public List<Archive> findByStuNameAndYear(String stuName, Integer year);

}
