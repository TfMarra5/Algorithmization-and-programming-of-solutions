import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (
            Scanner file_reader = new Scanner(new File("students.txt"));
            FileWriter writer = new FileWriter("output.txt"))
            {
                //headline
                writer.write(
                    String.format("%-20s %-8s %-6s%n",
                        "name, surname",
                        "avg",
                        "failing"
                    )
                );

            while (file_reader.hasNextLine()) {
                String line = file_reader.nextLine().trim();
                if (line.isEmpty()) continue;

                try (Scanner line_scanner = new Scanner(line)) {

                    StringBuilder fullName = new StringBuilder();

                    double sum = 0;
                    int count = 0;
                    boolean failing = false;

                    while (line_scanner.hasNext() && !line_scanner.hasNextDouble()) {
                        if (fullName.length() > 0) {
                            fullName.append(" ");
                        }
                        fullName.append(line_scanner.next());
                    }

                    String nameSurname = fullName.toString().trim();
                    String name;
                    String surname;
                    String[] nameParts = nameSurname.split("\\s+");

                    if (nameParts.length >= 2) {
                        name = nameParts[0];
                        surname = nameParts[nameParts.length - 1];
                    } else if (nameParts.length == 1 && !nameParts[0].isEmpty()) {
                        name = nameParts[0];
                        surname = "";
                    } else {
                        continue;
                    }

                    while (line_scanner.hasNextDouble()) {
                        double grade = line_scanner.nextDouble();
                        sum += grade;
                        count++;
                        if (grade < 4.0) {
                            failing = true;
                        }
                    }
                    //to verify if student has grades in the students file
                    if (count > 0) {
                        double avg = sum / count;

                    //making sure data is aligned on output file
                    writer.write(
                        String.format("%-20s %-8s %-6s%n",
                            name + ", " + surname,
                            String.format("%.2f", avg),
                            failing)
                    );

                    } else {
                        System.out.println("Warning: No grades found for: " + nameSurname);
                    }
                }
            }

            System.out.println("Output created successfully in 'output.txt'.");

        } catch (FileNotFoundException e) {
            System.out.println("Error: students.txt file was not found.");

        } catch (IOException e) {
            System.out.println("Error writing to output.txt");
        }
    }
}
