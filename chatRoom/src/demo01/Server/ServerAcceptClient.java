package demo01.Server;


import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 接收客户端的内容: Server Receive Message From Client
 * 1.根据客户端Socket获取指向客户端Socket对象的输入流对象（输入源）
 * 2.通过输入流对象将客户端输入的信息读取到内存中
 * 3.通过输出流对象（System.out.print)将内存中的数据打印到控制台
 */
public class ServerAcceptClient extends Thread {

    private DataInputStream dataInputStream = null;

    public ServerAcceptClient(Socket socket) {
        try {
            // 获取客户端的输入流对象
            // socket.getInputStream 返回此套接字的输入流
            this.dataInputStream = new DataInputStream(socket.getInputStream());
        } catch (IOException io) {
            io.printStackTrace();
        }
    } // ServerAcceptClient end


    @Override
    public void run() {
        String messageFromClient;

        try {
            while (true) {
                // 将客户端发送的信息写入到内存中
                messageFromClient = this.dataInputStream.readUTF();
                // 将读取的客户端信息打印到控制台
                System.out.println("The Client Says: " + messageFromClient);
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
    } // run end

} // ServerAcceptClient end
