/*
 * Program: Student Database Application 
 * Author: Eliezer 
 * Date: November 10, 2023
 * Description: This Java console program manages University student's course enrollment and calculates their balance
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StudentDatabase {
	
	//Member variables for student information
	private String studentFirstName;
	private String studentLastName;
	private int yearOfStudent;
	private String studentID;
	private String[] enrolledCourses; 
	private final int COST_PER_COURSE = 600;
	private int tuitionBalance;
	private static int id = 1000;
	
	//Constructor for initializing student information
	public StudentDatabase() {
		Scanner in = new Scanner(System.in);
		
		//User input for first name
		System.out.print("\nEnter first name: ");
		studentFirstName = in.nextLine();	
		
		//User input for last name
		System.out.print("Enter last name: ");
		studentLastName = in.nextLine();	
		
		//User input for last name
		System.out.print("\nWhat is your current year\n1.Freshmen\n2.Sophmore\n3.Junior\n4.Senior\nEnter student's year: ");
		yearOfStudent = in.nextInt();		
	}
	
	//Method to get the student's ID
	public String getStudentId() {
		return studentID;
	}
	
	//Method to generate a unique student ID
	public void setStudentId() {
		//Grade level + studentId
		studentID = yearOfStudent + "" + (id++);
	}
	
	//Method will prompt user to enter courses they which to be enrolled and and will calculate their balance
	public void enrollment() {
		Scanner in = new Scanner(System.in);
		
		List<String> courseList = new ArrayList<>();
		String course;
		
		do {
			System.out.print("\nEnter course name to be enroll (Enter Q to quit): ");
			course = in.nextLine();
			switch (course) {
		    case "History 101":
		    case "Mathematics 101":
		    case "English 101":
		    case "Chemistry 101":
		    case "Computer Science 101":
		    	courseList.add(course);
		        System.out.println("ENROLLED IN: " + course);
		        break;
		    case "Q":
            case "q":
                break;
		    default:
		        System.out.println("Invalid course selection: " + course);
		        break;
			}
		} while (!course.equalsIgnoreCase("Q"));
		
		enrolledCourses = courseList.toArray(new String[0]);
		
		tuitionBalance = enrolledCourses.length * COST_PER_COURSE;
	}
	
	//Method to get tuition balance
		public int getViewBalance() {
			//
			return tuitionBalance;
		}
	
	//vMethod to display tuition balance
	public void viewBalance() {
		System.out.println("Your Balance is: $" + tuitionBalance);
	}
	
	//Method for making a tuition payment
	public void makeTuitionPayment() {
		Scanner in = new Scanner(System.in);
		System.out.println("\nEnter Payment amount: ");
		int payment = in.nextInt();
		System.out.println("\nThank you for your payment of $" + payment);
		tuitionBalance = tuitionBalance - payment;
	}
	
	// Method to display student information
	public String showStudentInfo() {
		return "\nStudentd's full name: " + studentFirstName + " " + studentLastName + 
				"\nStudent's ID: " +  getStudentId() + 
				"\nEnrolled Courses: " + Arrays.toString(enrolledCourses);
	}
	
	// Method to display All students 
	public String showAllStudentInfo() {
		return "\nStudentd's full name: " + studentFirstName + " " + studentLastName + 
				"\nStudent's ID: " +  getStudentId() + 
				"\nEnrolled Courses: " + Arrays.toString(enrolledCourses) +
				"\nBalance: $" + getViewBalance();
	}

}
