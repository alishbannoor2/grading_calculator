package scd_project;

import javax.swing.*;
import java.awt.*;

public class DeleteStudentForm extends JFrame {
    public DeleteStudentForm(StudentManager manager) {
        setTitle("Delete Student");
        setSize(300, 180);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255, 240, 245)); // pastel pink

        JLabel lblId = new JLabel("Enter Student ID:");
        lblId.setBounds(30, 30, 120, 25);
        add(lblId);

        JTextField txtId = new JTextField();
        txtId.setBounds(150, 30, 100, 25);
        add(txtId);

        JButton delete = new JButton("Delete");
        delete.setBounds(40, 80, 90, 30);
        delete.setBackground(new Color(255, 204, 204));
        add(delete);

        JButton cancel = new JButton("Cancel");
        cancel.setBounds(150, 80, 90, 30);
        cancel.setBackground(new Color(204, 229, 255));
        add(cancel);

        delete.addActionListener(e -> {
            String id = txtId.getText().trim();
            if (manager.deleteStudentById(id)) {
                JOptionPane.showMessageDialog(this, "Student deleted.");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Student ID not found.");
            }
        });

        cancel.addActionListener(e -> dispose());

        setVisible(true);
    }
}