package todoList;

import java.util.Comparator;

public class Task {

	private int priority;
	private int timeToFinish;
	private boolean isFinished;

	public Task(int timeToFinish) {
		this.timeToFinish = timeToFinish;
		this.isFinished = false;
	}

	public Task() {
		this(2);
	}

	public int getPriority() {
		return priority;
	}

	void setPriority(int priority) {
		this.priority = priority;
	}

	public int getTimeToFinish() {
		return timeToFinish;
	}

	public boolean getIsFinished() {
		return isFinished;
	}

	public void finish() {
		isFinished = true;
	}

	public static Comparator<Task> StudentComparator = new Comparator<Task>() {

		public int compare(Task task1, Task task2) {
			return task1.priority - task2.priority;
		}

	};

}
