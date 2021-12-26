package com.xenoamess.maven.plugin.krakatau_maven_plugin.test.test0000;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTest {

    @Test
    public void test() throws ClassNotFoundException {
        Class<?> testClass = Class.forName("com.xenoamess.maven.plugin.krakatau_maven_plugin.test.test0000.Test");
        Assertions.assertNotNull(testClass);
        System.out.println(testClass.getCanonicalName());
    }

}
