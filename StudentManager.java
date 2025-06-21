package scd_project;

import java.util.*;

public class StudentManager {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
    }

    public Student findStudentById(String id) {
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    public boolean deleteStudentById(String id) {
        return students.removeIf(s -> s.getId().equalsIgnoreCase(id));
    }

    public List<Student> getAllStudents() {
        return students;
    }
}