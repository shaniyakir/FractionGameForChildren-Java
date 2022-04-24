/** Represents an expression
 */
public class Expression {

	private static final char[] ops = {'+', '-', '*', ':', '>'};

    // The operands and operator of this expression
    private Fraction op1;
    private Fraction op2;
    private char op;
  
    /** Constructs an expression.
     *  @param f1    can be signed
     *  @param f2  can be signed
     *  @param op ;
     */
    public Expression (Fraction f1, Fraction f2, char op) {
        op1 = f1;
        op2 = f2;
        this.op = op;
    }

    /** Constructs a random expression.
     *  A random expression consists of two random fractions, each with the given 
     *  limit, and a randomly selected operation which is either +, -, *, /, or >.
     *  @param limit must be at least 2
     */
    public Expression (int limit) {
       this.op1 = new Fraction(limit);
       this.op2 = new Fraction(limit);
       int rand = (int)(Math.random()*5);
       this.op = ops[rand];
    }

    /** Returns the first operand of this expression.
     *  @return the first operand of this expression (a fraction)
     */
    public Fraction getOp1() {

        return op1;
    }

    /** Returns the second operand of this expression.
     *  @return the second operand of this expression (a fraction)
     */
    public Fraction getOp2() {

        return op2;
    }

    /** Returns the operator of this expression.
     *  @return the second opetand of this expression (a fraction)
     */
    public char getOp() {

        return op;
    }

    /** Returns the value of this expression, as a fraction.
     *  If the operator (op) is '>', returns op1 minus op2, as a fraction.  
     *  @return the value of this expression, as fraction.{'+', '-', '*', ':', '>'}
     */
    public Fraction value() {
        Fraction result = null;
        switch (op){
            case '+' : result = op1.add(op2);
            break;

            case '-' : case '>' : result = op1.subtract(op2);
            break;

            case '*' : result = op1.multiply(op2);
            break;

            case ':' : result = op1.divide(op2);
            break;
        }

        return result;
    }

    /** Returns an expression that serves as a hint for this expression.
     *  Note: Multiplication expressions have no hints.
     *  @return an expression that has the same value as this expression
     */
    public Expression hint() {
        Expression result = null;
        switch (op){
            case '+' : result = addHint();
            break;
            case '-' : result = subHint();
            break;
            case '>' : result = compHint();
            break;
            case ':' : result = divHint();
            break;
        }
        return result;
    }

    /** Returns an expression that serves as a hint for solving this addition expression. 
     *  For example, the hint for 1/2 + 2/3 is 3/6 + 4/6.
     *  @return an expression that has the same value as this expression
     */
    public Expression addHint() {
        int common = MyMath.commonDenominator(op1,op2);
        Fraction first = new Fraction(common/op1.getDenominator()* op1.getNumerator(),common);
        Fraction second = new Fraction(common/op2.getDenominator()*op2.getNumerator(),common);
        return new Expression(first , second ,op);
    }

    /** Returns an expression that serves as a hint for solving this subtraction expression. 
     *  For example, the hint for 1/2 - 2/3 is 3/6 - 4/6.
     *  @return an expression that has the same value as this expression
     */
    public Expression subHint() {
        int common = MyMath.commonDenominator(op1,op2);
        Fraction first = new Fraction(common/op1.getDenominator()* op1.getNumerator(),common);
        Fraction second = new Fraction(common/op2.getDenominator()*op2.getNumerator(),common);
        return new Expression(first,second, op);
    }

    /** Returns an expression that serves as a hint for solving this division expression. 
     *  For example, the hint for 1/2 : 2/3 is 1/2 * 3/2.
     *  @return a multiplication expression that has the same value as this expression
     */
    public Expression divHint() {
        Fraction second = new Fraction(op2.getDenominator(),op2.getNumerator());
        return new Expression(this.op1,second,'*');
    }

    /** Returns an expression that serves as a hint for solving this comparison expression. 
     *  For example, the hint for 1/2 > 2/3 is 1/2 - 2/3.
     *  @return a subtraction expression
     */
    public Expression compHint() {
        return new Expression(this.op1,this.op2,'-');
    }

    /** Returns a string representation of this expression.
     *  If the operand is negative, encloses the operand with parentheses.
     *  For example, if op1 = 1/5, op2 = -1/3, and op = "-", returns "1/5 - (-1/3)".
     *  @return a string representation of this expression.
     */
    public String toString () {

        String axpression = op1.getNumerator() + "/" + op1.getDenominator() +" " + op + " " +
                  "(" + op2.getNumerator() + "/" + op2.getDenominator() +")" ;
        return axpression;
    }
}