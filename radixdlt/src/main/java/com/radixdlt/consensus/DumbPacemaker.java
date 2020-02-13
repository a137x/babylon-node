package com.radixdlt.consensus;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

public class DumbPacemaker {
	private AtomicReference<Consumer<Void>> callbackRef;
	private Thread thread;

	public DumbPacemaker() {
		this.callbackRef = new AtomicReference<>();
	}

	public void start() {
		this.thread = new Thread(this::process, "Dumb Pacemaker");
		this.thread.start();
	}

	private void process() {
		while (true) {
			try {
				Thread.sleep(200);
				Consumer<Void> callback = callbackRef.get();
				if (callback != null) {
					callback.accept(null);
				}
			} catch (InterruptedException e) {
			}
		}
	}

	public void addCallback(Consumer<Void> callback) {
		this.callbackRef.set(callback);
	}
}
