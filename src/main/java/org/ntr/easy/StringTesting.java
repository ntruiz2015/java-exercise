package org.ntr.easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringTesting {

    private static int recResult = 0;

    public static void main(java.lang.String[] args) {

        System.out.println("result: " + truncateSentence("What is the solution to this problem", 4));
    }

    public static java.lang.String truncateSentence(java.lang.String s, int k) {
        java.lang.String[] arr = s.split(" ");
        java.lang.String[] res = new java.lang.String[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return java.lang.String.join(" ", res);
    }


    public static int countMatches(List<List<java.lang.String>> items, java.lang.String ruleKey, java.lang.String ruleValue) {
        Map<java.lang.String, Integer> rm = new HashMap<>();
        rm.put("type", 0);
        rm.put("color", 1);
        rm.put("name", 2);
        int res = 0;
        for (List<java.lang.String> list : items) {
            if (list.get(rm.get(ruleKey)).equals(ruleValue)) {
                res++;
            }
        }

        return res;
    }

    public static java.lang.String restoreString(java.lang.String s, int[] indices) {
        int iL = indices.length;
        char[] res = new char[iL];
        for (int i = 0; i < iL; i++) {
            res[indices[i]] = s.charAt(i);
        }
        return java.lang.String.valueOf(res);
    }

    public static int balancedStringSplit(java.lang.String s) {
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


    public static int mostWordsFound(java.lang.String[] sentences) {
        int maxAmount = 0;
        for (java.lang.String sentence : sentences) {
            int sentenceLength = sentence.split(" ").length;
            if (maxAmount > sentenceLength) {
                maxAmount = sentenceLength;
            }
        }
        return maxAmount;
    }

    public static java.lang.String interpret(java.lang.String command) {
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

    public static int numJewelsInStones(java.lang.String jewels, java.lang.String stones) {
        int result = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (jewels.indexOf(stones.charAt(i)) != -1) {
                result++;
            }
        }
        return result;
    }

    public static int recNumJewelsInStones(java.lang.String jewels, java.lang.String stones) {
        if (stones.length() == 0) return recResult;
        if (jewels.indexOf(stones.charAt(0)) != -1) {
            recResult++;
        }
        return recNumJewelsInStones(jewels, stones.substring(1));
    }

    public static int finalValueAfterOperations(java.lang.String[] operations) {
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

    public static java.lang.String defangIPaddr(java.lang.String address) {
        if (address.length() > 0) {
            return address.replace(".", "[.]");
        }
        return "";
    }

}