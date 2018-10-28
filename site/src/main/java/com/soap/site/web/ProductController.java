package com.soap.site.web;

import com.soap.site.service.ColumnService;
import com.soap.site.service.ProductService;
import com.soap.site.util.Helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

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
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	ColumnService columnService;
	@Autowired
	ProductService productService;

	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("columnList", columnService.qryColumns(null));
		return "product.html";
	}


	@RequestMapping("/list")
	public String query(Model model, HttpServletRequest request) {/*,@RequestParam(value = "columnId") String columnId*/

		model.addAttribute("columnList", columnService.qryColumns(null));
		model.addAttribute("productList", productService.list(request.getParameter("columnId")));
		logger.info("{}",productService.list(request.getParameter("columnId")));
		return "product.html";
//		return Helper.retSucc(productService.list(columnId));

	}

	@RequestMapping("/detail")
	public String detail(Model model, HttpServletRequest request) {/*,@RequestParam(value = "columnId") String columnId*/

		model.addAttribute("columnList", columnService.qryColumns(null));
		Map<String, Object> consul = productService.detail(request.getParameter("consulId"));
		consul.put("context",new String((byte []) consul.get("context")));
		model.addAttribute("productList", consul);
		logger.info("{}", consul);
		return "blank.html";

	}


}

    