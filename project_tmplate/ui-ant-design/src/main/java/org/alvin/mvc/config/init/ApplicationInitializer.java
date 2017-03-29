package org.alvin.mvc.config.init;

import org.alvin.mvc.config.jpa.JpaConfiguration;
import org.alvin.mvc.config.root.ApplicationConfiguration;
import org.alvin.mvc.config.security.GlobelSecurityConfig;
import org.alvin.mvc.config.security.SecurityConfiguration;
import org.alvin.mvc.config.servlet.ServletConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by tangzhichao on 2016/8/16. web 系统启动的时候会先加载这个类作为启动类
 */
public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {
				ApplicationConfiguration.class ,
				JpaConfiguration.class,
				SecurityConfiguration.class,
				GlobelSecurityConfig.class
		};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { ServletConfiguration.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
}
