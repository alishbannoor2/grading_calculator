package scd_project;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GradingGUI extends JFrame {
    private StudentManager manager = new StudentManager();

    public GradingGUI() {
        setTitle("Student Grading System");
        setSize(400, 400);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(230, 248, 255)); // pastel blue

        JButton addBtn = new JButton("Add Student");
        JButton updateBtn = new JButton("Update Marks");
        JButton deleteBtn = new JButton("Delete Student");
        JButton listBtn = new JButton("List All Students");
        JButton viewGradesBtn = new JButton("View Grades");
        JButton exitBtn = new JButton("Exit");

        addBtn.setBounds(110, 30, 160, 30);
        updateBtn.setBounds(110, 70, 160, 30);
        deleteBtn.setBounds(110, 110, 160, 30);
        listBtn.setBounds(110, 150, 160, 30);
        viewGradesBtn.setBounds(110, 190, 160, 30);
        exitBtn.setBounds(110, 240, 160, 30);

        exitBtn.setBackground(new Color(255, 204, 204)); // pastel pink

        addBtn.addActionListener(e -> new AddStudentForm(manager));
        updateBtn.addActionListener(e -> new UpdateStudentForm(manager));
        deleteBtn.addActionListener(e -> new DeleteStudentForm(manager));
        listBtn.addActionListener(e -> new ListStudentsForm(manager));
        viewGradesBtn.addActionListener(e -> new ViewGradesForm(manager));
        exitBtn.addActionListener(e -> dispose());

        add(addBtn);
        add(updateBtn);
        add(deleteBtn);
        add(listBtn);
        add(viewGradesBtn);
        add(exitBtn);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GradingGUI();
    }
}