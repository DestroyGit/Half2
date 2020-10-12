package ChatConsole;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket clientSocket = null;
        final int PORT = 8189;
        String ip = "192.168.0.11";

        try {
            clientSocket = new Socket(ip, 8189);
            System.out.println("Connect!");

            Scanner in = new Scanner(clientSocket.getInputStream());
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);

            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        String client = sc.nextLine();
                        out.println(client);
                    }
                }
            });

            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        String str = in.nextLine();
                        System.out.println("Server: " + str);
                    }

                }
            });

            t1.start();
            t2.start();

            t1.join();
            t2.join();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }


        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
