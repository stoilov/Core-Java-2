package todoList;

import java.util.PriorityQueue;

public class ToDoList {

	private PriorityQueue<Task> tasks = new PriorityQueue<Task>(Task.StudentComparator);
	private int totalTime;
	
	public ToDoList(int totalTime) {
		this.totalTime = totalTime;
	}
	
	public void add(Task a) {
		tasks.add(a);
	}
	
	public void markFinished(Task t) {
		tasks.remove(t);
		t.finish();
		tasks.add(t);
	}
	
	public void markCancelled(Task t) {
		tasks.remove(t);
	}
	
	public Task getTop() {
		return tasks.peek();
	}
	
	public boolean canFinish() {
		int timeNeeded = 0;
		
		for (Task task : tasks) {
			if (!task.getIsFinished()) {
				timeNeeded += task.getTimeToFinish();
			}
		}
		
		return !(timeNeeded > totalTime);
	}
	
	public int getRemainigTime() {
		int timeNeeded = 0;
		
		for (Task task : tasks) {
			if (task.getIsFinished()) {
				timeNeeded += task.getTimeToFinish();
			}
		}
		
		return totalTime - timeNeeded;
	}
	
}
