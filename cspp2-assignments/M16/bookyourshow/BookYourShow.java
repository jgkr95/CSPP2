import java.util.Arrays;
class Show {
	private String movie;
	private String dateandtime;
	public String[] seatnumbers;
	Show(String moviename, String datetime, String[] seats) {
		movie = moviename;
		dateandtime = datetime;
		seatnumbers = seats;

	}
	public String toString() {
		return movie + "," + dateandtime + "," + Arrays.toString(seatnumbers);
	}
	public String getmovie() {
		return movie;
	}
	public String getdate() {
		return dateandtime;
	}
	public String[] getseats() {
		return seatnumbers;
	}

}
class Patron {
	private String name;
	private String mobilenumber;
	Patron(String patronname, String phonenumber) {
		name = patronname;
		mobilenumber = phonenumber;
	}
	public String getNum() {
		return mobilenumber;
	}
}

class BookYourShow {
	private int count = 0;
	private Show[] s;
	private Patron[] patrons;
	private int patronscount = 0;
	public void addAShow(Show showobj) {
		// s[count++] = showobj;
		s[count++] = new Show(showobj.getmovie(), showobj.getdate(), showobj.getseats());
		// count++;

	}
	public Show getAShow(String movie, String date) {

		for (int i = 0; i < count; i++) {
			if (s[i].getmovie().equals(movie) && s[i].getdate().equals(date)) {
				return s[i];
			}
		}
		return null;

	}
	public void bookAShow(String moviename, String date, Patron p, String[] seats) {
		Show checkshow = getAShow(moviename, date);
		if (checkshow != null) {
			for (int i = 0; i < seats.length; i++) {
				for (int j = 0; j < checkshow.seatnumbers.length; j++) {
					if (seats[i].equals(checkshow.seatnumbers[j])) {
						checkshow.seatnumbers[j] = "N/A";
						// flag=1;
						patrons[patronscount++] = p;
					}
				}
			}
		}

	}
	public void printTicket(String moviename, String date, String mobieno) {
		String str = "Invalid";
		if (getAShow(moviename, date) != null) {
			str = "No Show";
			for (int i = 0; i < count; i++) {
				str = "Invalid";
				if (patrons[i].getNum().equals(mobieno)) {
					str = mobieno + " " + moviename + " " + date;
					break;
				}
			}
		}
		System.out.println(str);
	}
	public void showAll() {
		for (int i = 0; i < count; i++) {
			System.out.println(s[i]);
		}

	}
}
