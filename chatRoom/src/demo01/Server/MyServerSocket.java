package demo01.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * socket实现聊天
 * 1.创建一个服务器端socket套接字（套接字会在制定的端口上监听）；
 * 2.使用ServerSocket中的accept()获取客户端socket对象
 * 3.使用多线程实现聊天：
 * 3.1) ServerAcceptClient 线程负责接收客户端发送给服务器端的消息；
 * 3.2) ServerToClient 线程负责向客户端发送消息
 */
public class MyServerSocket {

    public static void main(String[] args) {
        // 服务器端套接字：serverSocket
        ServerSocket serverSocket = null;

        // 客户端套接字：clientSocket
        Socket clientSocket = null;

        try {
            // 创建一个服务器端socket服务
            serverSocket = new ServerSocket(8888);
            System.out.println("服务器套接字已经创建成功");

            // 使用while死循环来模拟客户端一直启动
            while (true) {
                System.out.println("等待客户端的连接...");
                // 获取连接服务端的客户端 socket
                // accept()方法：阻塞方法，也就是说调用accept方法后程序会停下来等待连接请求
                // accept()方法会返回一个和客户端Socket对象相连的Socket对象
                clientSocket = serverSocket.accept();

                // 该线程用于接收客户端发送的消息，并将该消息打印到控制台
                ServerAcceptClient serverAcceptClient = new ServerAcceptClient(clientSocket);

                // 该线程用于向客户端发送的消息
                ServerToClient serverToClient = new ServerToClient(clientSocket);

                // 启动线程
                serverAcceptClient.start();
                serverToClient.start();
            }

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (clientSocket != null) {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    } // main end

} // MyServerSocket end

