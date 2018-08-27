package com.tony.spring.boot.eureka;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import com.tony.spring.boot.utils.DatasourceConfig;

@Component
public class MyHealthIndicator implements HealthIndicator {
	
	@Autowired  
	private DatasourceConfig datasourceConfig;  

	public Health health() {
		if(testDB()) {
			return new Health.Builder(Status.UP).build();
		} else {
			return new Health.Builder(Status.DOWN).build();
		}
	}
    public boolean testDB() {
    	Map<String, String> dbconfig = 	datasourceConfig.getDatasource();
    	
    	boolean result = false;
        String driverName = dbconfig.get("driver-class-name");
        String url = dbconfig.get("url");
        String user = dbconfig.get("username");
        String password = dbconfig.get("password");

        try {
            Class.forName(driverName);
            DriverManager.getConnection(url, user, password);
            result = true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
