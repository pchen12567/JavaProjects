package demo01.Server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * 向客户端发送的消息: Server Send Message to Client
 * 1.根据客户端Socket获取指向客户端Socket对象的输出流对象（输出目的地）
 * 2.获取控制台输入流对象（输入源）
 * 3.通过输入流对象将控制台输入的信息读取到内存中
 * 4.通过输出流对象将内存中的数据返回给服务器端
 */
public class ServerToClient extends Thread {

    // 用于输出服务器返回给客户端的信息
    private DataOutputStream dataOutputStream = null;

    // 用于将服务器端在控制台输入的信息读取到内存中
    private Scanner serverWrite = null;

    public ServerToClient(Socket socket) {
        try {
            // 根据客户端获取输出流对象
            // socket.getOutputStream: 返回此套接字的输出流
            this.dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // 获取控制台输入流对象
            serverWrite = new Scanner(System.in);

        } catch (IOException e) {
            e.printStackTrace();
        }
    } // ServerToClient end

    @Override
    public void run() {
        String messageToClient;

        while (true) {
            try {
                // 将控制台中的信息读入到内存中
                messageToClient = serverWrite.nextLine();

                // 服务器端向客户端发送消息
                this.dataOutputStream.writeUTF(messageToClient);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    } // run end

} // ServerToClient end
