//package org.alvin.home.mvc.component;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.actuate.autoconfigure.ExportMetricReader;
//import org.springframework.boot.actuate.autoconfigure.ExportMetricWriter;
//import org.springframework.boot.actuate.endpoint.MetricsEndpointMetricReader;
//import org.springframework.boot.actuate.metrics.export.Exporter;
//import org.springframework.boot.actuate.metrics.export.MetricExportProperties;
//import org.springframework.boot.actuate.metrics.export.MetricExporters;
//import org.springframework.boot.actuate.metrics.reader.CompositeMetricReader;
//import org.springframework.boot.actuate.metrics.reader.MetricReader;
//import org.springframework.boot.actuate.metrics.statsd.StatsdMetricWriter;
//import org.springframework.boot.actuate.metrics.writer.GaugeWriter;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.SchedulingConfigurer;
//import org.springframework.scheduling.config.ScheduledTaskRegistrar;
//import org.springframework.util.CollectionUtils;
//
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Configuration
//@EnableScheduling
//@ConditionalOnProperty(value = "spring.metrics.export.enabled", matchIfMissing = true)
//@EnableConfigurationProperties
//public class MetricExportAutoConfiguration {
//
//    @Autowired
//    private MetricExportProperties properties;
//
//    @Autowired(required = false)
//    private MetricsEndpointMetricReader endpointReader;
//
//    @Autowired(required = false)
//    @ExportMetricReader
//    private List<MetricReader> readers;
//
//    @Autowired(required = false)
//    @ExportMetricWriter
//    private Map<String, GaugeWriter> writers;
//
//    @Autowired(required = false)
//    private Map<String, Exporter> exporters = Collections.emptyMap();
//
//    public MetricExportAutoConfiguration() {
//        writers = Collections.emptyMap();
//    }
//
//    @Bean
//    @ConditionalOnMissingBean(name = "metricWritersMetricExporter")
//    public SchedulingConfigurer metricWritersMetricExporter() {
//        Map<String, GaugeWriter> writers = new HashMap<String, GaugeWriter>();
//        MetricReader reader = this.endpointReader;
//        if (reader == null && !CollectionUtils.isEmpty(this.readers)) {
//            reader = new CompositeMetricReader(
//                    this.readers.toArray(new MetricReader[this.readers.size()]));
//        }
//        if (reader == null && this.exporters.isEmpty()) {
//            return new NoOpSchedulingConfigurer();
//        }
//        MetricExporters exporters = new MetricExporters(this.properties);
//        if (reader != null) {
//            writers.putAll(this.writers);
//            exporters.setReader(reader);
//            exporters.setWriters(writers);
//        }
//        exporters.setExporters(this.exporters);
//        return exporters;
//    }
//
//    @Bean
//    @ExportMetricWriter
//    @ConditionalOnMissingBean
//    @ConditionalOnProperty(prefix = "spring.metrics.export.statsd", name = "host")
//    public StatsdMetricWriter statsdMetricWriter() {
//        MetricExportProperties.Statsd statsdProperties = this.properties.getStatsd();
//        return new StatsdMetricWriter(statsdProperties.getPrefix(),
//                statsdProperties.getHost(), statsdProperties.getPort());
//    }
//
//    @Configuration
//    protected static class MetricExportPropertiesConfiguration {
//
//        @Value("${spring.application.name:application}.${random.value:0000}")
//        private String prefix = "";
//
//        private String aggregateKeyPattern = "k.d";
//
//        @Bean(name = "spring.metrics.export.CONFIGURATION_PROPERTIES")
//        @ConditionalOnMissingBean
//        public MetricExportProperties metricExportProperties() {
//            MetricExportProperties export = new MetricExportProperties();
//            export.getRedis().setPrefix("spring.metrics"
//                    + (this.prefix.length() > 0 ? "." : "") + this.prefix);
//            export.getAggregate().setPrefix(this.prefix);
//            export.getAggregate().setKeyPattern(this.aggregateKeyPattern);
//            return export;
//        }
//
//    }
//
//    private static class NoOpSchedulingConfigurer implements SchedulingConfigurer {
//
//        public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//        }
//
//    }
//
//}