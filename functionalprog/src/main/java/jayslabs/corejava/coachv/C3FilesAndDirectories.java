package jayslabs.corejava.coachv;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class C3FilesAndDirectories {
    public static void main(String[] args) throws IOException {
        System.out.println("C3FilesAndDirectories");
        //testFilesAndDirectories();
        //listAllFilesInADir();
        //listSelectFilesInADir();
        //listSelectFiles2();
        listSubDirs();
    }

    public static void listSubDirs() throws IOException {
        System.out.println("listSubDirs()");
    
        List<File> files = Stream.of(new File(".").listFiles())
            .flatMap(file -> file.listFiles()==null ? Stream.of(file) :
            Stream.of(file.listFiles()))
            .collect(Collectors.toList());

            System.out.println("Count: " + files.size());

    }

    public static void listSelectFiles2() throws IOException {
        System.out.println("listSelectFiles2()");
    
        Files.newDirectoryStream(
            Paths.get("."), 
            path -> path.toString().endsWith(".java"))
        .forEach(System.out::println);
    }

    public static void listSelectFilesInADir() throws IOException {
        System.out.println("listSelectFilesInADir()");
    
        Files.list(Paths.get("."))
        .filter(path -> path.toString().endsWith(".java"))
        .forEach(System.out::println);
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
