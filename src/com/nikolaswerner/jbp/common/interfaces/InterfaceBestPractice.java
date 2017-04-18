package com.nikolaswerner.jbp.common.interfaces;

/**
 *
 * @author nikolaswerner
 */
public interface InterfaceBestPractice {
    /*
    Methods
    */
    // The public is not needed as everything in an interface is public by definition because it is a API contract you provide
    public void foo();    
    // This does the exact same thing, but is a bit cleaner to read
    void bar();
    
    /*
    Constants
    */
    // The same is valid for constants as nothing can be changed in an interface as it has no instance
    public static final String FOO = "foo";
    // Therefore this is much cleaner to read and shorter to write
    String BAR = "bar";
}
