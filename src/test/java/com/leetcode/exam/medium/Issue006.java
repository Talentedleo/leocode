package com.leetcode.exam.medium;

import org.junit.Test;

import java.util.*;

public class Issue006 {

    //692. 前K个高频单词
    @Test
    public void test() {
        String[] input = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println("result: " + topKFrequent(input, 3));
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        List<String> result = new ArrayList<>(count.keySet());
        Collections.sort(result, (w1, w2) -> count.get(w1).equals(count.get(w2)) ? w1.compareTo(w2):count.get(w2) - count.get(w1));
        return result.subList(0, k);
    }
}
