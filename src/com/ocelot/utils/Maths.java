package com.ocelot.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * This class holds methods of math that are not java's {@link Math} class.
 * 
 * @author Ocelot5836
 * @since 1.4.4
 */
public class Maths {

	/**
	 * Gets the average from a set of numbers.
	 * 
	 * @param numbers
	 *            The numbers to find the mean of
	 * @return The mean of the numbers specified
	 */
	public static float mean(float... numbers) {
		float sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i];
		}
		return sum / numbers.length;
	}

	/**
	 * Gets the frequent number from a set of numbers. <em>The numbers must be sorted for this one!</em>
	 * 
	 * @param numbers
	 *            The numbers to find the median of
	 * @return The median of the numbers specified
	 */
	public static float median(float... numbers) {
		int middle = numbers.length / 2;
		if (numbers.length % 2 == 1) {
			return numbers[middle];
		} else {
			return (numbers[middle - 1] + numbers[middle]) / 2f;
		}
	}

	/**
	 * Gets the most frequent number from a set of numbers.
	 * 
	 * @param numbers
	 *            The numbers to find the mode of
	 * @return The mode of the numbers specified
	 */
	public static List<Integer> mode(final int... numbers) {
		final List<Integer> modes = new ArrayList<Integer>();
		final Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();

		int max = -1;

		for (final int n : numbers) {
			int count = 0;

			if (countMap.containsKey(n)) {
				count = countMap.get(n) + 1;
			} else {
				count = 1;
			}

			countMap.put(n, count);

			if (count > max) {
				max = count;
			}
		}

		for (final Map.Entry<Integer, Integer> tuple : countMap.entrySet()) {
			if (tuple.getValue() == max) {
				modes.add(tuple.getKey());
			}
		}

		return modes;
	}

	/**
	 * Gets the mode of a set of numbers. Only usable in java 8 and above!
	 * 
	 * @param numbers
	 *            The numbers to find the mode of
	 * @return The mode of the numbers specified
	 */
	public static List<Integer> getModes(final List<Integer> numbers) {
		final Map<Integer, Long> countFrequencies = numbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		final long maxFrequency = countFrequencies.values().stream().mapToLong(count -> count).max().orElse(-1);

		return countFrequencies.entrySet().stream().filter(tuple -> tuple.getValue() == maxFrequency).map(Map.Entry::getKey).collect(Collectors.toList());
	}
}