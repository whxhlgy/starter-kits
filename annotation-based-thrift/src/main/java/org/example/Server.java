package org.example;

import com.facebook.drift.codec.ThriftCodecManager;
import com.facebook.drift.server.DriftServer;
import com.facebook.drift.server.DriftService;
import com.facebook.drift.server.stats.NullMethodInvocationStatsFactory;
import com.facebook.drift.transport.netty.server.DriftNettyServerConfig;
import com.facebook.drift.transport.netty.server.DriftNettyServerTransportFactory;
import com.google.common.collect.ImmutableSet;
import org.example.service.TestService;
import org.example.service.TestServiceImpl;

public class Server {
    public static void main(String[] args) {
        TestService service = new TestServiceImpl();

        DriftNettyServerConfig config = new DriftNettyServerConfig();
        config.setPort(8080);
        DriftServer driftServer = new DriftServer(
                new DriftNettyServerTransportFactory(config),
                new ThriftCodecManager(),
                new NullMethodInvocationStatsFactory(),
                ImmutableSet.of(new DriftService(service)),
                ImmutableSet.of());
        driftServer.start();
    }
}
