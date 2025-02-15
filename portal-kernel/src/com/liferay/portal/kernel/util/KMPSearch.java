/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.portal.kernel.util;

/**
 * <p>
 * See http://en.wikipedia.org/wiki/Knuth-Morris-Pratt_algorithm.
 * </p>
 *
 * @author Shuyang Zhou
 */
public class KMPSearch {

	public static int[] generateNexts(byte[] pattern) {
		int length = pattern.length;

		int[] nexts = new int[length];

		nexts[0] = -1;

		int i = 0;
		int j = -1;

		while (i < (length - 1)) {
			if ((j == -1) || (pattern[i] == pattern[j])) {
				i++;
				j++;

				nexts[i] = j;
			}
			else {
				j = nexts[j];
			}
		}

		return nexts;
	}

	public static int[] generateNexts(char[] pattern) {
		int length = pattern.length;

		int[] nexts = new int[length];

		nexts[0] = -1;

		int i = 0;
		int j = -1;

		while (i < (length - 1)) {
			if ((j == -1) || (pattern[i] == pattern[j])) {
				i++;
				j++;

				nexts[i] = j;
			}
			else {
				j = nexts[j];
			}
		}

		return nexts;
	}

	public static int[] generateNexts(CharSequence pattern) {
		int length = pattern.length();

		int[] nexts = new int[length];

		nexts[0] = -1;

		int i = 0;
		int j = -1;

		while (i < (length - 1)) {
			if ((j == -1) || (pattern.charAt(i) == pattern.charAt(j))) {
				i++;
				j++;

				nexts[i] = j;
			}
			else {
				j = nexts[j];
			}
		}

		return nexts;
	}

	public static int search(byte[] text, byte[] pattern) {
		int[] nexts = generateNexts(pattern);

		return search(text, 0, text.length, pattern, nexts);
	}

	public static int search(byte[] text, byte[] pattern, int[] nexts) {
		return search(text, 0, text.length, pattern, nexts);
	}

	public static int search(
		byte[] text, int offset, byte[] pattern, int[] nexts) {

		return search(text, offset, text.length - offset, pattern, nexts);
	}

	public static int search(
		byte[] text, int offset, int length, byte[] pattern, int[] nexts) {

		int patternLength = pattern.length;

		int i = 0;
		int j = 0;

		while ((i < length) && (j < patternLength)) {
			if ((j == -1) || (text[i + offset] == pattern[j])) {
				i++;
				j++;
			}
			else {
				j = nexts[j];
			}
		}

		if (j >= patternLength) {
			return i - patternLength + offset;
		}

		return -1;
	}

	public static int search(char[] text, char[] pattern) {
		int[] nexts = generateNexts(pattern);

		return search(text, 0, text.length, pattern, nexts);
	}

	public static int search(char[] text, char[] pattern, int[] nexts) {
		return search(text, 0, text.length, pattern, nexts);
	}

	public static int search(
		char[] text, int offset, char[] pattern, int[] nexts) {

		return search(text, offset, text.length - offset, pattern, nexts);
	}

	public static int search(
		char[] text, int offset, int length, char[] pattern, int[] nexts) {

		int patternLength = pattern.length;

		int i = 0;
		int j = 0;

		while ((i < length) && (j < patternLength)) {
			if ((j == -1) || (text[i + offset] == pattern[j])) {
				i++;
				j++;
			}
			else {
				j = nexts[j];
			}
		}

		if (j >= patternLength) {
			return i - patternLength + offset;
		}

		return -1;
	}

	public static int search(CharSequence text, CharSequence pattern) {
		int[] nexts = generateNexts(pattern);

		return search(text, 0, text.length(), pattern, nexts);
	}

	public static int search(
		CharSequence text, CharSequence pattern, int[] nexts) {

		return search(text, 0, text.length(), pattern, nexts);
	}

	public static int search(
		CharSequence text, int offset, CharSequence pattern, int[] nexts) {

		return search(text, offset, text.length() - offset, pattern, nexts);
	}

	public static int search(
		CharSequence text, int offset, int length, CharSequence pattern,
		int[] nexts) {

		int patternLength = pattern.length();

		int i = 0;
		int j = 0;

		while ((i < length) && (j < patternLength)) {
			if (j == -1) {
				i++;
				j++;
			}
			else {
				char c1 = text.charAt(i + offset);
				char c2 = pattern.charAt(j);

				if ((c1 == c2) || (c1 == Character.toUpperCase(c2))) {
					i++;
					j++;
				}
				else {
					j = nexts[j];
				}
			}
		}

		if (j >= patternLength) {
			return i - patternLength + offset;
		}

		return -1;
	}

}