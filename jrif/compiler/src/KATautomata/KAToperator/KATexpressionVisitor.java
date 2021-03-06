package KATautomata.KAToperator;

import KATautomata.KAT.*;

public interface KATexpressionVisitor {
    Object visit(Action expr);
    Object visit(PlusExpr expr);
    Object visit(ConcatExpr expr);
    Object visit(StarExpr expr);
    Object visit(ConcatTest expr);
    Object visit(NegateTest expr);
    Object visit(OneTest expr);
    Object visit(PlusTest expr);
    Object visit(PrimitiveTest expr);
    Object visit(ZeroTest expr);
}
