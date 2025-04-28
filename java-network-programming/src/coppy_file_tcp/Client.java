package coppy_file_tcp;

import java.io.*;
import java.net.Socket;
import java.util.StringTokenizer;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 2222);
        BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        String line = userIn.readLine();
        StringTokenizer st = new StringTokenizer(line);
        st.nextToken();
        String sFile = st.nextToken();
        String dFile = st.nextToken();
        dos.writeUTF(dFile);
        dos.flush();
        int error = dis.readInt();
        if (error != 0) {
            socket.close();
            return;
        }
        InputStream fis = new BufferedInputStream(new FileInputStream(sFile));
        byte[] buff = new byte[10240];
        int byteRead;
        while ((byteRead = fis.read(buff)) != -1)
            dos.write(buff, 0, byteRead);
        dos.flush();
        fis.close();
        socket.close();

    }

}
