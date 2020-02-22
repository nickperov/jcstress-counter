package com.nickperov.labs.jcstress.counter;

import org.openjdk.jcstress.annotations.Actor;

public abstract class AbstractCounterStressTest<T extends Counter<Integer>> {

	private static final Counter<Integer> appender = new Counter<Integer>() {
		@Override
		public void append(Counter<Integer> counter) {
			throw new UnsupportedOperationException();
		}

		@Override
		public Integer getValue() {
			return 1;
		}
	};

	final private T counter = getCounterInstance();

	abstract T getCounterInstance();

	void executeAppend() {
		counter.append(appender);
	}

	Integer getCounterValue() {
		return counter.getValue();
	}

}
