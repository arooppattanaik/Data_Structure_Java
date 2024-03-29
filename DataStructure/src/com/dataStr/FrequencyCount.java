package com.dataStr;

import org.w3c.dom.css.Counter;

public class FrequencyCount {

	 public static void main(String[] args) {

	        // read in the words as an array
	        String s = StdIn.readAll();
	        String[] words = s.split("\\s+");

	        // sort the words
	        Merge.sort(words);

	        // tabulate frequencies of each word
	        Counter[] zipf = new Counter[words.length];
	        int m = 0;                                        // number of distinct words
	        for (int i = 0; i < words.length; i++) {
	            if (i == 0 || !words[i].equals(words[i-1]))   // short-circuiting OR
	                zipf[m++] = new Counter(words[i], words.length);
	            zipf[m-1].increment();
	        }

	        // sort by frequency and print
	        Merge.sort(zipf, 0, m);                           // sorting a subarray
	        for (int j = m-1; j >= 0; j--) {
	            System.out.println(zipf[j]);
	        }
	    }
}
