package tcp_echo;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    BufferedReader userIn;
    BufferedReader netIn;
    PrintWriter netOut;
    Socket socket;

    public Client() throws IOException {
        socket = new Socket("localhost", 2222);
        netIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        netOut = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    public static void main(String[] args) throws IOException {
        new Client().main_Process();
    }

    public void main_Process() throws IOException {
        String greeting = netIn.readLine();
        System.out.println(greeting);
        while (true) {
            userIn = new BufferedReader(new InputStreamReader(System.in));
            String command = userIn.readLine();
            netOut.println(command);
            netOut.flush();
            String respone = netIn.readLine();
            System.out.println(respone);
            if (respone.equalsIgnoreCase("Bye Client")) {
                netIn.close();
                netOut.close();
                userIn.close();
                break;
            }
        }

    }
}
