package lab3;

public class Exercise3_Exception extends Exception {
     public String message;
     public Exercise3_Exception(String message) {
         super(message);
         this.message = message;
     }
 }