package ngriso.codestory;

import java.util.HashMap;
import java.util.Map;

/**
 * Transformer following rules described here : http://www.code-story.net/2011/11/16/foobarqix.html
 * <p/>
 * Can be customised by
 * <ul>
 * <li>adding (or removing) rules in the map {@link #rules}</li>
 * <li>implementing new ways of checking if an input is divisible by a divisor</li>
 * </ul>
 * <p/>
 * <b>How to implements new ways of checking if an input is divisible by a divisor</b>
 * <p>This can be usefull is the default implementation is not performant enough (eg: for big numbers)
 * <br>Some implementations can be found here: http://en.wikipedia.org/wiki/Divisibility_rule
 * <br>Extract line 36 {@code input % key == 0} and find the right pattern to associate
 * the divisor of a rule with the matching implementation (<i>eg: can be done in the map {@link #rules}</i>)
 */
public class FooBarQixTransformer {

    /**
     * @param input the number to transform (must be strictly positive)
     * @return the representation of the number following the rules by the FooBarQix game
     */
    public static String transform(final int input) {
        if (input <= 0) throw new IllegalArgumentException("Input must be stricly positive");

        final StringBuilder builder = new StringBuilder();

        // For each rules
        for (Integer divisor : rules.keySet()) {
            // check if the number is divisible by the divisors, if yes write its replacement, otherwise write nothing
            if (input % divisor == 0) builder.append(rules.get(divisor));
        }

        final String inputAsStr = String.valueOf(input);
        // For each character of the String representation of the number
        for (char c : inputAsStr.toCharArray()) {
            // check if it matches one of the divisors
            String replacement = rules.get(Character.digit(c, 10));
            // If yes, write the replacement, otherwise write nothing
            if (replacement != null) builder.append(replacement);
        }
        // If one of the rules worked, return the build String, otherwise return the number (as String)
        return builder.length() == 0 ? inputAsStr : builder.toString();
    }

    /**
     * Map containing the divisors and theirs matching replacements.
     */
    private final static Map<Integer, String> rules = new HashMap<Integer, String>() {{
        put(3, "Foo");
        put(5, "Bar");
        put(7, "Qix");
    }};
}
