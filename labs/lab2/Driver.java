package lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
public class Driver {
    public static void main(String[] args) {
        double[] c1 = {6, -2, 5, 2};
        int[] e1 = {0, 1, 3, 4};
        Polynomial p1 = new Polynomial(c1, e1);

        double[] c2 = {5, 2, 6};
        int[] e2 = {0, 1, 4};
        Polynomial p2 = new Polynomial(c2, e2);

        System.out.println("Testing Add...");
        Polynomial r1 = p1.add(p2);
        System.out.println(r1);

        System.out.println("Testing Multiply...");
        Polynomial r2 = p1.multiply(p2);

        double[] rc2 = r2.getCoefficients();
        int[] re2 = r2.getExponents();
        System.out.println(r2);

        try{
            File file = new File("input.txt");
            Polynomial p3 = new Polynomial(file);
            System.out.println(p3);

            p1.saveToFile("output.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

