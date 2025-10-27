package Lab1.Main1;

import Lab1.Hero.Hero;
import Lab1.MovingType.FlightMove;
import Lab1.MovingType.HorseMove;
import Lab1.MovingType.OnFootMove;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        play();
    }

    static void play() {
        Scanner scanner = new Scanner(System.in);
        Hero hero = new Hero();

        String instruction = "Введите 1, 2 или 3 (для выхода введите 0):";
        int userInput;

        System.out.println(instruction);

        while (true) {
            if(scanner.hasNextInt()){
                userInput = scanner.nextInt();
                if (userInput == 0) {
                    System.out.println("Герой дошел.");
                    break;
                } else if (userInput == 1){
                    hero.setMoving(new OnFootMove());
                } else if (userInput == 2){
                    hero.setMoving(new HorseMove());
                } else if (userInput == 3){
                    hero.setMoving(new FlightMove());
                } else {
                    System.out.println("Герой так не умеет!");
                    continue;
                }

                hero.move();
            } else {
                System.out.println(instruction);
                scanner.next();
            }

        }
        scanner.close();
    }
}
