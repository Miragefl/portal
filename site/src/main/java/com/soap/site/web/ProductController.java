package com.soap.site.web;

import com.soap.site.service.ColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 功能说明<br/>
 * 此处填写功能描述<br/>
 *
 * @author fenglei
 * @version 1.0
 * @Date 2018/10/27 16:36
 **/
@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ColumnService columnService;

	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("columnList", columnService.qryColumns(null));
		return "product.html";
	}


	@RequestMapping("/query")
	public String query(Model model) {
		return null;
	}


}

    