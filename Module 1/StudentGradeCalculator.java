public class StudentGradeCalculator {
    public static void main(String[] args) {
        String studentName = "Delaney Yeakle";
        String major = "Computer Science";
        String courseName = "CMPS 360";

        double grade1 = 97;
        double grade2 = 88;
        double grade3 = 91;

        double average = (grade1 + grade2 + grade3) / 3;

        System.out.println("Student: " + studentName);
        System.out.println("Major: " + major);
        System.out.println("Course: " + courseName);
        System.out.println("Average: " + average);

        if (average >= 70) {
            System.out.println("Status: Passed");
        } else {
            System.out.println("Status: Failed");
        }
    }
}
