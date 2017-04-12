package org.alvin.home.mvc.component;

import org.crsh.plugin.PluginDiscovery;
import org.crsh.plugin.ServiceLoaderDiscovery;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;

/**
 * Created by tangzhichao on 2017/4/12.
 */
@WebListener
public class CrashWebListener extends org.crsh.plugin.WebPluginLifeCycle {

    @Override
    protected PluginDiscovery createDiscovery(ServletContext context, ClassLoader classLoader) {
        return new CrashDiscovery(classLoader);
    }
}
