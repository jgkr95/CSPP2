class Task {
	private String tasktitle;
	private String taskowner;
	private int timeperiod;
	private boolean importantornot;
	private boolean urgentornot;
	private String progress;

	Task(String tasktitle1, String taskowner1, int timeperiod1,
	 boolean importantornot1, boolean urgentornot1, String progress1) throws Exception{
		if(!(tasktitle1.length()>0)) {
			throw new Exception("Title not provided");
		}
		if(timeperiod1<0) {
			throw new Exception("Invalid timeToComplete "+timeperiod1);
		}
		if(!(progress1.equals("todo")||progress1.equals("done"))) {
			throw new Exception("Invalid status "+progress1);
		}
		tasktitle=tasktitle1;
		taskowner=taskowner1;
		timeperiod=timeperiod1;
		importantornot=importantornot1;
		urgentornot=urgentornot1;
		progress=progress1;
	}
	public String gettaskowner() {
		return taskowner;
	}
	public boolean getimportant() {
		return importantornot;
	}
	public boolean geturgent() {
		return urgentornot;
	}
	public String getprogress() {
		return progress;
	}
	public int gettimeperiod() {
		return timeperiod;
	}
	public String toString() {
		String imp;
		String urg;
		if(importantornot) {
			imp = "Important";
		} else {
			imp = "Not Important";
		}
		if(urgentornot) {
			urg = "Urgent";
		} else {
			urg = "Not Urgent";
		}
		String str = tasktitle + ", "+taskowner+", "+timeperiod+", "+imp+", "+urg+", "+progress;
		return str;
	}
} 
class Todoist {
	Task[] taskobj;
	int size;
	final int twenty = 20;
	Todoist() {
		taskobj = new Task[twenty];
		size = 0;
	}
	public void addTask(Task t) {
		taskobj[size++] = t;
	}
	public String toString() {
		String str = "";
		for(int i=0;i<size;i++) {
			str += taskobj[i].toString()+"\n";
		}
		return str;
	}
	public Task getNextTask(String name) {
		for(int i=0;i<size;i++) {
			if(taskobj[i].gettaskowner().equals(name)&&taskobj[i].getimportant()&&(!(taskobj[i].geturgent()))&&taskobj[i].getprogress().equals("todo")) {
				return taskobj[i];
			} else if(taskobj[i].gettaskowner().equals(name)&&taskobj[i].getimportant()&&taskobj[i].geturgent()&&taskobj[i].getprogress().equals("todo")) {
				return taskobj[i];
			}
			
		}
		return null;

	}
	public Task[] getNextTask(String name, int count) {
		Task[] nexttasks = new Task[count];
		int sizenexttask = 0;
		for(int i=0;i<size;i++) {
			if(sizenexttask>count) {
			if(taskobj[i].gettaskowner().equals(name)&&taskobj[i].getimportant()&&(!(taskobj[i].geturgent()))&&taskobj[i].getprogress().equals("todo")) {
				nexttasks[sizenexttask++]=taskobj[i];
			} else if(taskobj[i].gettaskowner().equals(name)&&taskobj[i].getimportant()&&taskobj[i].geturgent()&&taskobj[i].getprogress().equals("todo")) {
				nexttasks[sizenexttask++]=taskobj[i];
			}
		}}
		return nexttasks;

	}
	public int totalTime4Completion() {
		int time=0;
		for(int i=0;i<size;i++) {
			if(taskobj[i].getprogress().equals("todo"))
				time += taskobj[i].gettimeperiod();
		}
		return time;
	}

}