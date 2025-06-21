package scd_project;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ListStudentsForm extends JFrame {
    public ListStudentsForm(StudentManager manager) {
        setTitle("All Students");
        setSize(600, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(235, 255, 245)); // pastel green

        JLabel header = new JLabel("All Student Records", JLabel.CENTER);
        header.setFont(new Font("SansSerif", Font.BOLD, 16));
        add(header, BorderLayout.NORTH);

        List<Student> students = manager.getAllStudents();
        String[] columns = { "ID", "Name", "Subject 1", "Subject 2", "Subject 3", "Average", "Grade" };
        Object[][] data = new Object[students.size()][7];

        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            data[i][0] = s.getId();
            data[i][1] = s.getName();
            data[i][2] = s.getSubject1();
            data[i][3] = s.getSubject2();
            data[i][4] = s.getSubject3();
            data[i][5] = String.format("%.2f", s.getAverage());
            data[i][6] = s.getGrade();
        }

        JTable table = new JTable(data, columns);
        JScrollPane scroll = new JScrollPane(table);
        add(scroll, BorderLayout.CENTER);

        setVisible(true);
    }
}