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
            // 根据IP和port获取和服务端连接的Socket对象
            serverSocket = new Socket("127.0.0.1", 8888);

            //该线程用于向服务器端发送的消息
            ClientToServer clientToServer = new ClientToServer(serverSocket);

            // 该线程用于接收服务器端发送的消息，并将该消息打印到控制台
            ClientAcceptServer clientAcceptServer = new ClientAcceptServer(serverSocket);

            // 启动线程
            clientToServer.start();
            clientAcceptServer.start();

        } catch (IOException io) {
            io.printStackTrace();
        }
    }

}
