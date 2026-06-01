package lab3;

import java.util.List;

public abstract class SpecialNumber {
    public abstract SpecialNumber add(SpecialNumber other) throws Exercise3_Exception;
    public abstract SpecialNumber divideByInt(int n) throws Exercise3_Exception;

    /**
     * This method computes the average of a list of SpecialNumber objects.
     *
     * @param numbers the list of SpecialNumber objects to be averaged
     * @return a SpecialNumber representing the average of all elements in the list
     * @throws Exercise3_Exception if the list is null or empty
     */
    public static SpecialNumber computeAverage(List<SpecialNumber> numbers) throws Exercise3_Exception{
        if(numbers == null || numbers.size() == 0)
            throw new Exercise3_Exception("List cannot be empty");
        SpecialNumber total = numbers.get(0);
        for(int i = 1; i < numbers.size(); i++){
            total = total.add(numbers.get(i));
        }
        return total.divideByInt(numbers.size());
    }
}