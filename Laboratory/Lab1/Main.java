import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Game.drawSnakeOnBoard();
        Game.drawFrogsOnBoard();

        Scanner sc = new Scanner(System.in);
        while (Game.isRunning()) {
            Board.print(Game.getReverseCount(), Game.getRemoveCount(), Game.getEaten());
            System.out.print("> ");
            String cmd = sc.nextLine();

            if (cmd.length() == 1 && "wasd".contains(cmd)) {
                Snake.move(cmd);
            } else if (cmd.equals("r")) {
                Snake.reverseBoth();
            } else if (cmd.equals("e")) {
                Snake.toggleSkin();
            } else if (cmd.equals("x")) {
                break;
            }
        }
        sc.close();
    }
}
