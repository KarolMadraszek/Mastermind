package org.example;

import java.io.PrintStream;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class MainMenu {
    public static String generateSecretCode() {
        Random random = new Random();
        String result = "";
        int index, numberOfPegs=4;
        int[] c = new int[10];
        for (int i = 0; i < 10; i++) {
            c[i] = i;
        }
        for (int i=0; i<numberOfPegs; i++) {
            index = random.nextInt(c.length);
            result += String.valueOf(c[index]);
        }
        return result;
    }

    enum Color {
        RED,
        YELLOW,
        GREEN
    }

    static String red = "\033[0;31m";
    static String yellow = "\033[1;33m";
    static String green = "\033[0;32m";
    static String nc = "\033[0m";


    public static void main(String[] args) {
        //System.setOut(printStream);
        Scanner scanner = new Scanner(System.in);
        String kod = generateSecretCode();
        String proba = "";
        Color[] color = new Color[4];
        int ilosc_prob = 10;
        System.out.println("Result: " + kod);
        while (ilosc_prob > 0) {
            if (!Objects.equals(proba, kod)) {
                //System.out.println("I " + red + "like" + nc + "StackOverflow");
                System.out.println("Pozostało prób: " + ilosc_prob);
                System.out.print("Próba: ");
                proba = scanner.nextLine();
                for (int i = 0; i < kod.length(); i++) {
                    char c = proba.charAt(i);
                    // jezeli poprawny, zaznacz na zielono
                    // jezeli znajduje sie w stringu, na zolto
                    // w pw na czerwono
                    if (c == kod.charAt(i)) {
                        // zielony
                        color[i] = Color.GREEN;
                        System.out.print(green + proba.charAt(i));

                    } else if (kod.indexOf(c) != -1 && kod.charAt(i)!=c) {
                        // żółty
                        color[i] = Color.YELLOW;
                        System.out.print(yellow + proba.charAt(i));
                    } else {
                        // czerwony
                        color[i] = Color.RED;
                        System.out.print(red + proba.charAt(i));
                    }
                    System.out.print(nc);
                }
                System.out.println();
            } else {
                System.out.println("Udało się zgadnąć kod w " + (10 - ilosc_prob) + ". próbie");
                System.out.println("Three best scores:");
                // wyświetlenie trzech najlepszych wyników
                break;
            }
            ilosc_prob--;
        }
    }
}