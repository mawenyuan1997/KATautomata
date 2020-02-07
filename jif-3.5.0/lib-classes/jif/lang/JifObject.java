package jif.lang;

/**
 * This interface combines the Jif signatures for the methods
 * equals(), hashCode() and toString(). Since all of these
 * methods return values that depend on fields in the class
 * (which may have arbitrary labels), the signatures
 * for the equivalent methods in java.lang.Object are unsuitable.
 */
public interface JifObject extends IDComparable, Hashable, ToStringable {
    String jlc$CompilerVersion$jif = "3.5.0";
    long jlc$SourceLastModified$jif = 1466731420000L;
    String jlc$ClassType$jif =
      "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";
    
    Label jif$getjif_lang_JifObject_L();
    
    String jlc$CompilerVersion$jl = "2.7.1";
    long jlc$SourceLastModified$jl = 1466731420000L;
    String jlc$ClassType$jl =
      "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";
}