package scd_project;

import javax.swing.*;
import java.awt.*;

public class UpdateStudentForm extends JFrame {
    public UpdateStudentForm(StudentManager manager) {
        setTitle("Update Marks");
        setSize(350, 300);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(240, 255, 250));

        JLabel lblId = new JLabel("Enter ID:");
        lblId.setBounds(30, 30, 100, 25);
        add(lblId);
        JTextField txtId = new JTextField();
        txtId.setBounds(130, 30, 170, 25);
        add(txtId);

        JLabel[] lblSubs = new JLabel[3];
        JTextField[] txtSubs = new JTextField[3];
        String[] subs = {"Subject 1:", "Subject 2:", "Subject 3:"};
        for (int i = 0; i < 3; i++) {
            lblSubs[i] = new JLabel(subs[i]);
            lblSubs[i].setBounds(30, 70 + i * 30, 100, 25);
            txtSubs[i] = new JTextField();
            txtSubs[i].setBounds(130, 70 + i * 30, 170, 25);
            add(lblSubs[i]);
            add(txtSubs[i]);
        }

        JButton update = new JButton("Update");
        update.setBounds(60, 200, 100, 30);
        update.setBackground(new Color(189, 224, 255));
        add(update);

        JButton cancel = new JButton("Cancel");
        cancel.setBounds(180, 200, 100, 30);
        cancel.setBackground(new Color(255, 204, 204));
        add(cancel);

        update.addActionListener(e -> {
            Student s = manager.findStudentById(txtId.getText().trim());
            if (s == null) {
                JOptionPane.showMessageDialog(this, "Student not found.");
                return;
            }
            try {
                s.setSubject1(Double.parseDouble(txtSubs[0].getText().trim()));
                s.setSubject2(Double.parseDouble(txtSubs[1].getText().trim()));
                s.setSubject3(Double.parseDouble(txtSubs[2].getText().trim()));
                JOptionPane.showMessageDialog(this, "Marks updated.");
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input. Enter numbers only.");
            }
        });

        cancel.addActionListener(e -> dispose());
        setVisible(true);
    }
}