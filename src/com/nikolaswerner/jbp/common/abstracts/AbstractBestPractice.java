package com.nikolaswerner.jbp.common.abstracts;

/**
 *
 * @author nikolaswerner
 */
public abstract class AbstractBestPractice {
    // Fields
    // --------------------
    // Think about the reason to make a field private in an abstract class, a developer may want to use the same function that you´re using as the creator of the class
    private String a = "A";
    // to constrain the access to this field just make it protected, this way a developer may use it
    protected String b = "B";
    
    // Methods
    // --------------------
    /*
    * Such a mehtod is not great to have, when you want a developer to overwrite a method make it abstract
    * If there is no need to implement the method, just make it empty
    */
    protected void foo() {
        throw new UnsupportedOperationException("Please implement this");
    }
    
    /*
    * This is much nicer, there is no confusion if something has to be overwritten or not
    * If there is no need to implement the mehtod, just make it non abstract and empty
    */
    protected abstract void bar();
}
