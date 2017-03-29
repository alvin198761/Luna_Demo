package org.alvin.home.mvc.component;//package com.sample.springApp.component;
//
//import java.io.IOException;
//import java.nio.file.FileStore;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.actuate.health.AbstractHealthIndicator;
//import org.springframework.boot.actuate.health.Health;
//import org.springframework.boot.actuate.health.HealthIndicator;
//import org.springframework.stereotype.Component;
//
///**
// * A {@link HealthIndicator} that checks for available disk space.
// *
// * @author Mattias Severson
// * @since 1.2.0
// */
//@Component
//public class DiskSpaceHealthIndicator extends AbstractHealthIndicator {
//    private static Log logger = LogFactory.getLog(DiskSpaceHealthIndicator.class);
//
//    private final FileStore fileStore;
//    private final long thresholdBytes;
//
//    /**
//     * Constructor.
//     * @param path The path to a directory for checking available disk space. The
//     *                application must have read access to this path. Additionally, the
//     *                {@link java.lang.SecurityManager#checkRead(String)} will be called
//     *                if a security manager is used.
//     *                By default, it uses the system property {@code user.dir}, i.e. the
//     *                current directory when the JVM was started.
//     * @param thresholdBytes The threshold (in Bytes) of remaining disk space that will
//     *                          trigger this health indicator when exceeded.
//     *                          Default value is 10 MB.
//     * @throws IOException If an IOException occurs.
//     */
//    @Autowired
//    public DiskSpaceHealthIndicator(@Value("${health.path?:${user.dir}}") String path,
//                                    @Value("${health.threshold.bytes:10485760}") long thresholdBytes)
//            throws IOException {
//        this.fileStore = Files.getFileStore(Paths.get(path));
//        this.thresholdBytes = thresholdBytes;
//    }
//
//    @Override
//    protected void doHealthCheck(Health.Builder builder) throws Exception {
//        long diskFreeInBytes = this.fileStore.getUnallocatedSpace();
//        if (diskFreeInBytes >= this.thresholdBytes) {
//            builder.up();
//        } else {
//            logger.warn(String.format("Free disk space threshold exceeded. " +
//                            "Available: %d bytes (threshold: %d bytes).",
//                    diskFreeInBytes, this.thresholdBytes));
//            builder.down();
//        }
//    }
//}
