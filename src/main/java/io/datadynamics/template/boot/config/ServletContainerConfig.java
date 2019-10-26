package io.datadynamics.template.boot.config;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ServletContainerConfig {

	@Bean
	public ServletWebServerFactory servletContainer() {
		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
		tomcat.addAdditionalTomcatConnectors(createAjpConnector());
		return tomcat;
	}

	/**
	 * Apache Http Server와 통합하기 위해서 필요한 AJP 프로토콜을 활성화 한다.
	 */
	private Connector createAjpConnector() {
		Connector connector = new Connector("org.apache.coyote.ajp.AjpNioProtocol");
		connector.setPort(8009);
		return connector;
	}

}
