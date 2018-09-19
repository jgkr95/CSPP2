import java.io.*;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.Arrays;
public class Solution {

	private static SocialNetwork s = new SocialNetwork();

	public static void main(String[] args) throws Exception {
		// File file = new File("socialnetwork.txt");
		// Scanner br = new Scanner(new FileReader(file));
		Scanner sc = new Scanner(System.in);
		String st;
		// while (br.hasNext()) {
		// st = br.nextLine();
		// 	String[] list = st.split(" is connected to ");
		// 	String[] connetionedlist = list[1].replace(" ", "").replace(".", "").split(",");
		// 	s.addUser(new User(list[0], connetionedlist));
		// }
		while (sc.hasNext()) {
			String line = sc.nextLine();
			// line = line.replace("(", " ").replace(")", "");
			String[] tokens = line.split(" ");
			// System.out.println(Arrays.toString(tokens)+"=="+tokens.length);
			switch (tokens[0]) {
			case "Create":
				System.out.println(Integer.parseInt(tokens[1]));
				for(int i=0;i<Integer.parseInt(tokens[1]);i++) {
					st = sc.nextLine();
					String[] list = st.split(" is connected to ");
					String[] connetionedlist = list[1].replace(" ", "").replace(".", "").split(",");
					s.addUser(new User(list[0], connetionedlist));
				}
				break;
			case "getConnections":
				s.getConnections(tokens[1]);
				break;
			case "addConnections":
				// String[] data = tokens[1].split(",");
				s.addconnection(tokens[1], tokens[2]);
				break;
			case "CommonConnections":
				// String[] data1 = tokens[1].split(",");
				s.getcommonconnections(tokens[1], tokens[2]);
				break;
			case "Network":
				s.network();
			default:
				break;
			}
		}
	}
}
class SocialNetwork {
	private int usercount;
	private final int twenty = 20;
	private User[] user;
	SocialNetwork() {
		usercount = 0;
		user = new User[twenty];
	}
	public void network() {
		int i;
		for(i=0;i<usercount - 1;i++) {
			System.out.print(user[i].getname()+": "+Arrays.toString(user[i].getconnectedlist())+", ");
		}
		System.out.println(user[i].getname()+": "+Arrays.toString(user[i].getconnectedlist()));
	}
	public void addUser(User user1) {
		User t = new User();
		user[usercount++] = user1;
		// System.out.println(usercount);
		for (int i = 0; i < usercount - 1; i++) {
			for (int j = i + 1; j < usercount; j++) {
				if (user[i].getname().compareTo(user[j].getname()) > 0) {
					t = user[i];
					user[i] = user[j];
					user[j] = t;
				}
			}
		}
	}
	public void getConnections(String follow) {
		String[] connections = new String[twenty];
		int flag = 0;
		for (int i = 0; i < usercount; i++) {
			if (user[i].getname().equals(follow)) {
				connections = user[i].getconnectedlist();
				flag = 1;
			}
		}
		if(flag == 1) {
			System.out.println(Arrays.toString(connections));
		} else {
			System.out.println("Not a user in Network");
		}
	}
	public void addconnection(String name, String connect) {
		for (int i = 0; i < usercount; i++) {
			// System.out.println("Enter the dragon");
			// System.out.println(user[i].getname()+"_____"+name);
			if (user[i].getname().equals(name)) {
				// System.out.println("======");
				user[i].setaddconnector(connect);
				break;
			}
		}
	}
	public void getcommonconnections(String common1, String common2) {
		String[] firstlist = new String[twenty], secondlist = new String[twenty], commonlist = new String[twenty];
		// commonlist = new String[twenty];
		int size = 0;
		for (int i = 0; i < usercount; i++) {
			if (user[i].getname().equals(common1)) {
				firstlist = user[i].getconnectedlist();

			}
		}
		// System.out.println(Arrays.toString(firstlist));
		for (int j = 0; j < usercount; j++) {
			if (user[j].getname().equals(common2)) {
				secondlist = user[j].getconnectedlist();
			}
		}
		// System.out.println(Arrays.toString(secondlist));
		try {
		for (int i = 0; i < firstlist.length; i++) {
			for (int j = 0; j < secondlist.length; j++) {
				if (firstlist[i].equals(secondlist[j])) {
					// if(!(firstlist[i].equals(null))) {
					commonlist[size++] = firstlist[i];
					// }
				}
			}
		}
		String[] commonlist1 = new String[size];
		System.arraycopy(commonlist, 0, commonlist1, 0, size);
		System.out.println(Arrays.toString(commonlist1));
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
class User {
	private String name;
	private final int twenty = 20;
	private String[] connectedlist = new String[20];
	User() {

	}

	User(String name1, String[] connectedlist1) {
		name = name1;
		connectedlist = connectedlist1;
		// System.out.println(name + "__" + Arrays.toString(connectedlist));
	}
	public void setaddconnector(String follow) {
		String[] data = getconnectedlist();
		System.out.println("Enter the dragon into user");
		connectedlist = Arrays.copyOf(data, connectedlist.length + 1);
		connectedlist[connectedlist.length - 1] = follow;
		// for (int i = 0; i < connectedlist.length; i++) {
		// 	System.out.println("Enter the dragon in to user");
		// 	if (connectedlist[i].equals(null)||connectedlist[i].equals("")) {
		// 		connectedlist[i] = follow;
		// 		System.out.println(connectedlist[i]);
		// 		break;
		// 	}
		// }
	}
	public String getname() {
		return name;
	}
	public String[] getconnectedlist() {
		return connectedlist;
	}
}
