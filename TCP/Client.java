package TCP;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        int SERVER_PORT = 12345;
        String SERVER_IP = "127.0.0.5";

        try {
            Socket s = new Socket(SERVER_IP, SERVER_PORT);
            System.out.println("Client " + s.getPort() + " created...");
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            Scanner sc = new Scanner(System.in);

            while (true) {
                String dataFromServer = dis.readUTF();
                System.out.println("Server: " + dataFromServer);

                System.out.println("Chon phuong thuc (1, 2 or 3): ");
                String luachon = sc.nextLine();
                dos.writeUTF(luachon);//gửi lựa chọn lên Server

                System.out.print(dis.readUTF());//Nhận phản hồi yêu cầu nhập chuỗi
                String str1 = sc.nextLine();
                dos.writeUTF(str1);//Gửi chuỗi cần xử lý lên Server

                //Kết quả từ Server
                String result = dis.readUTF();
                System.out.println(result);

            }

        } catch (IOException ie) {
            System.out.println("Error: " + ie);
        }

    }

}
