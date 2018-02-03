package com.ocelot.thread;

class PooledThread extends Thread {

	private static IdAssigner threadId = new IdAssigner(1);

	private ThreadPool pool;

	public PooledThread(ThreadPool pool) {
		super(pool, "PooledThread-" + threadId.next());
		this.pool = pool;
	}

	@Override
	public void run() {
		while (!isInterrupted()) {
			Runnable task = null;
			try {
				task = pool.getTask();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (task == null)
				return;

			try {
				task.run();
			} catch (Throwable t) {
				pool.uncaughtException(this, t);
			}
		}
	}
}