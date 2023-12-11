package com.banksystem.ui.login;

import com.banksystem.components.HintTextField;
import com.banksystem.components.RoundedButton;
import com.banksystem.components.HintPasswordField;
import com.banksystem.config.Config;
import com.banksystem.res.Resources;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LoginView extends JFrame {
    private JPanel pnlMain;
    private JLabel lblHeading;
    private JLabel lblSub;
    private HintTextField txtAccountId;
    private HintPasswordField txtPassword;
    private RoundedButton btnSubmit;
    private RoundedButton btnRegister;

    public LoginView() throws HeadlessException {
        // Set the frame preferences
        this.setTitle(Config.TITLE);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setMinimumSize(new Dimension(Config.WINDOW_WIDTH / 2, 400));

        // Create the main panel
        pnlMain = new JPanel();
        pnlMain.setLayout(new BoxLayout(pnlMain, BoxLayout.Y_AXIS));
        pnlMain.setBackground(Color.WHITE);
        pnlMain.setBorder(new EmptyBorder(48, 48, 48, 48));
        this.getContentPane().add(pnlMain);

        // Add the heading
        lblHeading = new JLabel("Login Now");
        lblHeading.setFont(Resources.createPoppinsFont(Resources.FontWeight.BOLD, 25));
        lblHeading.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlMain.add(lblHeading);

        pnlMain.add(Box.createRigidArea(new Dimension(10, 4)));

        // Add the sub heading
        lblSub = new JLabel(
                "<html><div style='text-align: center;'>Experience financial freedom with our state-of-the-art bank system!</div></html>");
        lblSub.setFont(Resources.createPoppinsFont(Resources.FontWeight.PLAIN, 14));
        lblSub.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblSub.setHorizontalAlignment(JLabel.CENTER);
        pnlMain.add(lblSub);

        pnlMain.add(Box.createRigidArea(new Dimension(0, 32)));

        // Add the text field for email
        txtAccountId = new HintTextField("Enter UserId", 16);
        txtAccountId.setAlignmentX(Component.CENTER_ALIGNMENT);
        txtAccountId.setFont(Resources.createPoppinsFont(Resources.FontWeight.PLAIN, 12));
        txtAccountId.setMargin(new Insets(6, 6, 6, 6));
        txtAccountId.setMaximumSize(txtAccountId.getPreferredSize());
        pnlMain.add(txtAccountId);

        pnlMain.add(Box.createRigidArea(new Dimension(0, 6)));

        // Add the text field for password
        txtPassword = new HintPasswordField("Enter Password", 16);
        txtPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
        txtPassword.setFont(Resources.createPoppinsFont(Resources.FontWeight.PLAIN, 12));
        txtPassword.setMargin(new Insets(6, 6, 6, 6));
        txtPassword.setMaximumSize(txtAccountId.getPreferredSize());
        pnlMain.add(txtPassword);

        pnlMain.add(Box.createRigidArea(new Dimension(0, 6)));

        // Add the submit button
        btnSubmit = new RoundedButton("LOGIN");
        btnSubmit.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnSubmit.setFocusPainted(false);
        btnSubmit.setFont(Resources.createPoppinsFont(Resources.FontWeight.MEDIUM, 12));
        btnSubmit.setForeground(Resources.LIGHT);
        btnSubmit.setBackground(Resources.PRIMARY);
        btnSubmit.setMaximumSize(txtAccountId.getPreferredSize());
        pnlMain.add(btnSubmit);

        btnRegister = new RoundedButton("No Account Yet? Register Now");
        btnRegister.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnRegister.setFocusPainted(false);
        btnRegister.setFont(Resources.createPoppinsFont(Resources.FontWeight.MEDIUM, 12));
        btnRegister.setForeground(Resources.PRIMARY);
        btnRegister.setBackground(Resources.LIGHT);
        btnRegister.setMaximumSize(txtAccountId.getPreferredSize());
        pnlMain.add(btnRegister);

    }

    public JTextField getAccountId() {
        return txtAccountId;
    }

    public JTextField getTxtPassword() {
        return txtPassword;
    }

    public RoundedButton getBtnSubmit() {
        return btnSubmit;
    }

    public RoundedButton getBtnRegister() {
        return btnRegister;
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

}
