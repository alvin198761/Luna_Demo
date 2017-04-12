package org.alvin.home.mvc.component;

import org.crsh.plugin.ServiceLoaderDiscovery;

/**
 * Created by tangzhichao on 2017/4/12.
 */
public class CrashDiscovery extends ServiceLoaderDiscovery {
    /**
     * Create a new instance.
     *
     * @param classLoader the loader for the discovery
     * @throws NullPointerException if the loader argument is null
     */
    public CrashDiscovery(ClassLoader classLoader) throws NullPointerException {
        super(classLoader);
    }

//    @Override
//    public Iterable<CRaSHPlugin<?>> getPlugins() {
//        ArrayList<CRaSHPlugin<?>> plugins = (ArrayList<CRaSHPlugin<?>>) super.getPlugins();
//        plugins.add(new CronPlugin());
//        plugins.add(new MailPlugin());
//        return plugins;
//    }
}
