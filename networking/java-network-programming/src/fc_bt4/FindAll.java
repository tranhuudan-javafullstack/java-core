package fc_bt4;

import java.io.File;
import java.io.IOException;

public class FindAll {
    public static void findAll(String path, String... ext) throws IOException {
        File f = new File(path);
        if (!f.exists()) return;
        if (f.isFile()) {
            if (accept(f.getName(), ext))
                System.out.println(f.getCanonicalPath());
        }
        if (f.isDirectory()) {
            File[] files = f.listFiles();
            if (files != null) {
                for (File file : files) {
                    findAll(file.getCanonicalPath(), ext);
                }
            }
        }

    }

    private static boolean accept(String name, String[] ext) {
        for (String e : ext) {
            if (name.endsWith(e)) return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        String path = "C:\\\\Users\\\\TIEN\\\\Documents\\\\Zalo Received Files";
        String[] ext = new String[]{"pdf", "ext"};
        findAll(path, ext);
    }
}
