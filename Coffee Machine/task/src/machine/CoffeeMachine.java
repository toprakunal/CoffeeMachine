package machine;

import java.util.Scanner;


public class CoffeeMachine {
    private static int cupNumber,waterAmount,milkAmount,beansAmount,waterRemanin,milkRemain,beansRemain,maxAmount,money;
    private static final Scanner scanner = new Scanner(System.in);
    static final int WATER_MULTIPLIER = 200; //amount of water needed per cup.
    static final int MILK_MULTIPLIER = 50; //amount of milk needed per cup.
    static final int BEANS_MULTIPLIER= 15; //amount of beans needed per cup.

    public static void main(String[] args) {
        waterAmount=400;
        milkAmount=540;
        beansAmount=120;
        cupNumber=9;
        money= 550;

        selectAction();


    }

    private static void printIngredients() {
        System.out.println("for "+cupNumber+" cups of coffee you will need: ");
        System.out.println(waterNeeded()+" ml of water");
        System.out.println(milkNeeded()+" ml of milk");
        System.out.println(beansNeeded()+ "g of coffee beans");
    }

    private static void helloProgram() {
        System.out.println("Starting to make a coffee\n" +
                "Grinding coffee beans\n" +
                "Boiling water\n" +
                "Mixing boiled water with crushed coffee beans\n" +
                "Pouring coffee into the cup\n" +
                "Pouring some milk into the cup\n" +
                "Coffee is ready!");
    }


    private static void numberOfCup(){
        System.out.println("Write how many cups of coffee you will need: ");
        cupNumber = scanner.nextInt();

    }
    private static int waterNeeded(){
        return WATER_MULTIPLIER * cupNumber;
    }

    private static int milkNeeded(){
        return MILK_MULTIPLIER * cupNumber;
    }

    private static int beansNeeded(){
        return BEANS_MULTIPLIER * cupNumber;
    }

    private static void enterWater(){
        System.out.println("Write how many ml of water the coffee machine has:");
        waterAmount=scanner.nextInt();

    }
    private static void enterMilk(){
        System.out.println("Write how many ml of milk the coffee machine has: ");
        milkAmount= scanner.nextInt();
    }
    private static void enterBeans(){
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        beansAmount= scanner.nextInt();
    }

    private static void enterIngredients(){
        enterWater();
        enterMilk();
        enterBeans();
    }

    private static void maxNumberOfCup(){
        waterRemanin= waterAmount/WATER_MULTIPLIER;
        milkRemain = milkAmount/MILK_MULTIPLIER;
        beansRemain = beansAmount/BEANS_MULTIPLIER;



        if (waterRemanin <=  milkRemain && waterRemanin <= beansRemain)
             maxAmount = waterRemanin;
        else if(milkRemain <= waterRemanin && milkRemain <= beansRemain)
            maxAmount = milkRemain;
        else
            maxAmount = beansRemain;



    }


    private static void ableToMake(){
        enterIngredients();
        numberOfCup();
        maxNumberOfCup();


        if(waterRemanin >= cupNumber && milkRemain >= cupNumber && beansRemain >= cupNumber && maxAmount-cupNumber!=0){
            System.out.println("Yes, I can make that amount of coffee (and even " + (maxAmount-cupNumber)+ " more that that)");
        }else if (waterRemanin >= cupNumber && milkRemain >= cupNumber && beansRemain >= cupNumber){
            System.out.println("Yes, I can make that amount of coffee");
        }
         if (waterRemanin < cupNumber || milkRemain < cupNumber || beansRemain < cupNumber){
            System.out.println("No, I can make only "+ maxAmount+" cup(s) of coffee");
        }




    }



    private static void printState(){

        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(waterAmount+" ml of water");
        System.out.println(milkAmount+" ml of milk");
        System.out.println(beansAmount+ " g of coffee beans");
        System.out.println(cupNumber+ " disposable cups");
        System.out.println("$"+money+ " of money");
        System.out.println();
    }
    private static void selectAction(){
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        String action = scanner.next();
        switch (action){
            case "exit":
                System.exit(0);
                break;
            case "buy":
                buy();
                selectAction();
                break;
            case "fill":
                fill();
                selectAction();
                break;
            case "take":
                take();
                selectAction();
                break;
            case "remaining":
                printState();
                selectAction();
                break;




        }


    }


    private static void buy(){


        String actionNumber;
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:  ");
        actionNumber= scanner.next();
        switch (actionNumber){
            case "1":
                espresso();
                break;
            case "2":
                latte();
                break;
            case "3":
                cappuccino();
                break;
            case "back":
                selectAction();
                break;


        }
    }

    private static void fill(){
        int addWater,addMilk,addBeans,addCup;
        System.out.println("Write how many ml of water you want to add: ");
        addWater= scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        addMilk=scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        addBeans=scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        addCup=scanner.nextInt();

        waterAmount=waterAmount+addWater;
        milkAmount= milkAmount+addMilk;
        beansAmount= beansAmount+ addBeans;
        cupNumber= cupNumber+ addCup;

    }

    private static void take(){
        System.out.println("I gave you "+money);
        money=0;
    }

    private static void espresso(){
        if(waterAmount > 250 && beansAmount>16 && cupNumber > 0 && money > 4  ){
            System.out.println("I have enough resources, making you a coffee!");
            waterAmount=waterAmount-250;
            beansAmount= beansAmount-16;
            cupNumber=cupNumber-1;
            money= money+4;
        }else if (waterAmount < 250)
            System.out.println("Sorry, not enough water!");
        if (beansAmount<16)
            System.out.println("Sorry, not enough coffee beans!");
        if(cupNumber < 0 )
            System.out.println("Sorry, not enough disposable cups!");
        if (money < 4)
            System.out.println("Sorry, not enough money!");

    }
    private static void latte(){
        if(waterAmount > 350 && milkAmount > 75 && beansAmount>20 && cupNumber > 0 && money > 7 ) {
            waterAmount = waterAmount - 350;
            milkAmount = milkAmount - 75;
            beansAmount = beansAmount - 20;
            cupNumber = cupNumber - 1;
            money = money + 7;
        }else if (waterAmount < 350)
            System.out.println("Sorry, not enough water!");
        if(milkAmount < 75)
            System.out.println("Sorry, not enough milk!");
        if (beansAmount<20)
            System.out.println("Sorry, not enough coffee beans!");
        if(cupNumber < 0 )
            System.out.println("Sorry, not enough disposable cups!");
        if (money < 7)
            System.out.println("Sorry, not enough money!");

    }
    private static void cappuccino(){
        if(waterAmount > 200 && milkAmount > 100 && beansAmount> 12 && cupNumber > 0 && money > 6 ) {
            waterAmount = waterAmount - 200;
            milkAmount = milkAmount - 100;
            beansAmount = beansAmount - 12;
            cupNumber = cupNumber - 1;
            money = money + 6;

        }else if(waterAmount > 200 )
            System.out.println("Sorry, not enough water!");
        if(milkAmount < 100)
            System.out.println("Sorry, not enough milk!");
        if (beansAmount<12)
            System.out.println("Sorry, not enough coffee beans!");
        if(cupNumber < 0 )
            System.out.println("Sorry, not enough disposable cups!");
        if (money < 6)
            System.out.println("Sorry, not enough money!");
    }


}
