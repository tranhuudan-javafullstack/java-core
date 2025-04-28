package upload;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadServer {
    public static void main(String[] args) throws IOException {
        ServerSocket s = new ServerSocket(2000);
        while (true) {
            Socket socket = s.accept();
            UploadProcess up = new UploadProcess(socket);
            up.start();
        }

    }
}