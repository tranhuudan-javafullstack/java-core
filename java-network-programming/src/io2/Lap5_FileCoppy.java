package io;

import java.io.*;

public class Lap5_FileCoppy {
    public static boolean fileCopy(String sFile, String destFile, boolean move) throws IOException {
        File sf = new File(sFile);
        File df = new File(destFile);
        if (!sf.exists()) return false;
        if (sf.exists() && sf.isFile()) {
            InputStream fis = new BufferedInputStream(new FileInputStream(sf));
            OutputStream fos = new BufferedOutputStream(new FileOutputStream(df));
            byte[] b = new byte[1024];

            while (fis.read() != -1)
                fos.write(b);
            fis.close();
            fos.close();
            if (move)
                sf.delete();

        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        String source = "C:\\Users\\TIEN\\Documents\\Zalo Received Files\\tien.docx";
        String dest = "C:\\Users\\TIEN\\Documents\\Zalo Received Files\\t.doc";
//	coppyFile(source, dest);
        fileCopy(source, dest, true);
    }
}
