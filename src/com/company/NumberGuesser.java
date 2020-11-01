package com.company;

/*
Trang Hoang
CS111B - Assignment 2A
 */

import java.util.Scanner;
import java.util.Random;

public class NumberGuesser {

    public static void main(String[] args) {

        do {
            playOneGame();
        } while (shouldPlayAgain());
    }



    /**
     * The playOneGame method initiates a guessing game.
     */

    public static void playOneGame() {
        int low = 1, high = 100, midpoint;
        char response;

        System.out.println("Guess a number between 1 and 100.");

        do {
            midpoint = getRandomMidpoint(low, high);
//            midpoint = getMidpoint(low, high);
            response = getUserResponseToGuess(midpoint);

            if (response == 'h') {
                low = midpoint + 1;
            } else if (response == 'l') {
                high = midpoint - 1;
            }
        } while (!(response == 'c'));
    }



    /**
     * The shouldPlayAgain method returns true if the player wants to play again. Otherwise, returns false.
     * @return true if user wants to play again; if not, returns false.
     */

    public static boolean shouldPlayAgain() {
        char playAgain;
        Scanner input = new Scanner(System.in);

        do {
            System.out.print("Great! Do you want to play again? (y/n): ");
            playAgain = input.nextLine().charAt(0);
            playAgain = Character.toLowerCase(playAgain);

            if (!(playAgain == 'y' || playAgain == 'n')) {
                System.out.println("Invalid input.");
            }
        } while (!(playAgain == 'y' || playAgain == 'n'));

        return (playAgain == 'y');
    }



    /**
     * The getRandomMidpoint method returns a random number between two integers.
     * @param low number on bottom of range
     * @param high number on top of range
     * @return Random number guess between low and high numbers
     */

    public static int getRandomMidpoint(int low, int high) {
        int midpoint;
        Random random = new Random();

        midpoint = random.nextInt(high - low) + low;
        return midpoint;
    }



//    /**
//     * The getMidpoint method returns the midpoint, rounded down to integer, between two integers.
//     * @param low number on bottom of range
//     * @param high number on top of range
//     * @return Midpoint, rounded down, between the low and high numbers
//     */
//
//    public static int getMidpoint(int low, int high) {
//        return (low + high) / 2;
//    }



    /**
     * The getUserResponseToGuess method returns whether the user's number is higher, lower or correct compared to
     * the guess.
     * @param guess based on the midpoint
     * @return char 'h' for higher, 'l' for lower, or 'c' for correct
     */

    public static char getUserResponseToGuess(int guess) {
        char response;
        Scanner input = new Scanner(System.in);

        do {
            System.out.print("Is it " + guess + "?");
            System.out.print("\t(h/l/c): ");
            response = input.nextLine().charAt(0);
            response = Character.toLowerCase(response);

            if (!(response == 'h' || response == 'l' || response == 'c')) {
                System.out.println("Invalid input.");
            }
        } while (!(response == 'h' || response == 'l' || response == 'c'));

        return response;
    }
}


/*
WITH getRandomMidpoint method:
Guess a number between 1 and 100.
Is it 42?	(h/l/c): l
Is it 3?	(h/l/c): h
Is it 6?	(h/l/c): h
Is it 20?	(h/l/c): l
Is it 11?	(h/l/c): c
Great! Do you want to play again? (y/n): y
Guess a number between 1 and 100.
Is it 92?	(h/l/c): l
Is it 18?	(h/l/c): h
Is it 41?	(h/l/c): h
Is it 53?	(h/l/c): h
Is it 56?	(h/l/c): h
Is it 66?	(h/l/c): h
Is it 79?	(h/l/c): l
Is it 68?	(h/l/c): h
Is it 76?	(h/l/c): h
Is it 77?	(h/l/c): c
Great! Do you want to play again? (y/n): n

Process finished with exit code 0

WITH getMidpoint method:
Guess a number between 1 and 100.
Is it 50?	(h/l/c): l
Is it 25?	(h/l/c): l
Is it 12?	(h/l/c): l
Is it 6?	(h/l/c): h
Is it 9?	(h/l/c): h
Is it 10?	(h/l/c): h
Is it 11?	(h/l/c): c
Great! Do you want to play again? (y/n): y
Guess a number between 1 and 100.
Is it 50?	(h/l/c): h
Is it 75?	(h/l/c): h
Is it 88?	(h/l/c): l
Is it 81?	(h/l/c): l
Is it 78?	(h/l/c): l
Is it 76?	(h/l/c): h
Is it 77?	(h/l/c): c
Great! Do you want to play again? (y/n): n

Process finished with exit code 0
 */
