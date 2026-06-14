package lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
public class Polynomial {
    private double[] coefficients;
    private int[] exponents;

    public Polynomial() {
        coefficients = new double[0];
        exponents = new int[0];
    }

    public Polynomial(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        String line = scanner.nextLine();
        scanner.close();
        line = line.replace("-", "+-");
        String[] terms = line.split("\\+");
        this.coefficients = new double[terms.length];
        this.exponents = new int[terms.length];
        for (int i = 0; i < terms.length; i++) {
            String[] ceo_exp = terms[i].split("x");
            this.coefficients[i] = Double.parseDouble(ceo_exp[0]);
            this.exponents[i] = (ceo_exp.length == 1) ? 0 : Integer.parseInt(ceo_exp[1]);
        }
    }

    public Polynomial(double[] coefficients, int[] exponents) {
        this.coefficients = coefficients;
        this.exponents = exponents;
    }

    public Polynomial add(Polynomial p) {
        if (this.coefficients.length == 0)
            return new Polynomial(p.coefficients, p.exponents);
        if (p.coefficients.length == 0)
            return new Polynomial(this.coefficients, this.exponents);
        int max_exp = Math.max(this.exponents[this.exponents.length - 1],
                p.exponents[p.exponents.length - 1]);
        double[] temp_coe = new double[max_exp + 1];
        for (int i = 0; i < this.exponents.length; i++) {
            temp_coe[this.exponents[i]] += this.coefficients[i];
        }
        for (int i = 0; i < p.exponents.length; i++) {
            temp_coe[p.exponents[i]] += p.coefficients[i];
        }
        int count = 0;
        for (int i = 0; i < temp_coe.length; i++) {
            if (temp_coe[i] != 0) {
                count++;
            }
        }
        double[] res_coe = new double[count];
        int[] res_exp = new int[count];
        for (int i = 0, k = 0; i <= max_exp; i++) {
            if (temp_coe[i] != 0) {
                res_coe[k] = temp_coe[i];
                res_exp[k] = i;
                k++;
            }
        }
        return new Polynomial(res_coe, res_exp);
    }

    public Polynomial multiply(Polynomial p) {
        if (this.coefficients.length == 0 || p.coefficients.length == 0)
            return new Polynomial(new double[0], new int[0]);
        int max_exp = this.exponents[this.exponents.length - 1]
                + p.exponents[p.exponents.length - 1];
        double[] temp_coe = new double[max_exp + 1];
        for(int i = 0; i < this.exponents.length; i++) {
            for (int j = 0; j < p.exponents.length; j++) {
                int exp = this.exponents[i] + p.exponents[j];
                double coe = this.coefficients[i] * p.coefficients[j];
                temp_coe[exp] += coe;
            }
        }
        int count = 0;
        for (int i = 0; i < temp_coe.length; i++) {
            if (temp_coe[i] != 0) {
                count++;
            }
        }
        double[] res_coe = new double[count];
        int[] res_exp = new int[count];
        for (int i = 0, k = 0; i <= max_exp; i++) {
            if (temp_coe[i] != 0) {
                res_coe[k] = temp_coe[i];
                res_exp[k] = i;
                k++;
            }
        }
        return new Polynomial(res_coe, res_exp);
    }


    public double evaluate(double x) {
        double sum = 0.0;
        for (int i = 0; i < coefficients.length; i++) {
            sum += coefficients[i] * Math.pow(x, this.exponents[i]);
        }
        return sum;
    }

    public boolean hasRoot(double x) {
        return evaluate(x) == 0.0;
    }

    public double[] getCoefficients() {
        return coefficients;
    }

    public int[] getExponents() {
        return exponents;
    }

    public String toString() {
        String res = "Coefficients:\n";
        for (int i = 0; i < coefficients.length; i++) {
            res += coefficients[i] + " ";
        }
        res += "\nExponents:\n";
        for (int i = 0; i < exponents.length; i++) {
            res += exponents[i] + " ";
        }
        return res;
    }


    public void saveToFile(String filename) throws IOException {
        FileWriter writer = new FileWriter(filename);
        String line = "";
        for (int i = 0; i < this.coefficients.length; i++) {
            line += this.coefficients[i] + "x" + this.exponents[i] + "+";
        }
        line += "Zachary";
        line = line
                .replace("+-", "-")
                .replace("x0", "")
                .replace("x1", "x")
                .replace(".0", "")
                .replace("+Zachary", "");
        writer.write(line);
        writer.close();
    }
}