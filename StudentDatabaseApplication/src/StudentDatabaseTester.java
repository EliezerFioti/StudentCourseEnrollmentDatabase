import java.util.Scanner;

public class StudentDatabaseTester extends StudentDatabase {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("How many new students will be added to the database: ");
		int numStudentsToEnroll = in.nextInt();
		StudentDatabase[] student = new StudentDatabase[numStudentsToEnroll];
		
		//Creating n number of students in memory
		for(int n = 0; n < numStudentsToEnroll; n++) {
			
			student[n] = new StudentDatabase();
			
			student[n].enrollment();
			
			student[n].setStudentId();
				
			System.out.println(student[n].showStudentInfo());
				
			student[n].viewBalance();
				
			student[n].makeTuitionPayment();
				
			student[n].viewBalance();
		}
		
		for(int n = 0; n < numStudentsToEnroll; n++) {
			System.out.println(student[n].showAllStudentInfo());
		}
		
		in.close();
	}
}
