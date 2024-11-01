package io.micronaut.inject.lifecycle.beanwithpredestroy;

public class X {

    private final boolean xx;

    public X() {
        this(true);
    }

    public X(boolean xx) {
        this.xx = xx;
    }


}
