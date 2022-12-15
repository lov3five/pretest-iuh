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
                // MENU
                String menu = "\t-------------------MENU------------------------" +
                        "\n\t\t- 1. Chuyen chu thuong thanh chu in hoa     -" +
                        "\n\t\t- 2. In hoa ky tu dau. VD(tran thanh luong -> Tran Thanh Luong) -" +
                        "\n\t\t- 3. EXIT                  -" +
                        "\n\t\t-----------------------------------------------" +
                        "\n\t\tMoi chon:";
                String res = "Nhap chuoi can xu ly";
                do {
                    dos.writeUTF(menu);// Gửi MENU cho Client
                    String dataFromClient = dis.readUTF();
                    int luachon = Integer.parseInt(dataFromClient);
                    switch (luachon) {
                        case 1:
                            System.out.println("Client " + s.getPort() + " da chon phuong thuc: " + luachon);
                            dos.writeUTF(res);// Gui response cho client
                            String str1 = dis.readUTF();// Chuỗi cần xử lý
                            dos.writeUTF("Chuoi da xu ly: " + str1.toUpperCase());
                            break;
                        case 2:
                            System.out.println("Client " + s.getPort() + " da chon phuong thuc: " + luachon);
                            dos.writeUTF(res);// Gui response cho client
                            String str2 = dis.readUTF();// Chuỗi cần xử lý
                            str2 = str2.trim().replaceAll("\\s+", " ").toLowerCase();// format chuỗi thành chữ thường và
                                                                                     // // xóa khoảng trắng
                            String arrStr2[] = str2.split(" ");// Chuyển chuỗi thành mảng
                            String kq = "";
                            for (int i = 0; i < arrStr2.length; i++) {
                                kq += arrStr2[i].substring(0, 1).toUpperCase() + arrStr2[i].substring(1) + " ";
                            }
                            dos.writeUTF("Chuoi da xu ly: " + kq);
                            break;
                        case 3:
                            System.out.println("Client " + s.getPort() + " da chon phuong thuc: " + luachon);
                            System.out.println("Client " + s.getPort() + " disconnect!!!");
                            s.close();
                    }
                } while (true);
            }

        } catch (

        IOException ie) {
            System.out.println("Error: " + ie); // Thông báo lỗi
        }
    }
}
