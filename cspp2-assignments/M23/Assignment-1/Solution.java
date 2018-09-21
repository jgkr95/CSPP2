import java.io.*;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		try {
		String dirPath = sc.next();
		File dir = new File(dirPath);
		String[] files = dir.list();
		String temp;
		for(int i=0;i<files.length;i++) {
			for(int j=i+1;j<files.length;j++) {
				if((files[i].compareTo(files[j]))>0) {
					temp = files[i];
					files[i] = files[j];
					files[j] = temp;
				}
			}
		}
		int[][] cos = new int[files.length][files.length];
		// System.out.println(Arrays.toString(files));
		// System.out.println(files[0]);
		if (files.length == 0) {
		    System.out.println("empty directory");
		} else {
		    for (int i=0;i<files.length;i++) {
		    	for(int j=0;j<files.length;j++) {
		        // System.out.println(aFile);
			        HashMap<String, Integer> firstfile = readfile(new Scanner(new FileReader(dir+"//"+files[i])));
					HashMap<String, Integer> secondfile = readfile(new Scanner(new FileReader(dir+"//"+files[j])));
					Integer[] firstkeyvalues = firstfile.values().toArray(new Integer[0]);
					Integer[] secondkeyvalues = secondfile.values().toArray(new Integer[0]);
					double euclidnorm1 = Euclideannorm(firstkeyvalues), euclidnorm2 = Euclideannorm(secondkeyvalues);
					double dotpro = dotproduct(firstfile, secondfile);
					cos[i][j] = (int) Cosinesimilarity(euclidnorm1,euclidnorm2,dotpro)*100;
					
				}
		    }
		}
		// System.out.println(Arrays.deepToString(cos));
		int max = 0;
		int index1 = 100, index2 = 100;
		for(int i=0;i<files.length;i++) {
			System.out.print("  \t"+files[i]);
		}System.out.println();
		for(int i=0;i<files.length;i++) {
			System.out.print(files[i]+"\t");
			for(int j=0;j<files.length;j++) {
				System.out.print(cos[i][j]+"\t  ");
				if(cos[i][j]<100&&cos[i][j]>max) {
					max = cos[i][j];
					index1 = i;
					index2 = j;
				}
			}System.out.println();
		}
	} catch(Exception e) {
		System.out.println("empty directory");
		// System.out.println("Maximum similarity is between "+ +" and ");
	}
	}
	public static double Euclideannorm(Integer[] euc) {
		double mod=0,euclid=0;
		for(int i=0;i<euc.length;i++) {
			mod += Math.pow(euc[i],2);
		}
		euclid = Math.sqrt(mod);
		return euclid;
	}
	public static double dotproduct(HashMap<String, Integer> ffile1, HashMap<String, Integer> ffile2) {
		String[] file1keys = ffile1.keySet().toArray(new String[0]);
		int similarity=0;
		for(int i=0;i<file1keys.length;i++) {
			if(ffile2.containsKey(file1keys[i])) {
				similarity += ffile1.get(file1keys[i])*ffile2.get(file1keys[i]);
			}
		}
		return similarity;

	}
	public static double Cosinesimilarity(double denominator1, double denominator2, double numerator) {
		double cosine = numerator/(denominator1 * denominator2);
		return cosine;

	}
	public static HashMap<String, Integer> readfile(Scanner s) {
		HashMap<String, Integer> wordsinfile = new HashMap<String, Integer>();
		while (s.hasNext()) {
			String line = s.nextLine().toLowerCase();
			line = line.replaceAll("[0-9_]", " ").replaceAll("\\s+"," ");
			String[] words = line.split(" ");
			//System.out.println(Arrays.toString(words));
			for (int i = 0; i < words.length && words[i].length() > 0; i++) {
				// System.out.println("_"+words[i]+"_");
				if (wordsinfile.containsKey(words[i].replace(" ",""))) {
					wordsinfile.put(words[i].replace(" ",""), wordsinfile.get(words[i]) + 1);
				} else {
					wordsinfile.put(words[i].replace(" ",""), 1);
				}
			}
		}
		// System.out.println("===============");
		return wordsinfile;
	}
}