import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Game.drawSnakeOnBoard();
        Game.drawFrogsOnBoard();

        Scanner sc = new Scanner(System.in);
        while (true) {
            Board.print(Game.getReverseCount(), Game.getRemoveCount(), Game.getEaten());

            System.out.print("> ");
            String cmd = sc.nextLine();
            
            if (cmd.length() == 1 && "wasd".contains(cmd)) {
                Snake.move(cmd);
            } else if (cmd.equals("r")) {
                // reverse snake
            } else if (cmd.equals("e")) {
                // snake sheds it's skin
            } else if (cmd.equals("x")) {
                break;
            }
        }
        sc.close();
    }

}
