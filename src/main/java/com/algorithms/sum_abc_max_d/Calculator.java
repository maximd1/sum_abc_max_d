package com.algorithms.sum_abc_max_d;

import java.util.List;

import com.algorithms.common.generators.RandomListGenerator;
import com.algorithms.common.utils.FileUtils;

public class Calculator {
	private final static long FROM_NUMBER = -100;
	private final static long TO_NUMBER = 100;
	private final static int NUMBERS = 100;

	public static void main(String[] args) {
		RandomListGenerator randomListGenerator = new RandomListGenerator();
		List<Long> list = randomListGenerator.getStreamOfRandomLongsWithRange(FROM_NUMBER, TO_NUMBER, NUMBERS);
		//FileUtils.writeArray("sum.txt", list);
		long latest1 = list.get(list.size()-1); // d, latest element
		long latest2 = list.get(list.size()-2); // c, previous before latest
		long leftSum = 0;
		for(int i=0; i<list.size()-3; i++) {
			leftSum = leftSum(list.get(i), list.get(i+1), latest1 - latest2);
			latest1 = list.get(i);
			latest2 = list.get(i-1);
		}
	}
	
	private static long leftSum(long a, long b, long sum) {
		while(a+b<=sum) {
			leftSum(a, b, sum);
		}
		return sum;
	}
}
