package dir_view;

import java.io.File;

public class DirView {

    public static void dirView(String path, String filter) {

        File f = new File(path);

        if (!f.isDirectory() || !f.exists())
            return;

        String[] list = f.list((dir, name) -> name.endsWith(filter));

        for (String string : list) {
            System.out.println(string);
        }

    }

    public static void main(String[] args) {

        dirView("D:\\Ubuntu", ".log");
    }

}
