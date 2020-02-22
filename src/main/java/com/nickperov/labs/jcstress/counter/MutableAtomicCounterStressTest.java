package com.nickperov.labs.jcstress.counter;

import org.openjdk.jcstress.annotations.Actor;
import org.openjdk.jcstress.annotations.Arbiter;
import org.openjdk.jcstress.annotations.Expect;
import org.openjdk.jcstress.annotations.JCStressTest;
import org.openjdk.jcstress.annotations.Outcome;
import org.openjdk.jcstress.annotations.State;
import org.openjdk.jcstress.infra.results.I_Result;

@JCStressTest
@Outcome(id = "0", expect = Expect.FORBIDDEN, desc = "Atomicity failure")
@Outcome(id = "1", expect = Expect.FORBIDDEN, desc = "Atomicity failure")
@Outcome(id = "2", expect = Expect.ACCEPTABLE, desc = "Both appends executed correctly")
@State
public class MutableAtomicCounterStressTest extends AbstractCounterStressTest<MutableAtomicCounter> {

	@Override
	MutableAtomicCounter getCounterInstance() {
		return new MutableAtomicCounter();
	}

	@Actor
	public void actor1() {
		executeAppend();
	}

	@Actor
	public void actor2() {
		executeAppend();
	}

	@Arbiter
	public void arbiter(I_Result r) {
		r.r1 = getCounterValue();
	}
}
