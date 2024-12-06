package CoffeeMachine;

import java.util.Scanner;

enum MachineState {
    CHOOSING_ACTION,
    CHOOSING_COFFEE_TYPE,
    FILLING_WATER,
    FILLING_MILK,
    FILLING_COFFEE_BEANS,
    FILLING_CUPS
}

public class CoffeeMachine {
    private int water = 400;
    private int milk = 540;
    private int coffeeBeans = 120;
    private int disposableCups = 9;
    private int money = 550;

    private MachineState state = MachineState.CHOOSING_ACTION;

    public void processInput(String input) {
        switch (state) {
            case CHOOSING_ACTION:
                handleAction(input);
                break;
            case CHOOSING_COFFEE_TYPE:
                handleCoffeeType(input);
                break;
            case FILLING_WATER:
                water += Integer.parseInt(input);
                System.out.println("Write how many ml of milk you want to add:");
                state = MachineState.FILLING_MILK;
                break;
            case FILLING_MILK:
                milk += Integer.parseInt(input);
                System.out.println("Write how many grams of coffee beans you want to add:");
                state = MachineState.FILLING_COFFEE_BEANS;
                break;
            case FILLING_COFFEE_BEANS:
                coffeeBeans += Integer.parseInt(input);
                System.out.println("Write how many disposable cups of coffee do you want to add:");
                state = MachineState.FILLING_CUPS;
                break;
            case FILLING_CUPS:
                disposableCups += Integer.parseInt(input);
                state = MachineState.CHOOSING_ACTION;
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                break;
        }
    }

    private void handleAction(String action) {
        switch (action) {
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                state = MachineState.CHOOSING_COFFEE_TYPE;
                break;
            case "fill":
                System.out.println("Write how many ml of water you want to add:");
                state = MachineState.FILLING_WATER;
                break;
            case "take":
                System.out.println("I gave you " + money);
                money = 0;
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                break;
            case "remaining":
                printState();
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                break;
            case "exit":
                System.exit(0);
                break;
        }
    }

    private void handleCoffeeType(String choice) {
        if (choice.equals("back")) {
            state = MachineState.CHOOSING_ACTION;
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            return;
        }

        int waterNeeded = 0;
        int milkNeeded = 0;
        int beansNeeded = 0;
        int price = 0;

        switch (choice) {
            case "1": // Espresso
                waterNeeded = 250;
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
        }

        if (canMakeCoffee(waterNeeded, milkNeeded, beansNeeded)) {
            water -= waterNeeded;
            milk -= milkNeeded;
            coffeeBeans -= beansNeeded;
            disposableCups--;
            money += price;
            System.out.println("I have enough resources, making you a coffee!");
        }
        state = MachineState.CHOOSING_ACTION;
        System.out.println("Write action (buy, fill, take, remaining, exit):");
    }

    private void printState() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(money + " of money");
    }

    private boolean canMakeCoffee(int waterNeeded, int milkNeeded, int beansNeeded) {
        if (water < waterNeeded) {
            System.out.println("Sorry, not enough water!");
            return false;
        }
        if (milk < milkNeeded) {
            System.out.println("Sorry, not enough milk!");
            return false;
        }
        if (coffeeBeans < beansNeeded) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        }
        if (disposableCups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write action (buy, fill, take, remaining, exit):");
        while (scanner.hasNext()) {
            coffeeMachine.processInput(scanner.next());
        }
    }
}
