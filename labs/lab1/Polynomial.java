package lab1;

public class Polynomial{
    private  double[] coefficients;
    public Polynomial(){
        coefficients = new double[0];
    }
    public Polynomial(double[] coefficients){
        this.coefficients = coefficients.clone();
    }
    public Polynomial add(Polynomial p){
        int len1 = this.coefficients.length;
        int len2 = p.coefficients.length;
        double[] new_coefficients = new double[(len1>len2?len1:len2)];
        for(int i=0;i<len1;i++){
            new_coefficients[i] += this.coefficients[i];
        }
        for(int i=0;i<len2;i++){
            new_coefficients[i] += p.coefficients[i];
        }
        return new Polynomial(new_coefficients);
    }
    public double evaluate(double x){
        double sum = 0.0;
        for (int i = 0; i < coefficients.length; i++){
            sum += coefficients[i] * Math.pow(x,i);
        }
        return sum;
    }
    public boolean hasRoot(double x){
        return evaluate(x) == 0.0;
    }
}