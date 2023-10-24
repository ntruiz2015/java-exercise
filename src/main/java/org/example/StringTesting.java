package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringTesting {

    private static int recResult = 0;

    public static void main(String[] args) {

        System.out.println("result: " + truncateSentence("What is the solution to this problem", 4));
    }

    public static String truncateSentence(String s, int k) {
        String[] arr = s.split(" ");
        String[] res = new String[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return String.join(" ", res);
    }


    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        Map<String, Integer> rm = new HashMap<>();
        rm.put("type", 0);
        rm.put("color", 1);
        rm.put("name", 2);
        int res = 0;
        for (List<String> list : items) {
            if (list.get(rm.get(ruleKey)).equals(ruleValue)) {
                res++;
            }
        }

        return res;
    }

    public static String restoreString(String s, int[] indices) {
        int iL = indices.length;
        char[] res = new char[iL];
        for (int i = 0; i < iL; i++) {
            res[indices[i]] = s.charAt(i);
        }
        return String.valueOf(res);
    }

    public static int balancedStringSplit(String s) {
        int balance = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                balance++;
            } else {
                balance--;
            }
            if (balance == 0) {
                result++;
            }
        }
        return result;
    }


    public static int mostWordsFound(String[] sentences) {
        int maxAmount = 0;
        for (String sentence : sentences) {
            int sentenceLength = sentence.split(" ").length;
            if (maxAmount > sentenceLength) {
                maxAmount = sentenceLength;
            }
        }
        return maxAmount;
    }

    public static String interpret(String command) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'G') {
                builder.append("G");
            } else if (command.charAt(i) == '(') {
                if (command.charAt(i + 1) == ')') {
                    builder.append("o");
                    i++;
                } else {
                    builder.append("al");
                    i += 3;
                }
            }
        }
        return builder.toString();
    }

    public static int numJewelsInStones(String jewels, String stones) {
        int result = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (jewels.indexOf(stones.charAt(i)) != -1) {
                result++;
            }
        }
        return result;
    }

    public static int recNumJewelsInStones(String jewels, String stones) {
        if (stones.length() == 0) return recResult;
        if (jewels.indexOf(stones.charAt(0)) != -1) {
            recResult++;
        }
        return recNumJewelsInStones(jewels, stones.substring(1));
    }

    public static int finalValueAfterOperations(String[] operations) {
        int result = 0;
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].contains("-")) {
                result -= 1;
            } else {
                result += 1;
            }
        }
        return result;
    }

    public static String defangIPaddr(String address) {
        if (address.length() > 0) {
            return address.replace(".", "[.]");
        }
        return "";
    }

}