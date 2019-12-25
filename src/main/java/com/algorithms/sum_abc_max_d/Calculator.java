package com.algorithms.sum_abc_max_d;

import java.util.ArrayList;
import java.util.List;

import com.algorithms.common.generators.RandomListGenerator;
import com.algorithms.common.utils.FileUtils;

public class Calculator {
	private final static long FROM_NUMBER = -100;
	private final static long TO_NUMBER = 100;
	private final static int NUMBERS = 100;
	private List<?> list = new ArrayList<>();
	
	class PairAB {
		private long A;
		private long B;

		PairAB(long a, long b) {
			this.A = a;
			this.B = b;
		}
	}

	private static long D;

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		calculator.setList(RandomListGenerator.getStreamOfRandomLongsWithRange(NUMBERS, FROM_NUMBER, TO_NUMBER));
		FileUtils.writeArray("sum.txt", calculator.getList());

		D = calculator.calculateMaxD();
		System.out.println(D);
	}

	public long calculateMaxD() {
		List<Long> list = this.getList();

		long D = list.get(list.size()-1); // d, latest max element
		long C = list.get(list.size()-2); // c, previous before the latest max
		long DminusC = D - C;
		for(int i = list.size()-1; i >= 0; i--) {
			PairAB AplusB = leftSum(0, DminusC);
			if( AplusB != null ) {
				return D;
			}
			D = list.get(i);
			C = list.get(i-1);
			DminusC = D-C;
		}
		return D;
	}

	private PairAB leftSum(int a, long DminusC) {
		List<Long> list = getList();
		int i = a;
		long AplusB = 0; //list.get(a) + list.get(b);
		do {
			AplusB = list.get(a) + list.get(i+1);
			if(AplusB == DminusC) {
				return new PairAB(list.get(a), list.get(i));
			}
			i++;
		} while(i<list.size()-2 && list.get(i) < DminusC);
		a++;
		leftSum(a, DminusC);
		return null;
	}

	public <T> void setList(List<T> list) {
		this.list = list;
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> getList() {
		return (List<T>) this.list;
	}
}
