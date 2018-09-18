import java.util.Scanner;
class Solution {
	public static void main(String[] args) {
		FitByte fit = new FitByte();
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			String line = s.nextLine();
			String[] token = line.split(" "); 
			switch(token[0]) {
				case "Food":
					String[] log = token[1].split(",");
					fit.addfood(new food(log[0],log[1],log[2],log[3]));
					break;
				case "Water":
					String[] waterlog = token[1].split(",");
					fit.addwater(new water(waterlog[0],waterlog[1],waterlog[2]));
					break;
				case "PhysicalActivity":
					String[] activitylog = token[1].split(",");
					if(activitylog.length==4) {
						fit.addphysicalactivity(new activity(activitylog[0],activitylog[1],activitylog[2],activitylog[3]));
					} else {
						fit.addphysicalactivity(new activity(activitylog[0],activitylog[1],activitylog[2],activitylog[3],activitylog[4]));
					}
					break;
				case "Sleep":
					String[] sleeplog = token[1].split(",");
					fit.addsleep(new sleep(sleeplog[0],sleeplog[1],sleeplog[2]));
					break;
				case "Weight":
					String[] data = token[1].split(",");
					fit.addweight(new weight(data[0],data[1],data[2],data[3]));
					break;
				case "Foodlog":
					fit.foodlog();
					break;
				case "Waterlog":
					fit.waterlog();
					break;
				case "PhysicalActivitylog":
					fit.activitylog();
					break;
				case "Weightlog":
					fit.weightlog();
				case "Sleeplog":
					fit.sleeplog();
					break;
				case "Summary":
					fit.summary();
					break;
				default:
					break;
			}
		}
	}
}
class food {
	private String fooditem;
	private String quantity;
	private String time;
	private String date;
	food(String fooditem1, String quantity1,String date1, String time1) {
		fooditem = fooditem1;
		quantity = quantity1;
		time = time1;
		date = date1;
	}
	public String toString() {
		String s = "Food\nDate:"+date+"\nTime"+time+"\nName:"+fooditem+"\nQuantity:"+quantity;
		return s;
	}
}
class water {
	private String waterquantity;
	private String date;
	private String time;
	water(String waterquantity1, String date1, String time1) {
		waterquantity = waterquantity1;
		date = date1;
		time = time1;
	}
	public String toString() {
		String s = "Water\nDate"+date+"\nQuantity:"+waterquantity+"ml";
		return s;
	}
}
class activity {
	private String activityname;
	private String date;
	private String starttime;
	private String endtime;
	private String notes;
	activity(String activityname1, String date1,
	 String starttime1, String endtime1) {
		activityname = activityname1;
		date = date1;
		starttime = starttime1;
		endtime = endtime1;
	}
	activity(String activityname1, String notes1, String date1,
	 String starttime1, String endtime1) {
		activityname = activityname1;
		date = date1;
		starttime = starttime1;
		endtime = endtime1;
		notes = notes;
	}
	public String toString() {
		String s = "PhysicalActivity\nName:"+activityname+"\nNotes:"+notes+"\nDate:"+date+"\nStartTime:"+starttime+"\nEndTime:"+endtime;
		return s;
	}

}
class weight {
	private String weight;
	private String fat;
	private String date;
	private String time;
	weight() {

	}
	weight(String date1, String time1, String weight1, String fat1) {
		weight = weight1;
		fat = fat1;
		date = date1;
		time = time1;
	}
	public String toString() {
		String s = "Weight\nDate:"+date+"\nTime:"+time+"\nWeight:"+weight+"\nFat:"+fat;
		return s;
	}
}
class sleep {
	private String date;
	private String starttime;
	private String endtime;
	sleep(String date1,String starttime1, String endtime1) {
		date = date1;
		starttime = starttime1;
		endtime = endtime1;
	}
	public String toString() {
		String s = "Sleep\nDate:"+date+"\nStarttime:"+starttime+"\nEndtime:"+endtime;
		return s; 
	}
}


class FitByte {
	private final int ten = 10;
	private food[] fooditems;
	private int foodcount;
	private activity[] activities;
	private int activitycount;
	private sleep[] doze;
	private int sleepcount;
	private weight weighting;
	private water[] drink;
	private int watercount;

	FitByte() {
		fooditems = new food[ten];
		activities = new activity[ten];
		doze = new sleep[ten];
		drink = new water[ten];
		weighting = new weight();
		foodcount = 0;
		activitycount = 0;
		sleepcount = 0;
		watercount = 0;

	}
	public void addfood(food f) {
		fooditems[foodcount++] = f;
	}
	public void addphysicalactivity(activity a) {
		activities[activitycount++] = a;
	}
	public void addweight(weight w) {
		weighting = w;
	}
	public void addwater(water wa) {
		drink[watercount++] = wa;
	}
	public void addsleep(sleep s) {
		doze[sleepcount++] = s;
	}
	public void foodlog() {
		for(int i=0; i<foodcount;i++) {
			System.out.println(fooditems[i]);
			System.out.println();
		}
	}
	public void waterlog() {
		for(int i=0;i<watercount;i++) {
			System.out.println(drink[i]);
			System.out.println();
		}
	}
	public void weightlog() {
		System.out.println(weighting);
		System.out.println();
	}
	public void activitylog() {
		for(int i=0;i<activitycount;i++) {
			System.out.println(activities[i]);
			System.out.println();
		}
	}
	public void sleeplog() {
		for(int i=0;i<sleepcount;i++) {
			System.out.println(doze[i]);
			System.out.println();
		}
	}
	public void summary() {
		foodlog();
		waterlog();
		weightlog();
		activitylog();
		sleeplog();

	}
}
