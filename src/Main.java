import java.util.Scanner;

import game.Game;
import game.GameStatus;
import person.Person;
import player.Player;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();

        Person john = new Person("John", "john.green@vlog.com");
        Person hank = new Person("Hank", "hank.green@vlog.bom");

        Player p1 = new Player(john, true);
        Player p2 = new Player(hank, false);

        game.startGame(p1, p2);

        while(game.getStatus() == GameStatus.ACTIVE) {

            String currPlayerName = game.getCurrPlayer().getPerson().getName();

            System.out.println(currPlayerName + ", enter your move");

            int startX = scanner.nextInt();
            int startY = scanner.nextInt();
            int endX = scanner.nextInt();
            int endY = scanner.nextInt();
            
            if(!game.playerMove(startX, startY, endX, endY)) {
                System.out.println("Invalid move, " + currPlayerName + " try again");
            }

            game.printBoard();
        }
        scanner.close();

        System.out.println("Game status: " + game.getStatus());        

    }
}
