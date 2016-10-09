package com.evolutionnext.datetime;

import org.junit.Test;

public class ApplyMethodReferenceTest{
    @Test
    public void testMethodReference() {
        Calculator calculator = new Calculator();
        Runner.add3ToPreexistingFunction(calculator::multiply);
    }
}
