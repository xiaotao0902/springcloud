package com.tony.spring.boot.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix="spring") //application.yml中的myProps下的属性    
public class DatasourceConfig {  
    
    private Map<String, String> datasource = new HashMap<>();

	public Map<String, String> getDatasource() {
		return datasource;
	}

	public void setDatasource(Map<String, String> datasource) {
		this.datasource = datasource;
	}    
} 