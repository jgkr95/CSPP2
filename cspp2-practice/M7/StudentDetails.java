class Student {
	private String name_;
	private String roll_Number;
	private double grade1;
	private double grade2;
	private double grade3;
	/**
	 * Constructs the object.
	 *
	 * @param      name         Of string type
	 * @param      roll_number  Of string type
	 * @param      m1           of double type
	 * @param      m2           of double type
	 * @param      m3           of double type
	 */
	Student(String name, String roll_number, double m1, double m2, double m3) {
		this.name_ = name;
		this.roll_Number = roll_number;
		grade1 = m1;
		grade2 = m2;
		grade3 = m3;	
	}
	/**
	 * { function_description }
	 *
	 * @param      y     { Object of Student }
	 *
	 * @return     { Returns avg of gpa }
	 */
	public double GPA(Student y) {
		return Math.floor(((y.grade1 + y.grade2 + y.grade3) / 3.0) * 10) / 10.0;
	}
}
class StudentDetails {
	/**
	 * { Main function this creates objects of class student
	 * and pasees values}.
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		Student s1 = new Student("Sangay", "IT201985001", 7.5, 7.0, 8.0);
		Student s2 = new Student("Bidhya", "IT201985003", 8.5, 6.0, 7.5);
		Student s3 = new Student("Kelzang", "IT201985065", 7.5, 8.0, 9.0);
	System.out.println(s1.GPA(s1));
	System.out.println(s2.GPA(s2));
	System.out.println(s3.GPA(s3));
	}
}