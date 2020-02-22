package com.nickperov.labs.jcstress.counter;

import java.util.concurrent.atomic.AtomicInteger;

public class MutableAtomicCounter implements Counter<Integer> {

	private final AtomicInteger value = new AtomicInteger(0);
	
	@Override
	public void append(Counter<Integer> counter) {
		value.addAndGet(counter.getValue());
	}

	@Override
	public Integer getValue() {
		return value.get();
	}
}
