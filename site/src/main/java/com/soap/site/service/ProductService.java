package com.soap.site.service;

import com.soap.site.mapper.ProductMapper;
import com.soap.site.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 功能说明<br/>
 * 此处填写功能描述<br/>
 *
 * @author fengleiA
 * @Date 2018/10/28 14:51
 * @version 1.0
 **/
@Service
public class ProductService {

	@Autowired
	private ProductMapper productMapper;

	public List<Map<String,Object>> list(String columnId) {
		return productMapper.list(columnId);
	}


	public Map<String,Object> detail(String consulId) {
		return productMapper.detail(consulId);
	}
}

    