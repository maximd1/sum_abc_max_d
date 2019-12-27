package com.algorithms.sum_abc_max_d;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
	
	private Calculator calculator = new Calculator();

	@Test
	public void shouldReturn12() {
		calculator.setList(Arrays.asList(2L, 3L, 5L, 7L, 12L));
		Long D = calculator.calculateMaxD(calculator.getList().size());
		assertEquals(12, D.longValue());
	}
	
	@Test
	public void shouldReturnNull() {
		calculator.setList(Arrays.asList(2L, 16L, 64L, 256L, 1024L));
		Long D = calculator.calculateMaxD(calculator.getList().size());
		assertNull(D);
	}
	
	@Test
	public void shouldReturn0() {
		calculator.setList(Arrays.asList(-100L, -1L, 0L, 7L, 101L));
		Long D = calculator.calculateMaxD(calculator.getList().size());
		assertEquals(0, D.longValue());
	}
}
