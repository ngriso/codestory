package ngriso.codestory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FooBarQixTransformerTest {

    @Parameterized.Parameters
    public static List<Object[]> generateData() {
        return Arrays.asList(
                new Object[]{1, "1"},
                new Object[]{2, "2"},
                new Object[]{3, "FooFoo"},
                new Object[]{5, "BarBar"},
                new Object[]{6, "Foo"},
                new Object[]{7, "QixQix"},
                new Object[]{13, "Foo"},
                new Object[]{15, "FooBarBar"},
                new Object[]{21, "FooQix"},
                new Object[]{33, "FooFooFoo"},
                new Object[]{51, "FooBar"},
                new Object[]{53, "BarFoo"}
        );
    }

    private int input;
    private final String expectedString;

    public FooBarQixTransformerTest(int input, String expectedString) {
        this.input = input;
        this.expectedString = expectedString;
    }

    @Test
    public void should_return_the_right_String() {
        assertEquals("Error with input: " + input, expectedString, FooBarQixTransformer.transform(input));
    }
}
