import java.io.File;                 
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File student_file = new File("students.txt");
        
        
        try (Scanner file_reader = new Scanner(student_file);
        PrintWriter writer = new PrintWriter("output.txt")) {
            
            writer.println("name, surname, \tavg\tfailing");

            while (file_reader.hasNextLine()) {
                String line = file_reader.nextLine();
                System.out.println(line);
            }
            
            Scanner line_scanner = new Scanner(student_file);

            String name = line_scanner.next(); // first token
            String surname = line_scanner.next(); // second

            double sum = 0;
            int count = 0;
            boolean failing = false;

            while (line_scanner.hasNextDouble()) {
                double grade = line_scanner.nextDouble();
                sum += grade;
                count++;
                if (grade < 4.0) {
                    failing = true;
                }
            }
            line_scanner.close();

            double avg = sum / count;

            //to write on the output file
            writer.printf("%s, %s, \t%.2f\t%b%n", name, surname, avg, failing); 
        }

        System.out.println("Output was created.");

        //exeptionn to double check if the file exists
        } catch (FileNotFoundException e) {
            System.out.println("File wasn't found");
        }
    }
}   
