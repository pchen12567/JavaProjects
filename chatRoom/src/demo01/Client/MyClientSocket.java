package demo01.Client;

import java.io.IOException;
import java.net.Socket;

/**
 * 客户端socket
 * 1.根据IP和port获取和服务端连接的Socket对象
 * 2.通过服务端Socket对象获取指向服务端Socket对象的输入流/输出流，获取服务器端发送的信息或者向服务器发送消息
 */
public class MyClientSocket {

    public static void main(String[] args) {
        Socket serverSocket;

        try {
            serverSocket = new Socket("127.0.0.1", 8888);

            ClientToServer clientToServer = new ClientToServer(serverSocket);
            ClientAcceptServer clientAcceptServer = new ClientAcceptServer(serverSocket);

            clientToServer.start();
            clientAcceptServer.start();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

}
