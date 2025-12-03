import java.util.HashMap;
import java.util.Scanner;

public class PhoneBook {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<String, String> book;
        book = new HashMap<>();

        while (true) {
            String cmd = in.next();

            if (cmd.equals("add")) {
                String name = in.next();
                String number = in.next();
                book.put(number, name);
            }
            else if (cmd.equals("find")) {
                String num = in.next();
                String person = book.get(num);
                if (person == null) {
                    System.out.println("not found");
                } 
                else {
                    System.out.println(person);
                }
            }
            else if (cmd.equals("delete")) {
                String num = in.next();
                book.remove(num);
            }
            else if (cmd.equals("quit")) {
                break;
            }
        }

        in.close();
    }
}
