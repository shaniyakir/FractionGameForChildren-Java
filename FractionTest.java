/** Tests the Fraction and MyMath methods described in Homework 8.
 */
public class FractionTest {

    // Some representative Fraction objects, used in the various tests written in this class.
    static Fraction half = new Fraction(1,2);
    static Fraction minusHalf = new Fraction(-1,2);
    static Fraction quarter = new Fraction(1,4);
    static Fraction minusQuarter = new Fraction(-1,4);
    static Fraction third = new Fraction(1,3);
    static Fraction twoThirds = new Fraction(2,3);
    static Fraction zero = new Fraction(0,1);
    static Fraction abs = new Fraction(0,1);
    static Fraction big = new Fraction(2557,3701);
    static Fraction small = new Fraction(312,417);
    public static void main(String args[]) {
        ///testFraction();
       // testAbs();
       // testSignum();
      //  testConvert();
        testSubtract();
        //testCompareTo();
        //testEquals();
       // testPow();
        //testRandomFraction();
        ///testCommonDenominator();
        //testMax();
        //testFraction();
    }

    private static void testFraction() {
        Fraction a = new Fraction(MyMath.gcd(minusHalf.getNumerator(),minusHalf.getDenominator()));
        System.out.println(a);
    }

    private static void testAbs() {
        System.out.println("Testing the abs function:");
        System.out.println("abs(" + half + ") = " + half.abs());
        // Complete the testing code here.
    }

    private static void testSignum() {
        System.out.println("Testing the Signum function:");
        System.out.println(half.signum());
    }

    private static void testConvert() {
       System.out.println("Testing the Convert function:");
       System.out.println(half.convert());
    }

    private static void testSubtract() {
       System.out.println("Testing the Subtract function:");
        Fraction a = half.subtract(minusHalf);
        a.reduce();
       System.out.println(a);
    }

    private static void testCompareTo() {
        System.out.println("Testing the CompereTo function:");
        System.out.println(half.compareTo(minusHalf));
    }

    private static void testEquals() {
        System.out.println("Testing the testEquals function:");
        System.out.println(half.equals(minusHalf));

    }

    private static void testPow() {
       System.out.println(quarter.pow(2));
    }

    private static void testRandomFraction() {
        Fraction x = new Fraction(20);
        System.out.println(x);
    }

    private static void testCommonDenominator() {
        // Complete the testing code here.
    }

    private static void testMax() {
        System.out.println(MyMath.max(half,quarter));
    }    
}