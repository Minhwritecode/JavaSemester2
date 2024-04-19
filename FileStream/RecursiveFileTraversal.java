package FileStream;

import java.io.File;

public class RecursiveFileTraversal {
    public static void main(String[] args) {
        String directoryPath = "C:/path/to/directory"; 
        File directory = new File(directoryPath);
        if (directory.exists()) {
            System.out.println("Thư mục: " + directory.getAbsolutePath());
            traverseDirectory(directory, "");
        } else {
            System.out.println("Thư mục không tồn tại.");
        }
    }

    public static void traverseDirectory(File directory, String indent) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println(indent + "|-- Thư mục: " + file.getName());
                    traverseDirectory(file, indent + "   ");
                } else {
                    System.out.println(indent + "|-- Tệp tin: " + file.getName());
                }
            }
        }
    }
}