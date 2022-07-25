package search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class NoneStrategy implements SearchStrategy{

    @Override
    public Set<String> findWord(List<String> source, String target, Map<String, List<Integer>> wordMap) {
        String[] wordsToFind = target.split(" ");
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < source.size(); i++) {
            result.add(i);
        }

        for (String word : wordsToFind) {
            List<Integer> currentResult = wordMap.getOrDefault(word.toLowerCase(), Collections.emptyList());
            result.removeAll(currentResult);
        }

        return result.stream()
                .map(source::get)
                .collect(Collectors.toSet());
    }
}
