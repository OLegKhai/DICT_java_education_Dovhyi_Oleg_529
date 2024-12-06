package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        int waterPerCup = 200;
        int milkPerCup = 50;
        int beansPerCup = 15;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has:");
        int availableWater = scanner.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has:");
        int availableMilk = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int availableBeans = scanner.nextInt();

        System.out.println("Write how many cups of coffee you will need:");
        int requiredCups = scanner.nextInt();

        int possibleCupsByWater = availableWater / waterPerCup;
        int possibleCupsByMilk = availableMilk / milkPerCup;
        int possibleCupsByBeans = availableBeans / beansPerCup;

        int maxPossibleCups = Math.min(possibleCupsByWater, Math.min(possibleCupsByMilk, possibleCupsByBeans));

        if (requiredCups == 0) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (maxPossibleCups == requiredCups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (maxPossibleCups > requiredCups) {
            int extraCups = maxPossibleCups - requiredCups;
            System.out.println("Yes, I can make that amount of coffee (and even " + extraCups + " more than that)");
        } else {
            System.out.println("No, I can make only " + maxPossibleCups + " cups of coffee");
        }
    }
}
