package TCP;

import java.io.*;
import java.net.*;

public class Server {
    public final static int SERVER_PORT = 12345;

    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            ServerSocket ss = new ServerSocket(SERVER_PORT); // Khởi tạo Server socket
            System.out.println("Server created...");

            while (true) {
                Socket s = ss.accept(); // Chờ client kết nối và accept
                System.out.println("Client " + s.getPort() + " connected");// Thông báo client kết nối
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());

                /*
                 * String str = "TranThanhLuong";
                 * String arrStr[] = str.split(str);//chuyển chuỗi thành mảng
                 */

                while (true) {

                    for(int i = 0; i <= 10; i++){
                        dos.writeUTF(String.valueOf(i));
                        Thread.sleep(500);
                    }
                    String dataFromClient = dis.readUTF();
                    if (dataFromClient.equals("exit")) {
                        System.out.println("Client " + s.getPort() + " disconnect!!!");
                    }
                }
                /*
                 * dis.close();
                 * dos.close();
                 * ss.close();
                 * s.close();
                 */

            }

        } catch (

        IOException ie) {
            System.out.println("Error: " + ie); // Thông báo lỗi
        }
    }
}
