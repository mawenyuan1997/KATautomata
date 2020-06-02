package jrif.ast;

import KATautomata.KAT.ZeroTest;
import jrif.types.KatExprType;
import polyglot.ast.Node;
import polyglot.types.SemanticException;
import polyglot.util.Position;
import polyglot.visit.AmbiguityRemover;

public class KatZeroNode_c extends KatTestNode implements KatZeroNode {
    public KatZeroNode_c(Position pos) {
        super(pos);
    }

    @Override
    public Node disambiguate(AmbiguityRemover ar) throws SemanticException {
        this.type = new KatExprType(new ZeroTest());
        return this;
    }

    @Override
    public boolean isDisambiguated() {
        return this.type != null;
    }

}
