package org.example;

import com.facebook.drift.client.DriftClient;
import com.facebook.drift.client.DriftClientFactory;
import com.facebook.drift.client.address.SimpleAddressSelector;
import com.facebook.drift.client.address.SimpleAddressSelectorConfig;
import com.facebook.drift.codec.ThriftCodecManager;
import com.facebook.drift.transport.netty.client.DriftNettyClientConfig;
import com.facebook.drift.transport.netty.client.DriftNettyMethodInvokerFactory;
import org.example.pojos.TestRequest;
import org.example.pojos.TestResponse;
import org.example.service.TestService;

public class Client {
    public static void main(String[] args) {
        SimpleAddressSelectorConfig config = new SimpleAddressSelectorConfig();
        config.setAddresses("localhost:8080");

        ThriftCodecManager thriftCodecManager = new ThriftCodecManager();
        SimpleAddressSelector simpleAddressSelector = new SimpleAddressSelector(config);

        DriftNettyClientConfig driftNettyClientConfig = new DriftNettyClientConfig();
        DriftNettyMethodInvokerFactory<?> methodInvokerFactory = DriftNettyMethodInvokerFactory
                .createStaticDriftNettyMethodInvokerFactory(driftNettyClientConfig);

        // client factory
        DriftClientFactory driftClientFactory = new DriftClientFactory(thriftCodecManager, methodInvokerFactory, simpleAddressSelector);

        DriftClient<TestService> driftClient = driftClientFactory.createDriftClient(TestService.class);

        TestRequest request = new TestRequest();
        request.setMessage("Hello World");
        request.setSeqid(1234);
        request.setUserid(111);
        TestResponse result  = driftClient.get().test(request);
        System.out.println(result);
    }
}
