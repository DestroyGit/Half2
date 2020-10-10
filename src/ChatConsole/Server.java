package ChatConsole;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        final int PORT = 8189;

        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started");
            socket = server.accept();
            System.out.println("Client connected");

            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);



            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        String strServer = sc.nextLine();
                        out.println(strServer);
                    }
                }
            });

            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        String str = in.nextLine();
//                        if(str.equals("/end")){
//                            break;
//                        }
                        System.out.println("Client: " + str);
                    }
                }
            });

            t1.start();
            t2.start();

            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
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
