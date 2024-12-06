package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {

    private static int water = 400;
    private static int milk = 540;
    private static int coffeeBeans = 120;
    private static int disposableCups = 9;
    private static int money = 550;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printState();
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();

            if (action.equals("buy")) {
                buy(scanner);
            } else if (action.equals("fill")) {
                fill(scanner);
            } else if (action.equals("take")) {
                take();
            } else if (action.equals("remaining")) {
                printState();
            } else if (action.equals("exit")) {
                break;
            }
        }
    }


    private static void printState() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(money + " of money");
    }

    private static void buy(Scanner scanner) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String choice = scanner.next();

        if (choice.equals("back")) {
            return;
        }

        int waterNeeded = 0, milkNeeded = 0, beansNeeded = 0, price = 0;

        switch (choice) {
            case "1": // Espresso
                waterNeeded = 250;
                milkNeeded = 0;
                beansNeeded = 16;
                price = 4;
                break;
            case "2": // Latte
                waterNeeded = 350;
                milkNeeded = 75;
                beansNeeded = 20;
                price = 7;
                break;
            case "3": // Cappuccino
                waterNeeded = 200;
                milkNeeded = 100;
                beansNeeded = 12;
                price = 6;
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        if (water < waterNeeded) {
            System.out.println("Sorry, not enough water!");
        } else if (milk < milkNeeded) {
            System.out.println("Sorry, not enough milk!");
        } else if (coffeeBeans < beansNeeded) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (disposableCups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            water -= waterNeeded;
            milk -= milkNeeded;
            coffeeBeans -= beansNeeded;
            disposableCups -= 1;
            money += price;
        }
    }

    private static void fill(Scanner scanner) {
        System.out.println("Write how many ml of water you want to add:");
        water += scanner.nextInt();

        System.out.println("Write how many ml of milk you want to add:");
        milk += scanner.nextInt();

        System.out.println("Write how many grams of coffee beans you want to add:");
        coffeeBeans += scanner.nextInt();

        System.out.println("Write how many disposable coffee cups you want to add:");
        disposableCups += scanner.nextInt();
    }

    private static void take() {
        System.out.println("I gave you " + money);
        money = 0;
    }
}
