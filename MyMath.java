/** A library of commonly used mathematical operations.
 */
public class MyMath {

    // For each one of the three method names listed below, 
    // write the method signature, document the method,
    // and write its implementation.
    // The documentation should be done in JavaDoc.
    // Use the same documentation style we used in Fraction.java. 

    public static int gcd(int x, int y) {
        int rem;
        while (y != 0) {
            rem = x % y;
            x = y;
            y = rem;
        }
        return x;
    }
    //returns the common denominator of the two given fractions.
    //Here is the exact definition: Let d1 and d2 be the two denominators. If d1 is a multiple of d2, return d1;
    //if d2 is a multiple of d1, return d2; Otherwise, return d1 · d2 . Hint: you’ll have to use one of the
    //Fraction class getters.
    public static int commonDenominator(Fraction x,Fraction y){
        int a = x.getDenominator();
        int b = y.getDenominator();
    if( a%b == 0){
        return a;
    }
    else if( b%a == 0){
        return b;
        }
    else{
        return a*b;
    }
    }

    /**  This function (static method) returns the
     maximum of the two given fractions. For example, the maximum of 1/2 and 1/4 is 1/2, and the
     maximum of 2557/3701 and 312/417 happens to be 312/417.
     Hint: Use one of the Fraction methods that you developed previously in this homework. */
    public static Fraction max (Fraction x, Fraction y){
        int b = x.subtract(y).getDenominator();
        int c = x.subtract(y).getNumerator();
        Fraction a = new Fraction(c,b);
        if(c < 0){
            return y;
        }
        else {
            return x;
        }
    }

}