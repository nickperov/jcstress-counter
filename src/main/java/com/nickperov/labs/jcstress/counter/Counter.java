package com.nickperov.labs.jcstress.counter;

public interface Counter<T> {

	void append(Counter<T> counter);
	
	T getValue();

}
