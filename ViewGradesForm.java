package scd_project;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ViewGradesForm extends JFrame {
    public ViewGradesForm(StudentManager manager) {
        setTitle("Student Grades");
        setSize(450, 250);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(255, 255, 240)); // pastel yellow

        JLabel title = new JLabel("Student Grades", JLabel.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 16));
        add(title, BorderLayout.NORTH);

        List<Student> students = manager.getAllStudents();
        String[] columns = { "ID", "Name", "Grade" };
        Object[][] data = new Object[students.size()][3];

        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            data[i][0] = s.getId();
            data[i][1] = s.getName();
            data[i][2] = s.getGrade();
        }

        JTable table = new JTable(data, columns);
        JScrollPane scroll = new JScrollPane(table);
        add(scroll, BorderLayout.CENTER);

        setVisible(true);
    }
}