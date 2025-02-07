package org.example.service;

import org.example.pojos.TestRequest;
import org.example.pojos.TestResponse;

public class TestServiceImpl implements TestService {
    @Override
    public TestResponse test(TestRequest request) {
        TestResponse testResponse = new TestResponse();
        testResponse.setMessage("success");
        testResponse.setUserid(request.getUserid());
        testResponse.setSeqid(request.getSeqid());
        return testResponse;
    }

    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
