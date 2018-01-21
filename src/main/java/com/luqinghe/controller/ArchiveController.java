package com.luqinghe.controller;

import com.luqinghe.vo.Archive;
import com.luqinghe.service.ArchiveService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by qinghe on 2017/12/17.
 * @author qinghe
 * @date 2017-12-28
 */
@Controller
public class ArchiveController {

    private static final Logger log = LoggerFactory.getLogger(ArchiveController.class);

    @Autowired
    private ArchiveService archiveService;

    @RequestMapping("/")
    public String showQueryHtml(ModelMap map){
        return "index";
    }

    /**
     * 从数据库中查询一条档案信息
     * @param year
     * @param stuName
     * @return
     */
    @ResponseBody
    @RequestMapping("/archive/info")
    public Archive getArchiveInfo(Integer year, String stuName) {
        log.info("year:{},stuName:{}", year, stuName);
        if (StringUtils.isBlank(stuName) || year == null) {
            return null;
        }
        List<Archive> archives = archiveService.findByStuNameAndYear(stuName, year);
        if (archives.size() > 0) {
            return archives.get(0);
        } else {
            return null;
        }
    }
}
