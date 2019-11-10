package com.calligraphy.cg_user.config;


import com.calligraphy.common.util.HttpUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        return HttpUtil.configAllowAllCORS();
    }
}
