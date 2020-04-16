package KATautomata.KAT;

import KATautomata.KAToperator.KATexpressionVisitor;

public class PrimitiveTest extends TestExpr {

    public String id;

    public PrimitiveTest(String str) {
        id = str;
    }

    public Object accept(KATexpressionVisitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof PrimitiveTest)) return false;
        PrimitiveTest e = (PrimitiveTest) o;
        return this.id.equals(e.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
