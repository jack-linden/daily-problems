package autocomplete;

import java.util.List;

/**
 * Dictionary
 */
public interface AutoCompleter {

    List<String> getCompletions(String prefix);
}
