package KATautomata.KAT;

import KATautomata.KAToperator.KATexpressionVisitor;
import jif.types.LabelSubstitution;
import jif.types.principal.Principal;
import polyglot.types.Type;
import polyglot.types.TypeSystem;
import polyglot.util.SerialVersionUID;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * KAT One class
 *
 * author: Wenyuan Ma   date:2020-07-03
 */
public class ZeroTest extends TestExpr {
    private static final long serialVersionUID = SerialVersionUID.generate();
    public ZeroTest() {}

    public Object accept(KATexpressionVisitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o instanceof ZeroTest) return true;
        return false;
    }

    @Override
    public void subst(LabelSubstitution substitution) {
    }

    @Override
    public List<Principal> principals() {
        return new ArrayList<>();
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
