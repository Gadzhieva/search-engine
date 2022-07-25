package search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class AllStrategy implements SearchStrategy {

    @Override
    public Set<String> findWord(List<String> source, String target, Map<String, List<Integer>> wordMap) {
        String[] wordsToFind = target.split(" ");
        List<Integer> firstWordMatch = wordMap.getOrDefault(wordsToFind[0].toLowerCase(), Collections.emptyList());
        List<Integer> result = new ArrayList<>(firstWordMatch);

        for (int i = 1; i < wordsToFind.length; i++) {
            if (result.size() == 0) {
                return new HashSet<>();
            }
            List<Integer> currentResult = wordMap.getOrDefault(wordsToFind[i].toLowerCase(), Collections.emptyList());
            result.retainAll(currentResult);
        }
        return result.stream()
                .map(source::get)
                .collect(Collectors.toSet());
    }
}
