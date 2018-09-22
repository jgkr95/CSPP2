/**
 * Class for task.
 */
class Task {
	/**
	 * { Name of the task }.
	 */
	private String tasktitle;
	/**
	 * { Task assigned person name }.
	 */
	private String taskowner;
	/**
	 * { Time required to complete task }.
	 */
	private int timeperiod;
	/**
	 * { Whteher task is important or not }.
	 */
	private boolean importantornot;
	/**
	 * { Whether Task is urgent or not }.
	 */
	private boolean urgentornot;
	/**
	 * { Status of task }.
	 */
	private String progress;
	/**
	 * Constructs the object.
	 *
	 * @param      tasktitle1       The tasktitle 1 is of string type
	 * @param      taskowner1       The taskowner 1 is of string type
	 * @param      timeperiod1      The timeperiod 1 is of integer type
	 * @param      importantornot1  The importantornot 1 is of boolean type
	 * @param      urgentornot1     The urgentornot 1 is of boolean type
	 * @param      progress1        The progress 1 is of string type
	 */
	Task(String tasktitle1, String taskowner1, int timeperiod1,
	     boolean importantornot1, boolean urgentornot1, String progress1) throws Exception {
		if (!(tasktitle1.length() > 0)) {
			throw new Exception("Title not provided");
		}
		if (timeperiod1 < 0) {
			throw new Exception("Invalid timeToComplete " + timeperiod1);
		}
		if (!(progress1.equals("todo") || progress1.equals("done"))) {
			throw new Exception("Invalid status " + progress1);
		}
		tasktitle = tasktitle1;
		taskowner = taskowner1;
		timeperiod = timeperiod1;
		importantornot = importantornot1;
		urgentornot = urgentornot1;
		progress = progress1;
	}
	/**
	 * { gives person to whom task assigned to }.
	 *
	 * @return     { string }
	 */
	public String gettaskowner() {
		return taskowner;
	}
	/**
	 * { Give true if important task else flase }.
	 *
	 * @return     { boolean }
	 */
	public boolean getimportant() {
		return importantornot;
	}
	/**
	 * { Gives true if task is urgent else false }.
	 *
	 * @return     { boolean }
	 */
	public boolean geturgent() {
		return urgentornot;
	}
	/**
	 * { Gives the status of the task }.
	 *
	 * @return     { String }
	 */
	public String getprogress() {
		return progress;
	}
	/**
	 * { Gives time of the task }.
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int gettimeperiod() {
		return timeperiod;
	}
	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		String imp;
		String urg;
		if (importantornot) {
			imp = "Important";
		} else {
			imp = "Not Important";
		}
		if (urgentornot) {
			urg = "Urgent";
		} else {
			urg = "Not Urgent";
		}
		String str = tasktitle + ", " + taskowner + ", " +
		 timeperiod + ", " + imp + ", " + urg + ", " + progress;
		return str;
	}
}
/**
 * Class for todoist.
 */
class Todoist {
	Task[] taskobj;
	int size;
	final int fifty = 50;
	/**
	 * Constructs the object.
	 */
	Todoist() {
		taskobj = new Task[fifty];
		size = 0;
	}
	/**
	 * Adds a task.
	 *
	 * @param      t     { Task class object }
	 */
	public void addTask(Task t) {
		taskobj[size++] = t;
	}
	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		String str = "";
		for (int i = 0; i < size; i++) {
			str += taskobj[i].toString() + "\n";
		}
		return str;
	}
	/**
	 * Gets the next task of the given name.
	 *
	 * @param      name  The name
	 *
	 * @return     The next task in Task class object.
	 */
	public Task getNextTask(String name) {
		for (int i = 0; i < size; i++) {
			if (taskobj[i].gettaskowner().equals(name) && taskobj[i].getimportant()
			 && (!(taskobj[i].geturgent())) && taskobj[i].getprogress().equals("todo")) {
				return taskobj[i];
			}

		}
		for (int i = 0; i < size; i++) {
			if (taskobj[i].gettaskowner().equals(name) && taskobj[i].getimportant()
			 && taskobj[i].geturgent() && taskobj[i].getprogress().equals("todo")) {
				return taskobj[i];
			}
		}
		return null;

	}
	/**
	 * Gets the next task and gives the array of Task class objects.
	 *
	 * @param      name   The name
	 * @param      count  The count
	 *
	 * @return     The next task in array of Task objects.
	 */
	public Task[] getNextTask(String name, int count) {
		Task[] nexttasks = new Task[count];
		int sizenexttask = 0;
		for (int i = 0; i < size; i++) {
			if (sizenexttask < count) {
				if (taskobj[i].gettaskowner().equals(name) && taskobj[i].getimportant()
				 && (!(taskobj[i].geturgent())) && taskobj[i].getprogress().equals("todo")) {
					nexttasks[sizenexttask++] = taskobj[i];
				} else if (taskobj[i].gettaskowner().equals(name) && taskobj[i].getimportant()
				 && taskobj[i].geturgent() && taskobj[i].getprogress().equals("todo")) {
					nexttasks[sizenexttask++] = taskobj[i];
				}
			}
		}
		return nexttasks;

	}
	/**
	 * { Calculates total time for all given tasks }
	 *
	 * @return     { integer }
	 */
	public int totalTime4Completion() {
		int time = 0;
		for (int i = 0; i < size; i++) {
			if (taskobj[i].getprogress().equals("todo"))
				time += taskobj[i].gettimeperiod();
		}
		return time;
	}
}
