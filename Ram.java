
import java.util.Scanner;

class Student {

    String studentName;
    String rollNumber;
    double marks;
    String courseName;
    int courseCredits;

    // Parameterized constructor
    Student(String studentName, String rollNumber, double marks,
            String courseName, int courseCredits) {

        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    // Calculate course fee
    double calculateFee() {
        return courseCredits * 1500;
    }

    // Check eligibility
    boolean checkEligibility() {
        return marks >= 50;
    }

    // Calculate scholarship percentage
    double calculateScholarship() {
        if (marks >= 85) {
            return 20;
        } else if (marks >= 70) {
            return 10;
        } else {
            return 0;
        }
    }

    // Calculate final fee
    double calculateFinalFee() {
        double fee = calculateFee();
        double scholarshipPercent = calculateScholarship();
        double scholarshipAmount = fee * scholarshipPercent / 100;

        return fee - scholarshipAmount;
    }

    // Display all details
    void displayDetails() {

        double fee = calculateFee();
        double scholarshipPercent = calculateScholarship();
        double scholarshipAmount = fee * scholarshipPercent / 100;
        double finalFee = calculateFinalFee();

        System.out.println("\n===== Student Course Registration Details =====");
        System.out.println("Student Name       : " + studentName);
        System.out.println("Roll Number        : " + rollNumber);
        System.out.println("Marks              : " + marks);
        System.out.println("Course Name        : " + courseName);
        System.out.println("Course Credits     : " + courseCredits);

        System.out.println("Eligibility        : Eligible");
        System.out.println("Total Fee          : Rs. " + fee);
        System.out.println("Scholarship        : " + scholarshipPercent + "%");
        System.out.println("Scholarship Amount : Rs. " + scholarshipAmount);
        System.out.println("Final Fee          : Rs. " + finalFee);
    }
}

public class Ram {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String studentName = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        String rollNumber = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Course Name: ");
        String courseName = sc.nextLine();

        System.out.print("Enter Course Credits: ");
        int courseCredits = sc.nextInt();

        // Create object using parameterized constructor
        Student  student = new Student(
                studentName,
                rollNumber,
                marks,
                courseName,
                courseCredits
        );

        // Check eligibility first
        if (student.checkEligibility()) {

            student.displayDetails();

        } else {

            System.out.println("\nStudent is NOT eligible for course registration.");
            System.out.println("Minimum required marks: 50");
        }
    }
}


