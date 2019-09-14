import KAT.*;
import SyKAT.*;
import SyKAT.BDD.BDD;
import SyKAT.BDD.BooleanFunction;

import java.util.Arrays;

public class Util {
    /**
     * return a boolean function from a KAT test
     * @param n number of principals
     * @param test
     * @return
     */
    public static BooleanFunction getFunction(int n, TestExpression test) {
        if (test instanceof OneTest) {
            return new BooleanFunction("one", n, 1) {
                public boolean[] execute(boolean[] input) {
                    return new boolean[]{true};
                }
            };
        }
        if (test instanceof ZeroTest) {
            return new BooleanFunction("one", n, 1) {
                public boolean[] execute(boolean[] input) {
                    return new boolean[]{false};
                }
            };
        }
        if (test instanceof PrimitiveTest) {
            return new BooleanFunction("one", n, 1) {
                public boolean[] execute(boolean[] input) {
                    return new boolean[]{input[((PrimitiveTest) test).index]};
                }
            };
        }
        if (test instanceof ConcatTest) {
            final BooleanFunction l = getFunction(n, ((ConcatTest) test).left);
            final BooleanFunction r = getFunction(n, ((ConcatTest) test).right);
            return new BooleanFunction("one", n, 1) {
                public boolean[] execute(boolean[] input) {
                    boolean lres = l.execute(Arrays.copyOfRange(input,0,l.getNumInputs()))[0];
                    boolean rres = r.execute(Arrays.copyOfRange(input,l.getNumInputs(),n))[0];
                    return new boolean[]{lres && rres};
                }
            };
        }
        else  {// if (test instanceof PlusTest)
            final BooleanFunction l = getFunction(n, ((PlusTest) test).left);
            final BooleanFunction r = getFunction(n, ((PlusTest) test).right);
            return new BooleanFunction("one", n, 1) {
                public boolean[] execute(boolean[] input) {
                    boolean lres = l.execute(Arrays.copyOfRange(input,0,l.getNumInputs()))[0];
                    boolean rres = r.execute(Arrays.copyOfRange(input,l.getNumInputs(), n))[0];
                    return new boolean[]{lres || rres};
                }
            };
        }

    }

    /**
     * translate a KAT expression to Symbolic KAT expression
     * @param n number of principals
     * @param expr
     * @return
     */
    public static SyKATexpression translate(int n, KATexpression expr) {
        if (expr instanceof ConcatExpression) {
            SyKATexpression l = translate(n, ((ConcatExpression) expr).left);
            SyKATexpression r = translate(n, ((ConcatExpression) expr).right);
            return new Concat(l, r);
        }
        if (expr instanceof PlusExpression) {
            SyKATexpression l = translate(n, ((PlusExpression) expr).left);
            SyKATexpression r = translate(n, ((PlusExpression) expr).right);
            return new Plus(l, r);
        }
        if (expr instanceof StarExpression) {
            SyKATexpression p = translate(n, ((StarExpression) expr).p);
            return new Star(p);
        }
        if (expr instanceof PrimitiveAction) {
            return new Primitive(((PrimitiveAction) expr).id);
        }
        // test to BDD
        final BooleanFunction f = getFunction(n, (TestExpression) expr);
        final BDD node = new BDD(f, 0);
        return node;
    }
}
