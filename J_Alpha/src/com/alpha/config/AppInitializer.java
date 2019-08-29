package com.alpha.config;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
    	System.out.println("getServletConfigClasses");
        return new Class[0];
    }

    protected String[] getServletMappings() {
    	System.out.println("getServletMappings");
        return new String[]{"/"};
    }
}
