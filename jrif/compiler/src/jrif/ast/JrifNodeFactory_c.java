package jrif.ast;

import jif.ast.*;
import polyglot.ast.*;
import polyglot.ext.jl5.ast.JL5ExtFactory_c;
import polyglot.util.*;

import java.util.*;

/**
 * NodeFactory for jrif extension.
 */
public class JrifNodeFactory_c extends JifNodeFactory_c implements JrifNodeFactory {

	public JrifNodeFactory_c() {
		super(new JrifExtFactory_c(new JifExtFactory_c()));
    }

    @Override
    public JrifExtFactory extFactory() {
        return (JrifExtFactory) super.extFactory();
    }
    
    protected JrifExtFactory jrifExtFactory() {
        return (JrifExtFactory) this.extFactory();
    }
   
    public ReclassifyExpr ReclassifyExpr(Position pos, Expr expr, Id name) {
        ReclassifyExpr n = new ReclassifyExpr_c(pos, expr, name,null);
        n = ext(n, jrifExtFactory().extReclassifyExpr());
        n = del(n, delFactory().delExpr());
        return n;
    }

    @Override
    public AmbRifDynamicLabelNode AmbRifDynamicLabelNode(Position pos, Id name,
            LabelNode lbl) {
        AmbRifDynamicLabelNode n = new AmbRifDynamicLabelNode_c(pos, name, lbl);
        n = ext(n, jrifExtFactory().extAmbRifDynamicLabelNode());
        n = del(n, delFactory().delExpr());
        return n;
    }
    
    
    /*
    @Override
    public RifLabelNode RifLabelNode(Position pos, List<RifPolicyNode> policies) {
        RifLabelNode n = new AmbRifLabelNode_c(pos, policies);
        n = (RifLabelNode) n.ext(jifExtFactory().extRifLabelNode());
        n = (RifLabelNode) n.del(delFactory().delNode());
        return n;
    }

    @Override
    public RifiLabelNode RifiLabelNode(Position pos,
            List<RifiPolicyNode> policies) {
        RifiLabelNode n = new AmbRifiLabelNode_c(pos, policies);
        n = (RifiLabelNode) n.ext(jifExtFactory().extRifiLabelNode());
        n = (RifiLabelNode) n.del(delFactory().delNode());
        return n;
    }

    @Override
    public RifLabelNode RifTransLabelNode(Position pos, LabelNode pol, Id name) {
        RifLabelNode n = new AmbRifTransLabelNode_c(pos, pol, name);
        n = (RifLabelNode) n.ext(jifExtFactory().extRifLabelNode());
        n = (RifLabelNode) n.del(delFactory().delNode());
        return n;
    }
*/
}
