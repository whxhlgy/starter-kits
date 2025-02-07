from thrift.transport import TSocket, TTransport
from thrift.protocol import TBinaryProtocol
from tutorial.MultiplicationService import Client


def main():
    transport = TSocket.TSocket("localhost", 9090)
    transport = TTransport.TBufferedTransport(transport)
    protocol = TBinaryProtocol.TBinaryProtocol(transport)
    client = Client(protocol)
    transport.open()
    print("start client")
    _sum = client.multiply(1, 1000)
    print(_sum)


if __name__ == "__main__":
    main()
