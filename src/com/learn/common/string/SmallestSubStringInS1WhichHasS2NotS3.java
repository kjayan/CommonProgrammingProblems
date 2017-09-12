package com.learn.common.string;

import java.util.HashSet;
import java.util.Set;

public class SmallestSubStringInS1WhichHasS2NotS3 {

	public SmallestSubStringInS1WhichHasS2NotS3() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String str1 = "spqrstrupvqw";
		String str2 = "sprt";
		String str3 = "q";
		Set<String> results = new HashSet<String>();
		String[] stringToFind = str1.split(str3);

		for (String word : stringToFind) {
			if (word.length() < str2.length()) {
				continue;
			}
			if (!stringHasAllLetters(word, str2)) {
				continue;
			}

			boolean subStringFound = false;
			int offset = 0;
			int i = 0;
			while (!subStringFound) {
				for (i = 0; i < word.length() - str2.length() - offset; i++) {
					String currentSegment = word.substring(i,i + str2.length() + offset);

					if (stringHasAllLetters(currentSegment, str2)) {
						results.add(currentSegment);
						subStringFound = true;
						break;
					}
				}

				if (!subStringFound) {
					i = 0;
					offset++;
				}
			}
		}

		System.out.println(results);

	}

	private static boolean stringHasAllLetters(String stringToFind,
			String letters) {
		boolean allLettersPresent = true;
		for (char c : letters.toCharArray()) {
			if (stringToFind.indexOf(c) == -1) {
				allLettersPresent = false;
				break;
			}
		}
		return allLettersPresent;
	}

}
