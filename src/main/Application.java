package main;

import model.Bucket;

import java.util.Scanner;

public class Application {

    private static final Bucket bucketOne = new Bucket(3,0);
    private static final Bucket bucketTwo = new Bucket(5, 0);
    private static final Scanner scanner = new Scanner(System.in);
    private static  final int GOAL = 4;
    private static int moves = 0;

    public static void main(String[] args) {

        intro();

        do {
            askUserForAction();
        } while (bucketTwo.getContains() != GOAL);

        System.out.println("Congratulations! You win in " + moves + " moves.");

    }

    private static void askUserForAction() {
        String choice;
        do {
            bucketsState();
            System.out.println("WHAT DO YOU WANT TO DO? ");
            System.out.println();
            System.out.println("F1 = Fill Bucket One with liquid");
            System.out.println("F2 = Fill Bucket Two with liquid");
            System.out.println();
            System.out.println("E1 = Empty Bucket One");
            System.out.println("E2 = Empty Bucket Two");
            System.out.println();
            System.out.println("T1-2 = Transfer from Bucket One to Bucket Two");
            System.out.println("T2-1 = Transfer from Bucket Two to Bucket One");
            choice = scanner.next();
            System.out.println();
        } while (!choice.equalsIgnoreCase("F1")
                && !choice.equalsIgnoreCase("F2")
                && !choice.equalsIgnoreCase("E1")
                && !choice.equalsIgnoreCase("E2")
                && !choice.equalsIgnoreCase("T1-2")
                && !choice.equalsIgnoreCase("T2-1")
        );
        switch (choice) {
            case "F1":
                bucketOne.fillBucket();
                break;
            case "F2":
                bucketTwo.fillBucket();
                break;
            case "E1":
                bucketOne.EmptyBucket();
                break;
            case "E2":
                bucketTwo.EmptyBucket();
                break;
            case "T1-2":
                bucketTwo.transferFromBucket(bucketOne);
                break;
            case "T2-1":
                bucketOne.transferFromBucket(bucketTwo);
                break;
            default:
                System.out.println("Something unexpected happens sorry!");
                break;
        }
        moves++;
        System.out.println("------------------------------------------------------------");
    }

    private static void intro() {
        System.out.println("There are 2 buckets:\nBucket One can hold " + bucketOne.getCapacity()
                + " liters of liquid.\nBucket Two can hold " + bucketTwo.getCapacity() + " liters of liquid.");
        System.out.println("At the beginning, the 2 buckets are empty.");
        System.out.println("You must give me " + GOAL + " liters of liquids using those buckets.");
        System.out.println("The fountain can give you all the liquid that you need.");
        System.out.println("Try to give me 4 liters with the minimum moves possible.");
        System.out.println();
        System.out.println("============================================================");
    }

    private static void bucketsState() {
        System.out.println();
        System.out.println("BUCKET STATUS:");
        System.out.println();
        System.out.println("BucketOne contains: " + bucketOne.getContains() + " liters.");
        System.out.println("BucketTwo contains: " + bucketTwo.getContains() + " liters.");
        System.out.println();
        System.out.println("------------------------------------------------------------");
        System.out.println();
    }

}
