package lab3;

public class RationalNumber extends SpecialNumber implements Comparable<RationalNumber>{
     private int numerator;
     private int denominator;

    /**
     * Creates a RationalNumber with the given numerator and denominator.
     *
     * @param numerator the numerator
     * @param denominator the denominator
     * @throws Exercise3_Exception if denominator is zero
     */
     public RationalNumber(int numerator, int denominator) throws Exercise3_Exception{
         if(denominator == 0)
             throw new Exercise3_Exception("Denominator cannot be zero");
         this.numerator = numerator;
         this.denominator = denominator;
     }

    /**
     * Adds this rational number to another rational number.
     *
     * @param other the other RationalNumber to add
     * @return the sum of the two RationalNumbers
     * @throws Exercise3_Exception if other is not a RationalNumber
     */
    @Override
    public SpecialNumber add(SpecialNumber other) throws Exercise3_Exception{
         if(!(other instanceof RationalNumber))
             throw new Exercise3_Exception("Cannot add an incompatible type");

         RationalNumber _other = (RationalNumber) other;
         int numerator = this.numerator * _other.denominator
                        + this.denominator * _other.numerator;
         int denominator = this.denominator * _other.denominator;

         return new RationalNumber(numerator, denominator);

    }

    /**
     *Divides this RationalNumber by an integer value.
     *
     * @param n the integer divisor
     * @return a new SpecialNumber representing the result of division
     * @throws Exercise3_Exception if n is zero (division by zero is not allowed)
     */
    @Override
    public SpecialNumber divideByInt(int n) throws Exercise3_Exception{
         if(n == 0) throw new Exercise3_Exception("Cannot divide by zero");
         return new RationalNumber(numerator, denominator * n);
    }


    /**
     * Compares this RationalNumber with another RationalNumber.
     *
     * @param o the RationalNumber to compare with
     * @return a negative integer, zero, or a positive integer if this number
     *         is less than, equal to, or greater than the specified number
     */
     @Override
     public int compareTo(RationalNumber o) {
         int n1 = this.numerator * o.denominator;
         int n2 = this.denominator * o.numerator;
         if(n1 == n2) return 0;
         if(n1 < n2) return -1;
         return 1;
     }

    /**
     * Checks whether this RationalNumber is equal to another object.
     * Two RationalNumbers are considered equal if they represent the same
     * mathematical value after cross-multiplication.
     *
     * @param obj the object to compare with
     * @return true if the objects represent the same rational value, false otherwise
     */
     @Override
     public boolean equals(Object obj) {
         if(this == obj) return true;
         if(obj == null) return false;
         if(this.getClass() != obj.getClass()) return false;
         RationalNumber other = (RationalNumber) obj;
         return this.numerator * other.denominator == this.denominator * other.numerator;
     }

    /**
     * Returns a hash code for this RationalNumber.
     * Note: This implementation is consistent with equals in a basic way,
     * but may not be fully collision-resistant for all reduced forms.
     *
     * @return the hash code value
     */
     @Override
     public int hashCode() {
         return numerator/denominator;
     }

}