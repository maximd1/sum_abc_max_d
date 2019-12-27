package com.algorithms.sum_abc_max_d;

import java.util.ArrayList;
import java.util.List;

import com.algorithms.utils.FileUtils;
import com.algorithms.utils.generators.RandomListGenerator;

public class Calculator {
	private final static long FROM_NUMBER = -100;
	private final static long TO_NUMBER = 100;
	private final static int NUMBERS = 100;
	private List<?> list = new ArrayList<>();
	private boolean isNegative = false;
	
	private static long D;

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		calculator.setList(RandomListGenerator.getStreamOfRandomLongsWithRange(NUMBERS, FROM_NUMBER, TO_NUMBER));
		FileUtils.writeArray("sum.txt", calculator.getList());

		D = calculator.calculateMaxD(calculator.getList().size());
		System.out.println("D=" + D);
	}

	public Long calculateMaxD(int start) {
		if(start - 1 == 0) {
			return null;
		}

		List<Long> list = this.getList();
		Long D = list.get(start-1); // latest max
		long C = 0; // previous latest max
		long DminusC = 0;

		for(int i = start-1; i >= 1; i--) {
			C = list.get(i-1);
			DminusC = D-C;
			if( leftSum(0, start-1, DminusC) ) {
				if( isNegative ) {
					long temp = C;
					C = D;
					D = temp;
				}
				System.out.println("C=" + C);
				return D;
			}
		}
		start--;
		calculateMaxD(start);
		return null;
	}

	private boolean leftSum(int a, int stop, long DminusC) {
		List<Long> list = getList();
		if( a < stop-1 ) {
			int i = a;
			long AplusB = 0; //list.get(a) + list.get(b);
			do {
				AplusB = list.get(a) + list.get(i+1);
				isNegative = AplusB < 0 ? true : false;
				if(Math.abs(AplusB) == Math.abs(DminusC)) {
					// A + B found
					System.out.println("A=" + list.get(a) + ", B=" + list.get(i+1));
					return true;
				}
				i++;
			} while(i<stop-1 && list.get(i) < DminusC);
			a++;
			leftSum(a, stop, DminusC);
		}
		return false;
	}

	public <T> void setList(List<T> list) {
		this.list = list;
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> getList() {
		return (List<T>) this.list;
	}
}
