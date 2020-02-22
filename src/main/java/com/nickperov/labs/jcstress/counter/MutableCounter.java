package com.nickperov.labs.jcstress.counter;

public class MutableCounter implements Counter<Integer> {

	private Integer value = 0;

	@Override
	public void append(Counter<Integer> counter) {
		value += counter.getValue();
	}

	@Override
	public Integer getValue() {
		return value;
	}
}
