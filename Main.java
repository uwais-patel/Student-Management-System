import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StudentManager manager = new StudentManager();

        // Load existing records
        ArrayList<Student> loadedStudents =
                FileHandler.loadStudents();

        for (Student student : loadedStudents) {
            manager.getStudents().add(student);
        }

        int choice;

        do {

            System.out.println("\n==============================");
            System.out.println(" Student Management System");
            System.out.println("==============================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Save Records");
            System.out.println("7. Exit");
            System.out.println("==============================");

            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine();

            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();
                choice = 0;
            }

            switch (choice) {

                case 1:

                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Course: ");
                    String course = scanner.nextLine();

                    System.out.print("Enter Marks: ");
                    double marks = scanner.nextDouble();
                    scanner.nextLine();

                    Student student =
                            new Student(id, name, age, course, marks);

                    manager.addStudent(student);

                    break;

                case 2:

                    manager.viewStudents();

                    break;

                case 3:

                    System.out.print("Enter Student ID: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine();

                    Student found =
                            manager.findStudent(searchId);

                    if (found != null) {
                        System.out.println("\nStudent Found:");
                        System.out.println(found);
                    } else {
                        System.out.println("Student not found.");
                    }

                    break;

                case 4:

                    System.out.print("Enter Student ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    if (manager.findStudent(updateId) == null) {
                        System.out.println("Student not found.");
                        break;
                    }

                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter New Age: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter New Course: ");
                    String newCourse = scanner.nextLine();

                    System.out.print("Enter New Marks: ");
                    double newMarks = scanner.nextDouble();
                    scanner.nextLine();

                    manager.updateStudent(
                            updateId,
                            newName,
                            newAge,
                            newCourse,
                            newMarks
                    );

                    break;

                case 5:

                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();

                    manager.deleteStudent(deleteId);

                    break;

                case 6:

                    FileHandler.saveStudents(
                            manager.getStudents()
                    );

                    break;

                case 7:

                    // Automatically save before exit
                    FileHandler.saveStudents(
                            manager.getStudents()
                    );

                    System.out.println("Thank you for using the system.");
                    break;

                default:

                    System.out.println("Invalid choice.");

            }

        } while (choice != 7);

        scanner.close();
    }
}