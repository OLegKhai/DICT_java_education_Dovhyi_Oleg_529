package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need:");
        int cups = scanner.nextInt();

        int waterPerCup = 200;
        int milkPerCup = 50;
        int beansPerCup = 15;

        int totalWater = cups * waterPerCup;
        int totalMilk = cups * milkPerCup;
        int totalBeans = cups * beansPerCup;

        System.out.println("For " + cups + " cups of coffee you will need:");
        System.out.println(totalWater + " ml of water");
        System.out.println(totalMilk + " ml of milk");
        System.out.println(totalBeans + " g of coffee beans");
    }
}
