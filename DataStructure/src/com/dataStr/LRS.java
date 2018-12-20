package com.dataStr;
import java.util.Arrays;
import java.util.Scanner;
public class LRS {
	// return the longest common prefix of s and t
    public static String lcp(String s, String t) {
        int n = Math.min(s.length(), t.length());
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i))
                return s.substring(0, i);
        }
        return s.substring(0, n);
    }


    // return the longest repeated string in s
    public static String lrs(String s) {
        // form the N suffixes
        int n  = s.length();
        String[] suffixes = new String[n];
        for (int i = 0; i < n; i++) {
            suffixes[i] = s.substring(i, n);
        }
        for(int i=0;i<suffixes.length;i++) {
     	   System.out.println(suffixes[i]);
        }
        // sort them
        Arrays.sort(suffixes);
       for(int i=0;i<suffixes.length;i++) {
    	   System.out.println(suffixes[i]);
       }

        // find longest repeated substring by comparing adjacent sorted suffixes
        String lrs = "";
        for (int i = 0; i < n-1; i++) {
            String x = lcp(suffixes[i], suffixes[i+1]);
            System.out.println("value of lcp: "+x);
            if (x.length() > lrs.length())
                lrs = x;
        }
        return lrs;
    }

    // read in text, replacing all consecutive whitespace with a single space
    // then compute longest repeated substring Scanner sc =  new Scanner(System.in);
    public static void main(String[] args) {
    	Scanner sc =  new Scanner(System.in);
    	System.out.println("Enter a string: ");
        String s = sc.next();
        s = s.replaceAll("\\s+", " ");
        System.out.println("'" + lrs(s) + "'");
    	}
    }

