import java.io.File;                 
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File student_file = new File("students.txt");
        if (student_file.exists()) {
            System.out.println("File exists: " + student_file.getAbsolutePath());
        } else {
            System.out.println("File does not exist.");
        }
    }
}
