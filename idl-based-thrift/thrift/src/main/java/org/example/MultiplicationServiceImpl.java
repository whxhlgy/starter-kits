package org.example;

import org.apache.thrift.TException;
import org.example.thrift.MultiplicationService;

public class MultiplicationServiceImpl implements MultiplicationService.Iface {
    @Override
    public int multiply(int n1, int n2) throws TException {
        System.out.println("received " + n1 + " and " + n2);
        return n1 * n2;
    }
}
