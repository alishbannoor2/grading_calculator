package scd_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddStudentForm extends JFrame {
    public AddStudentForm(StudentManager manager) {
        setTitle("Add Student");
        setSize(350, 300);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255, 250, 240));

        JLabel lblId = new JLabel("ID:");
        JLabel lblName = new JLabel("Name:");
        JLabel lblS1 = new JLabel("Subject 1:");
        JLabel lblS2 = new JLabel("Subject 2:");
        JLabel lblS3 = new JLabel("Subject 3:");
        JTextField txtId = new JTextField();
        JTextField txtName = new JTextField();
        JTextField txtS1 = new JTextField();
        JTextField txtS2 = new JTextField();
        JTextField txtS3 = new JTextField();

        lblId.setBounds(30, 20, 100, 25);   txtId.setBounds(130, 20, 160, 25);
        lblName.setBounds(30, 60, 100, 25); txtName.setBounds(130, 60, 160, 25);
        lblS1.setBounds(30, 100, 100, 25);  txtS1.setBounds(130, 100, 160, 25);
        lblS2.setBounds(30, 140, 100, 25);  txtS2.setBounds(130, 140, 160, 25);
        lblS3.setBounds(30, 180, 100, 25);  txtS3.setBounds(130, 180, 160, 25);

        JButton btnSave = new JButton("Save");
        btnSave.setBounds(60, 220, 90, 25);
        btnSave.setBackground(new Color(189, 224, 255));

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(180, 220, 90, 25);
        btnCancel.setBackground(new Color(255, 204, 204));

        add(lblId); add(lblName); add(lblS1); add(lblS2); add(lblS3);
        add(txtId); add(txtName); add(txtS1); add(txtS2); add(txtS3);
        add(btnSave); add(btnCancel);

        btnSave.addActionListener(e -> {
            String id = txtId.getText().trim();
            String name = txtName.getText().trim();
            if (!name.matches("[a-zA-Z\\s]+")) {
                JOptionPane.showMessageDialog(this, "Name should contain letters only.");
                return;
            }

            try {
                double s1 = Double.parseDouble(txtS1.getText());
                double s2 = Double.parseDouble(txtS2.getText());
                double s3 = Double.parseDouble(txtS3.getText());

                if (s1 < 0 || s1 > 100 || s2 < 0 || s2 > 100 || s3 < 0 || s3 > 100) {
                    JOptionPane.showMessageDialog(this, "Marks must be between 0 and 100.");
                    return;
                }

                Student s = new Student(id, name, s1, s2, s3);
                manager.addStudent(s);
                JOptionPane.showMessageDialog(this, "Student added!");
                dispose();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers for marks.");
            }
        });

        btnCancel.addActionListener(e -> dispose());

        setVisible(true);
    }
}