package search;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface SearchStrategy {

    Set<String> findWord(List<String> source, String target, Map<String, List<Integer>> wordMap);
}
