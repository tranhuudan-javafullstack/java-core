package file_class;

import java.io.File;
import java.io.IOException;

public class Bai2 {
    static public boolean accept(String f, String... ext) {
        for (String string : ext) {
            if (f.endsWith(string))
                return true;
        }
        return false;
    }

    void findAll(String path, String... ext) throws IOException {

        File f = new File(path);
        if (!f.exists())
            return;
        if (f.isFile()) {
            if (accept(f.getName(), ext))
                System.out.println(f.getCanonicalPath());
        }
        if (f.isDirectory()) {
            File[] content = f.listFiles();
            if (content != null)
                for (File f1 : content)
                    findAll(f1.getCanonicalPath(), ext);
        }

    }

}
