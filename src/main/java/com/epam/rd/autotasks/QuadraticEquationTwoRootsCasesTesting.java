package com.epam.rd.autotasks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static java.lang.String.format;
import static java.util.Arrays.sort;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class QuadraticEquationTwoRootsCasesTesting {
    protected QuadraticEquation quadraticEquation = new QuadraticEquation();
    private double a;
    private double b;
    private double c;
    private String expected;

    public QuadraticEquationTwoRootsCasesTesting(double a, double b, double c, String expected) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.expected = expected;

    }

    @Test
    public void testTwoRootsCase() {
        String[] roots = quadraticEquation.solve(a, b, c).split("\\s");
        String[] expectedRoots = expected.split("\\s");

        sort(expectedRoots);
        sort(roots);

        assertArrayEquals(expectedRoots, roots);
    }

    @Parameterized.Parameters
    public static Collection inputs() {
        return Arrays.asList(new Object[][]{
                {4, 5, 1, "-0.25 -1.0"},
                {1, 4, 2, "-3.414213562373095 -0.5857864376269049"},
                {3,6,1,"-1.816496580927726 -0.18350341907227405" },
                {1,6,1,"-5.82842712474619 -0.1715728752538097"}
        });

    }
}