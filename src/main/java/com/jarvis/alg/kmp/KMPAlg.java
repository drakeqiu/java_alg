package com.jarvis.alg.kmp;

/**
 * @Author: jarvis
 * @Description
 * @Modified By:
 */
public class KMPAlg {

    public static int kmp(String targetString, String patternString) {

        char[] target = targetString.toCharArray();
        char[] pattern = patternString.toCharArray();
        int targetLength = target.length;
        int patternLength = pattern.length;
        int i = 0;
        int j = 0;
        int[] next = getNext(patternString);
        while (i < targetLength && j < patternLength) {
            if (j == -1 || target[i] == pattern[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        if (j == pattern.length) {
            return i - j;
        } else {
            return -1;
        }
    }

    private static int[] getNext(String patternString) {
        char[] pattern = patternString.toCharArray();
        int patternLength = pattern.length;
        int[] next = new int[patternLength];
        next[0] = -1;
        int j = 0, k = -1;

        while (j < patternLength - 1) {
            if (k == -1 || pattern[j] == pattern[k]) {
                if (pattern[++j] == pattern[++k]) {
                    next[j] = next[k];
                } else {
                    next[j] = k;
                }
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        int index = KMPAlg.kmp("AAAAAAAABBB", "ABBB");
        System.out.println(index);
    }

}
