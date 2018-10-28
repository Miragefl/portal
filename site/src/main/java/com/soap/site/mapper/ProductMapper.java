package com.soap.site.mapper;

import java.util.List;
import java.util.Map;

public interface ProductMapper {

	List<Map<String,Object>> list(String columnId);

	Map<String,Object> detail(String consulId);
}
