//package org.alvin.home.mvc.component;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.actuate.autoconfigure.*;
//import org.springframework.boot.actuate.endpoint.MetricReaderPublicMetrics;
//import org.springframework.boot.actuate.endpoint.RichGaugeReaderPublicMetrics;
//import org.springframework.boot.actuate.endpoint.SystemPublicMetrics;
//import org.springframework.boot.actuate.metrics.reader.CompositeMetricReader;
//import org.springframework.boot.actuate.metrics.reader.MetricReader;
//import org.springframework.boot.actuate.metrics.rich.RichGaugeReader;
//import org.springframework.boot.actuate.metrics.statsd.StatsdMetricWriter;
//import org.springframework.boot.autoconfigure.AutoConfigureAfter;
//import org.springframework.boot.autoconfigure.AutoConfigureBefore;
//import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
//import org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@ConfigurationProperties
//@AutoConfigureBefore(EndpointAutoConfiguration.class)
//@AutoConfigureAfter({ DataSourceAutoConfiguration.class, CacheAutoConfiguration.class,
//        MetricRepositoryAutoConfiguration.class, CacheStatisticsAutoConfiguration.class,
//        IntegrationAutoConfiguration.class })
//public class PublicMetricsAutoConfiguration {
//
//    @Autowired(required = false)
//    @ExportMetricReader
//    private List<MetricReader> metricReaders =  new ArrayList<MetricReader>();
//
//    @Bean
//    public SystemPublicMetrics systemPublicMetrics() {
//        return new SystemPublicMetrics();
//    }
//
//    @Bean
//    public MetricReaderPublicMetrics metricReaderPublicMetrics() {
//        return new MetricReaderPublicMetrics(new CompositeMetricReader(
//                this.metricReaders.toArray(new MetricReader[0])));
//    }
//
//    @Bean
//    @ConditionalOnBean(RichGaugeReader.class)
//    public RichGaugeReaderPublicMetrics richGaugePublicMetrics(
//            RichGaugeReader richGaugeReader) {
//        return new RichGaugeReaderPublicMetrics(richGaugeReader);
//    }
//
//    @Bean
//    @ExportMetricWriter
//    public StatsdMetricWriter statsdMetricWriter(
//            @Value("${spring.metrics.export.statsd.host}") String host,
//            @Value("${spring.metrics.export.statsd.port}") int port,
//            @Value("${spring.metrics.export.statsd.prefix}") String prefix
//    ) {
//        return new StatsdMetricWriter(prefix, host, port);
//    }
//
////    @Configuration
////    @ConditionalOnClass(DataSource.class)
////    @ConditionalOnBean(DataSource.class)
////    static class DataSourceMetricsConfiguration {
////
////        @Bean
////        @ConditionalOnMissingBean
////        @ConditionalOnBean(DataSourcePoolMetadataProvider.class)
////        public DataSourcePublicMetrics dataSourcePublicMetrics() {
////            return new DataSourcePublicMetrics();
////        }
////
////    }
//
////    @Configuration
////    @ConditionalOnClass({ Servlet.class, ServerProperties.Tomcat.class })
////    @ConditionalOnWebApplication
////    static class TomcatMetricsConfiguration {
////
////        @Bean
////        @ConditionalOnMissingBean
////        public TomcatPublicMetrics tomcatPublicMetrics() {
////            return new TomcatPublicMetrics();
////        }
////
////    }
//
//}