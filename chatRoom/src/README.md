## Demo 01 Simple Chatroom: socket + thread

### Socket
- IP协议对应于网络层，TCP协议对应于传输层，而HTTP协议对应于应用层。
- TCP/IP协议是传输层协议，主要解决数据如何在网络中传输，而HTTP协议是应用层协议，主要解决如何包装数据。

1. 什么是socket
    - socket就是网络通信的工具，任何一门语言都有socket，他不是任何一个语言的专有名词，
    而是通过自己的程序与其他电脑进行网络通信的时候都用它。
    - 实际上socket是对TCP/IP协议的封装，它的出现只是使得程序员更方便地使用TCP/IP协议栈而已。
    socket本身并不是协议，它是应用层与TCP/IP协议族通信的中间软件抽象层，是一组调用接口（TCP/IP网络的API函数）。
    - socket非常类似于电话插座。以一个国家级电话网为例。电话的通话双方相当于相互通信的2个进程，
    区号是它的网络地址；区内一个单位的交换机相当于一台主机，主机分配给每个用户的局内号码相当于socket号。
    任何用户在通话之前，首先要占有一部电话机，相当于申请一个socket；同时要知道对方的号码，
    相当于对方有一个固定的socket。然后向对方拨号呼叫，相当于发出连接请求。对方假如在场并空闲，
    拿起电话话筒，双方就可以正式通话，相当于连接成功。双方通话的过程，
    是一方向电话机发出信号和对方从电话机接收信号的过程，相当于向socket发送数据和从socket接收数据。
    通话结束后，一方挂起电话机相当于关闭socket，撤消连接。

2. Socket的TCP和UDP通信<br>
    socket有两种建立通信的方式，一种是基于TCP的可靠传输，一种是基于UDP的不可靠传输
    - TCP
        - 可靠的、面向连接的协议（eg:打电话）、传输效率低全双工通信（发送缓存&接收缓存）、面向字节流。
        使用TCP的应用：Web浏览器；文件传输程序。
        - 面向连接的协议，在socket之间进行数据传输之前必须要建立连接，所以在TCP中需要连接时间
        - TCP传输数据无大小限制，一旦建立连接，双方socket就可以按统一的格式传输大的数据（无限制）。
        - TCP是一个可靠的协议，它确保接收方完全正确地获取发送方所发送的全部数据。
    - UDP
        - 不可靠的、无连接的服务，传输效率高（发送前时延小），一对一、一对多、多对一、多对多、面向报文(数据包)，
        尽最大努力服务，无拥塞控制。使用UDP的应用：域名系统 (DNS)；视频流；IP语音(VoIP)。
        - 每个数据包中都给出了完整的地址信息，因此无需建立发送方和接收方的连接。
        - UDP传输数据时是有大小限制的，每个被传输的数据包必须限定在64KB之内。
        - UDP是一个不可靠的协议，发送方所发送的数据包并不一定以相同的顺序到达接收方。

### 基于TCP实现
1. 服务器端 [Server](https://github.com/pchen12567/JavaProjects/tree/master/chatRoom/src/demo01/Server)
    - MyServerSocket：
        - 创建一个服务器端socket套接字（套接字会在制定的端口上监听）；
        - 使用ServerSocket中的accept()获取客户端socket对象；
    - 使用多线程实现聊天：
        - ServerAcceptClient 线程负责接收客户端发送给服务器端的消息；
        - ServerToClient 线程负责向客户端发送消息；
2. 客户端 [Client](https://github.com/pchen12567/JavaProjects/tree/master/chatRoom/src/demo01/Client)
    - MyClientSocket：
        - 根据IP和port获取和服务端连接的Socket对象；
        - 通过服务器端Socket对象获取指向服务端Socket对象的输入流/输出流；
    - 使用多线程实现聊天：
        - ClientAcceptServer 线程负责接服务端发送给客户端端的消息；
        - ClientToServer 线程负责向服务器端发送消息；