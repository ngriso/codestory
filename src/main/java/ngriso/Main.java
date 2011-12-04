package ngriso;

import com.google.common.base.Function;
import com.google.common.collect.AbstractIterator;
import ngriso.codestory.FooBarQixTransformer;

import java.util.Iterator;

import static com.google.common.collect.Iterators.limit;
import static com.google.common.collect.Iterators.transform;

public class Main {

    public static void main(String[] args) {
        // Functionnal style :). To avoid the classic for loop.
        // Would have been too much to do the same for FooBarQixTransformer
        printToSysOut(limit(transform(InfinitePositiveIntegerIterator.from(1), fooBarQixTransformer()), 100));
    }

    public static void printToSysOut(Iterator<String> elements) {
        while (elements.hasNext()) {
            System.out.println(elements.next());
        }
    }

    /**
     * Utility method to provide a {@link Function} based on {@link FooBarQixTransformer}.
     * <p>Exists because I didn't want to make {@link FooBarQixTransformer} depend  on an external lib.
     * @return a {@link Function} based on {@link FooBarQixTransformer}
     */
    public static Function<Integer, String> fooBarQixTransformer() {
        return new Function<Integer, String>() {
            public String apply(Integer input) {
                return FooBarQixTransformer.transform(input);
            }
        };
    }

    public static class InfinitePositiveIntegerIterator {
        public static Iterator<Integer> from(final int startFrom) {
            return new AbstractIterator<Integer>() {
                int i = startFrom;

                @Override
                protected Integer computeNext() {
                    return i++;
                }
            };
        }
    }
}