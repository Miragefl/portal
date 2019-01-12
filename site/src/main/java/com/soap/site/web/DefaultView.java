package com.soap.site.web;

import com.soap.site.service.ColumnService;
import com.soap.site.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

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
    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String index(Model model) {
        List<Map<String, Object>> list = columnService.qryColumns(null);
        model.addAttribute("columnList", list);
        List<Map<String, Object>> GCSLList = productService.queryGCSL();
        model.addAttribute("GCSLList", GCSLList);
        logger.info("=========columnList========{}\n=========GCSLList========{}", list,GCSLList);
        return "index.html";
    }
}
