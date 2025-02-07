package org.example.service;

import com.facebook.drift.annotations.ThriftMethod;
import com.facebook.drift.annotations.ThriftService;
import org.example.pojos.TestRequest;
import org.example.pojos.TestResponse;

@ThriftService
public interface TestService {

    @ThriftMethod
    TestResponse test(TestRequest request);

    @ThriftMethod
    int add(int a, int b);
}
