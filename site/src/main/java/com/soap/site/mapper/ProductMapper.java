package com.soap.site.mapper;

import java.util.List;
import java.util.Map;

public interface ProductMapper {

	List<Map<String,Object>> list(Map<String,Object> params);

	Map<String,Object> detail(String consulId);

	int count(String columnId);

	Map<String,Object> columnDetail(String columnId);
	Map<String,Object> qryConsulByColumnId(String columnId);
}
