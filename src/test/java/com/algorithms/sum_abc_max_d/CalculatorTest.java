package com.algorithms.sum_abc_max_d;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
	
	private Calculator calculator = new Calculator();

	@Test
	public void shouldReturn12() {
		calculator.setList(Arrays.asList(2L, 3L, 5L, 7L, 12L));
		long D = calculator.calculateMaxD();
		assertEquals(12, D);
	}
}
