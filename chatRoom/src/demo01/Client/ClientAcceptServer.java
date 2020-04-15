package demo01.Client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *接收客户端的信息：Client Receive Message From Server
 **/
public class ClientAcceptServer extends Thread {

    private DataInputStream dataInputStream = null;

    public ClientAcceptServer(Socket socket) {
        try {
            // 获取服务端的输入流对象
            // socket.getInputStream 返回此套接字的输入流
            this.dataInputStream = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String messageFromServer;
        while (true) {
            try {
                // 将服务器端发送的信息写入到内存中
                messageFromServer = this.dataInputStream.readUTF();
                // 将读取的服务器端信息打印到控制台
                System.out.println("The Server Says: " + messageFromServer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
