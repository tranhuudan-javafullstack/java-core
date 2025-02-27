package iostream;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

public class dos_dis {
    private static String myReadUTF(RandomAccessFile raf) throws IOException {
        int size = raf.readShort();
        byte[] buff = new byte[size];
        raf.read(buff);
        return new String(buff, StandardCharsets.UTF_8);
    }

    public static void main(String[] args) throws IOException {

        String name = "Nguyễn Thị Hoa Hồng";
        String path = "d:\\temp\\ltm\\st";

        FileOutputStream fos = new FileOutputStream(path);
        DataOutputStream dos = new DataOutputStream(fos);
        dos.writeInt(123456789);
        dos.writeUTF(name);

        dos.close();

//		RandomAccessFile raf = new RandomAccessFile(path, "rw");
//		raf.writeShort(23);
//		raf.close();

        RandomAccessFile raf = new RandomAccessFile(path, "rw");
        System.out.println(raf.readInt());
        System.out.println(myReadUTF(raf));
        raf.close();
    }

}
