package io.datadynamics.template.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

/**
 * Spring Session Boot Configuration.
 */
@Configuration
@EnableJdbcHttpSession
public class HttpSessionConfiguration extends AbstractHttpSessionApplicationInitializer {
}