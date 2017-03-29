package org.alvin.mvc.config.root;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by tangzhichao on 2016/8/16.
 */
@Configuration
@ComponentScan(basePackages = {//
        "org.alvin.mvc.system.service",
        "org.alvin.mvc.system.listener"
})
@PropertySource(value = { //
        "classpath:jdbc.properties",//
        "classpath:application.properties"
})
public class ApplicationConfiguration {

    public ApplicationConfiguration() {

    }
}
