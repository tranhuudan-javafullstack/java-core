package exr2;

import java.io.File;

public class Dir {
    public static void dirTree(String path) {
        File dir = new File(path);
        if (!dir.exists()) return;
        int level = 0;
        if (dir.isFile()) printFile(dir, level);
        if (dir.isDirectory()) dirTreeHelper(dir, level);
    }

    private static void dirTreeHelper(File dir, int level) {
        printDir(dir, level);
        File[] list = dir.listFiles();
        for (File f : list) {
            if (f.isDirectory()) dirTreeHelper(f, level + 1);
        }
        for (File f : list) {
            if (f.isFile()) printFile(f, level + 1);
        }
    }

    private static void printDir(File dir, int level) {
        StringBuilder sb = getIndent(level);
        sb.append(dir.getName().toUpperCase());
        System.out.println(sb);
    }

    private static void printFile(File dir, int level) {
        StringBuilder sb = getIndent(level);
        sb.append(dir.getName().toLowerCase());
        System.out.println(sb);
    }

    private static StringBuilder getIndent(int level) {
        StringBuilder sb = new StringBuilder();
        if (level == 0) {
            sb.append("+-");
        } else {
            sb.append("   ");
            sb.append("|  ".repeat(Math.max(0, level - 1)));
            sb.append("+-");
        }
        return sb;
    }

    public static void main(String[] args) {
        String path = "C:\\Users\\TIEN\\Documents\\Zalo Received Files";
        dirTree(path);
    }

}
