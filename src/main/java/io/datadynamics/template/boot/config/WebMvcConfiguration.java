package io.datadynamics.template.boot.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    /**
     * SLF4J Logging
     */
    private Logger logger = LoggerFactory.getLogger(WebMvcConfiguration.class);

    @Value("${app.dev-mode:false}")
    boolean devMode;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        if (!devMode) {
            logger.info("서비스 URI에 Interceptor를 적용합니다.");

            // registry.addInterceptor(new TokenInterceptor()).addPathPatterns("/services/**");
        }
    }

}
