package org.example;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.example.thrift.MultiplicationService;

public class Server {
    public static void main(String[] args) {
        try {
            MultiplicationService.Processor<MultiplicationServiceImpl> processor = new MultiplicationService.Processor<>(new MultiplicationServiceImpl());
            TServerTransport serverTransport = new TServerSocket(9090);
            TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));

            System.out.println("Starting the simple server...");
            server.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
