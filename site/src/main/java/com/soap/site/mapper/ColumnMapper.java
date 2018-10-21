package com.soap.site.mapper;

import java.util.List;
import java.util.Map;

public interface ColumnMapper {

    List<Map<String,Object>> qryList(Map<String,Object> params);

    List<Map<String,Object>> qrySonList(Map<String,Object> params);

    List<Map<String,Object>> qryColumns(Map<String,Object> params);
}
