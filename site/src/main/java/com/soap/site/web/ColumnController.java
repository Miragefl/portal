package com.soap.site.web;

import com.soap.site.service.ColumnService;
import com.soap.site.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能说明<br/>
 * 此处填写功能描述<br/>
 *
 * @author fenglei
 * @Date 2018/10/28 14:27
 * @version 1.0
 **/
@Controller
@RequestMapping("/column")
public class ColumnController {

	@Autowired
	private ColumnService columnService;

	@RequestMapping("/query")
	@ResponseBody
	public String query() {
		Map<String,Object> params = new HashMap<String, Object>();
//		params.put("columnId",columnId);
		return Helper.retSucc(columnService.qryColumns(params));
	}

}

    