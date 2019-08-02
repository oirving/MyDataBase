package DBClient;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {
    private  static String message =  " ";

    public static void main(String[] args) throws Exception{
        // 要连接的服务端IP地址和端口
        String host = "127.0.0.1";
        int port = 1521;

        while (!message.equals("dead")) {
            // 与服务端建立连接
            Socket socket = new Socket(host, port);
            Scanner input = new Scanner(System.in);
            // 建立连接后获得输出流
            System.out.println("请输入合法的SQL语句进行查询(输入dead退出)");
            OutputStream outputStream = socket.getOutputStream();
            message = input.nextLine().toLowerCase();
            socket.getOutputStream().write(message.getBytes("UTF-8"));
            socket.shutdownOutput();

            //接收返回的数据
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            StringBuilder sb = new StringBuilder();
            while ((len = inputStream.read(bytes)) != -1) {
                sb.append(new String(bytes, 0, len, "UTF-8"));
            }
            System.out.println(sb);
            inputStream.close();
            outputStream.close();
            socket.close();
        }
    }
}
