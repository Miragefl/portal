package com.soap.site.web;

import com.soap.site.service.ColumnService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author fenglei
 * @Date 2018/10/2
 * @Version 1.0
 **/
@Controller
@RequestMapping("/")
public class DefaultView {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ColumnService columnService;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("columnList",columnService.qryColumns(null));
        logger.info("================={}",columnService.qryColumns(null));
        return "index.html";
    }
}
