package lpa;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class utilitiesTestParameterized {
    private Utilities u;
    private String input;
    private String output;

    public utilitiesTestParameterized(String input, String output) {
        this.input = input;
        this.output = output;
    }

    @Before
    public void setUp() throws Exception {
        u = new Utilities();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"ABCDEFF", "ABCDEF"},
                {"AB88EFFG", "AB8EFG"},
                {"112233445566", "123456"},
                {"ZYZQQB", "ZYZQB"},
                {"A","A"}
        });
    }

    @Test
    public void removePairs() {
    assertEquals(output, u.removePairs(input));
    }
}
