package autocomplete;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * SimpleAutoCompleter
 */
public class SimpleAutoCompleter implements AutoCompleter {

    private final Set<String> words;

    public SimpleAutoCompleter(Set<String> words) {
        this.words = words != null
                ? words.stream().filter(Objects::nonNull).collect(Collectors.toSet())
                : Collections.emptySet();
    }

    @Override
    public List<String> getCompletions(String prefix) {
        if (prefix == null || prefix.trim().isEmpty()) {
            return Collections.emptyList();
        }

        return findAll(prefix);
    }

    private List<String> findAll(String prefix) {
        return words
                .stream()
                .filter(s -> s.startsWith(prefix))
                .collect(Collectors.toList());
    }

}
