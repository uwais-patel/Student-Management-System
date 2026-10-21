import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        if (findStudent(student.getId()) != null) {
            System.out.println("Student ID already exists.");
            return;
        }

        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("\n===== Student Records =====");

        for (Student student : students) {
            System.out.println(student);
        }
    }

    public Student findStudent(int id) {

        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    public void updateStudent(
            int id,
            String name,
            int age,
            String course,
            double marks) {

        Student student = findStudent(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        student.setName(name);
        student.setAge(age);
        student.setCourse(course);
        student.setMarks(marks);

        System.out.println("Student updated successfully.");
    }

    public void deleteStudent(int id) {

        Student student = findStudent(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        students.remove(student);

        System.out.println("Student deleted successfully.");
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}