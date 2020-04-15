package demo01.Client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * 向服务端发送消息: Client Send Message to Server
 */
public class ClientToServer extends Thread {
    // 用于输出客户端发送给服务端的信息
    private DataOutputStream dataOutputStream = null;

    // 用于将客户端在控制台输入的信息读取到内存中
    private Scanner clientWrite = null;

    public ClientToServer(Socket socket) {
        try {
            // 根据客户端获取输出流对象
            // socket.getOutputStream: 返回此套接字的输出流
            this.dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // 获取控制台输入流对象
            this.clientWrite = new Scanner(System.in);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    @Override
    public void run() {
        String messageToServer;
        while (true) {
            try {
                // 将控制台中的信息读入到内存中
                messageToServer = clientWrite.nextLine();

                // 客户端向服务器端发送消息
                dataOutputStream.writeUTF(messageToServer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
