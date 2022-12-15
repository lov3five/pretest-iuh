package TCP;

import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) throws IOException {
        int SERVER_PORT = 12345;
        String SERVER_IP = "127.0.0.5";

        try {
            Socket s = new Socket(SERVER_IP, SERVER_PORT);
            System.out.println("Client " + s.getPort() + " created...");
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            
            while (true) {
                String dataFromServer = dis.readUTF();
                System.out.println("Server: " + dataFromServer);
            }

        } catch (IOException ie) {
            System.out.println("Error: " + ie);
        }

    }

}
