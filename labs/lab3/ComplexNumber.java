package lab3;

public class ComplexNumber extends SpecialNumber implements Comparable<ComplexNumber>{
    private double real;
    private double imaginary;
    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    @Override
    public SpecialNumber add(SpecialNumber other) throws Exercise3_Exception{
        if(!(other instanceof ComplexNumber))
            throw new Exercise3_Exception("Cannot add an incompatible type");
        ComplexNumber _other = (ComplexNumber) other;
        return new ComplexNumber(this.real + _other.real, this.imaginary + _other.imaginary);
    }

    @Override
    public SpecialNumber divideByInt(int n) throws Exercise3_Exception{
        if(n == 0) throw new Exercise3_Exception("Cannot divide by zero");
        return new ComplexNumber(real/n, imaginary/n );
    }

    private double magnitude(){
        return Math.sqrt(real*real + imaginary*imaginary);
    }

    @Override
    public int compareTo(ComplexNumber o) {
        double m1 = this.magnitude();
        double m2 = o.magnitude();

        if(m1 == m2) return 0;
        if(m1 < m2) return -1;
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(this.getClass() != obj.getClass()) return false;
        ComplexNumber other = (ComplexNumber) obj;
        return this.real == other.real && this.imaginary == other.imaginary;
    }

    @Override
    public int hashCode() {
        return (int) (real + imaginary);
    }

}
