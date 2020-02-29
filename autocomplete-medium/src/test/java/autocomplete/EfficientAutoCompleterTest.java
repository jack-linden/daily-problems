package autocomplete;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * SimpleAutoCompleterTest
 */
public class EfficientAutoCompleterTest {

    @Test
    public void testGetCompletions() {

        AutoCompleter autoCompleter = new EfficientAutoCompleter(
                new HashSet<>(Arrays.asList("deer", "dog", "deal"))
        );

        List<String> expected = Arrays.asList("deer", "deal");
        List<String> observed = autoCompleter.getCompletions("de");
        
        Assert.assertEquals(new HashSet<>(expected), new HashSet<>(observed));
    }



}
