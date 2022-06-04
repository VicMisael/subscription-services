package com.misael.ascan.microserviceschallenge.config;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.util.Properties;

public class AppPropertiesWrapper {
    private static Properties props;

    private static Properties build() {
        Properties props;
        try {
            Resource resource = new ClassPathResource("/application.properties");
            props = PropertiesLoaderUtils.loadProperties(resource);
        } catch (Exception e) {
            props = new Properties();
        }
        return props;


    }

    public static String getProperty(String property) {
        if (props == null) {
            props = build();
        }
       return props.getProperty(property);

    }
}
