package jif.lang;

/**
 * The Jif signature for the class Principal, which is the runtime representation
 * of principals of the decentralized label model.
 *
 * Objects that implement this interface can be coerced to values 
 * of the primitive type <code>principal</code>. For example,
 * <pre>
 jif.lang.Principal o = ...;
 principal p = o;
 * </pre>
 * <p>If the object <code>o</code> is <code>null</code>, then
 * the principal value is the special <code>NullPrincipal</code>
 * value, a principal for whom any other principal may act.
 *
 * <p>Any class that implements the <code>Principal</code> interface
 * implicitly has the authority of the principal "this", that is,
 * the principal represented by an object of the class.
 * 
 * <p>Notification of any change in delegation of authority should be
 * given to the Jif runtime system via calls to 
 * <code>PrincipalUtil.notifyNewDelegation</code>
 * and <code>PrincipalUtil.notifyRevokeDelegation</code>. These allow
 * the Jif runtime system to correctly cache results for acts-for queries. 
 */
public interface Principal {
    int __JIF_SIG_OF_JAVA_CLASS$20030619 = 0;
    
    /**
     * The name of this principal. Names should be unique within an
     * implementation class, that is, given two Principal objects, o and p, o
     * and p are considered to represent the same principal if
     * <code>o.getClass() == p.getClass()</code> and
     * <code>o.name().equals(p.name())</code>.
     */
    String name();
    
    /**
     * Does this principal delegate its authority to the principal p?
     */
    boolean delegatesTo(final Principal p);
    
    /**
     * Is this principal equal to the Principal p?
     */
    boolean equals(final Principal p);
    
    /**
     * Checks whether the <code>authPrf<code> provide sufficient proof of this
     * principal's authority to execute the closure <code>closure</code>, and
     * if so, returns true. In addition, if <code>executeNow</code> is true,
     * the closure will be executed immediately.
     *   For example, <code>authPrf<code> may be a password (or a password
     * digest, or a certificate, etc.); this method will return true
     * if that password matches the principal's password, and the closure
     * is one that the principal expects to be asked to authorize (typically
     * this is decided by inspecting the class of the closure).
     */
    boolean
      isAuthorized(final Object authPrf,
                   final Closure closure, final Label lb, final boolean executeNow);
    
    /**
     * Search for a proof that the principal p can act for this principal.
     * Return null if no such proof can be found.
     */
    ActsForProof findProofUpto(final Principal p, final Object searchState);
    
    /**
     * Search for a proof that this principal can act for the principal q.
     * Return null if no such proof can be found.
     */
    ActsForProof findProofDownto(final Principal q, final Object searchState);
    
    String jlc$CompilerVersion$jif = "3.5.0";
    long jlc$SourceLastModified$jif = 1466731420000L;
    String jlc$ClassType$jif =
      "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";
    String jlc$ClassType$jif$1 =
      "rtLzKItdwZBPZ+SQ9+G0n+N6uc+pqtYmzlI8BixmBFSyepKdpS/aWGocHkLvc92gHDI+ZJPxAdteBr1Y2h9vScJfoclbTnRzl/Vp3OV/290lfN3M1zvgH6B6jTq61MJI9QYK81v2ROxtdE2u6Ni0LDyx+Cuo3kmjHIbv8m7nPuB93Qd852hqH2CYNI3ajyPkh1T+aBpprIXR+0M8wPPCVoT3KRdbQM1GseMj26oCXAZJUwrhlcrFRK2O2ZRxYFcVeA5fxoacwupyuyZT2X1CItiVGSV43W5p3QKlJ9p7Ysdeh02tZbgOOM7XASfSzZOSbZ4ClH9E/fmTOmD4oDhNcUL5GXGc3TaPZ1x4AAZXuTEaSkhDfZ5MvJ5PBABfluFRSIM5arg0tXCwfMMz6n1MztLWdIQ20TTUN9hd+2xpqE8w+Hma6yxXO7wQdi7jwixWW98z13nsG0bUrn0g1hUZKaBvOE+yQJBpVhY4idmM+Dq3SRgiLclIpKUom9FcfqVOkZY6RUrBzubyK3WKtNQp0lJdpBMyE+nIbray8A3vNgLLl6kDi28ydPhIEwbbJAB9068tjrutLY5b1hbdaCmokSYFo/pi1h0oi3GaI1Ckf3WsLXwlyAQ+p8/TzGkmzgm+nWNTaWNtQZx2Yb6b86YR1QAocgOw3DH7B64tfBdwte91bWH1ooyrZokYsdo312VtQRqhrOfaOdepsJYmjOIM7BI9iu/akTqK27I8zMnHMFZ7GKu/slmqb4kty0MoPQyfdoOypwK+FgHnb/h/NNnmFOn8WYB/PKMqj9VeO1UrbFQh1DjWO8cNykQV5p6+K7iFIEHGdlOSZlJuSYrN16GyljAfN05PUSzKCpiljPxcG05M5sJuc8rf2sSZBh/cpAMC9MRltJ1pq2xMQ6hi1tvvBuVgWpeNaavtCXv3xH66oM+cCbvDB32cxgf12H0QfJ3NE3YwOqjoK5T9SNiZM7BlOL7r0N5d0bFpWXhicQJQbUijHIZDMJv6DbqpP1rbm6lTO4NyExU9WmMaA2WkLkcTw4TdtzaVLaBmo9jxEU/YwSAwjRlKCJnH6ooBecHB9iPYA/fmhAvidMsKftFW0oTsqAQ/Muq6vjAz6840z+6mPISvm/GAJae3gSGl8m1JWiPtSMbtSawuhk7/jnp2e5rR70vz7H4o7tGE3A6ZvjZji/AluueF8c7TpW0aN8mj8eyMo7HzHS7fDh6LxRyX97zwcTFJrPgDpDfdq6iU2fgqqu+RjLw0Avge5R5wszMb3ezMRinYE9yTb3Y6d6MJjQpaHuCe7EFEAG+H+HZ60JXsQqKxL2FtnpGRwL5jieM/6aD/sUTw0fsG5468b9kb+CN9xn/+kMd+BtP86/Cm79lqTG4PI6fy6FUs3Lb37SVaoWdEmuCDCgj2PUUf79MEL3kMX59R1SRNbUvMInDXuP3W3zqHH7JN0P+6JBD8n+ppC/YdnHCA/TpyypeLOMSe+xoXX/vJTPrr6FnBiHTNNTBobpOQQ1dKSAP8VOrZKbHpuLIXVfx10GN54y2/CD7U5CgsszP9wq/jFRHLf6sSCK4W1t3y/MahGwiRK4W8cHxpLEE8VQjeP9LfMgK1p+uOufTmrO8lgnii/fehTWjNd6g8q+5Z0pRzeoXx4oqrmuPipuh/Af/SijvEZgAA";
    String jlc$CompilerVersion$jl = "2.7.1";
    long jlc$SourceLastModified$jl = 1466731420000L;
    String jlc$ClassType$jl =
      "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";
    String jlc$ClassType$jl$1 =
      "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";
}