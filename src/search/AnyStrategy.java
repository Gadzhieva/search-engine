package search;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class AnyStrategy implements SearchStrategy {
    @Override
    public Set<String> findWord(List<String> source, String target, Map<String, List<Integer>> wordMap) {
        String[] wordsToFind = target.split(" ");

        return Arrays.stream(wordsToFind)
                .map(String::toLowerCase)
                .map(wordMap::get)
                .flatMap(Collection::stream)
                .map(source::get)
                .collect(Collectors.toSet());
    }
}
