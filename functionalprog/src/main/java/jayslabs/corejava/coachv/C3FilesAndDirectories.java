package jayslabs.corejava.coachv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C3FilesAndDirectories {
    public static void main(String[] args) throws IOException {
        System.out.println("C3FilesAndDirectories");
        //testFilesAndDirectories();
        listAllFilesInADir();
    }

    public static void listAllFilesInADir() throws IOException {
        System.out.println("listAllFilesInADir()");
    
        Files.list(Paths.get("."))
        .forEach(System.out::println);
    }

        public static void listAllDirsInADir() throws IOException {
        System.out.println("listAllDirssInADir()");
    
        Files.list(Paths.get("."))
        .filter(Files::isDirectory)
        .forEach(System.out::println);
    }
}
