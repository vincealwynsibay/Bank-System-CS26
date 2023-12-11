package com.banksystem.ui.register;

import com.banksystem.components.HintTextField;
import com.banksystem.components.RoundedButton;
import com.banksystem.config.Config;
import com.banksystem.res.Resources;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RegisterView extends JFrame {
    private JPanel pnlMain;
    private JLabel lblHeading;
    private JLabel lblSub;
    private HintTextField txtUserId;
    private HintTextField txtAge;
    private HintTextField txtPassword;
    private RoundedButton btnSubmit;
    private RoundedButton btnLogin;

    /**
     * Constructor where all of the components of the frame are created
     * 
     * @throws HeadlessException
     */
    public RegisterView() throws HeadlessException {
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
        lblHeading = new JLabel("Register Now");
        lblHeading.setFont(Resources.createPoppinsFont(Resources.FontWeight.BOLD, 25));
        lblHeading.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlMain.add(lblHeading);

        pnlMain.add(Box.createRigidArea(new Dimension(0, 4)));

        // Add the sub heading
        lblSub = new JLabel(
                "<html><div style='text-align: center;'>Experience financial freedom with our state-of-the-art bank system!</div></html>");
        lblSub.setFont(Resources.createPoppinsFont(Resources.FontWeight.PLAIN, 14));
        lblSub.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblSub.setHorizontalAlignment(JLabel.CENTER);
        pnlMain.add(lblSub);

        pnlMain.add(Box.createRigidArea(new Dimension(0, 32)));

        // Add the text field for email
        txtUserId = new HintTextField("Enter userId", 16);
        txtUserId.setAlignmentX(Component.CENTER_ALIGNMENT);
        txtUserId.setFont(Resources.createPoppinsFont(Resources.FontWeight.PLAIN, 12));
        txtUserId.setMargin(new Insets(6, 6, 6, 6));
        txtUserId.setMaximumSize(txtUserId.getPreferredSize());
        pnlMain.add(txtUserId);

        txtAge = new HintTextField("Enter age", 16);
        txtAge.setAlignmentX(Component.CENTER_ALIGNMENT);
        txtAge.setFont(Resources.createPoppinsFont(Resources.FontWeight.PLAIN, 12));
        txtAge.setMargin(new Insets(6, 6, 6, 6));
        txtAge.setMaximumSize(txtUserId.getPreferredSize());
        pnlMain.add(txtAge);

        pnlMain.add(Box.createRigidArea(new Dimension(0, 6)));

        // Add the text field for password
        txtPassword = new HintTextField("Enter password", 16);
        txtPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
        txtPassword.setFont(Resources.createPoppinsFont(Resources.FontWeight.PLAIN, 12));
        txtPassword.setMargin(new Insets(6, 6, 6, 6));
        txtPassword.setMaximumSize(txtUserId.getPreferredSize());
        pnlMain.add(txtPassword);

        pnlMain.add(Box.createRigidArea(new Dimension(0, 6)));

        // Add the submit button
        btnSubmit = new RoundedButton("REGISTER");
        btnSubmit.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnSubmit.setFocusPainted(false);
        btnSubmit.setFont(Resources.createPoppinsFont(Resources.FontWeight.MEDIUM, 12));
        btnSubmit.setForeground(Resources.LIGHT);
        btnSubmit.setBackground(Resources.PRIMARY);
        btnSubmit.setMaximumSize(txtUserId.getPreferredSize());
        pnlMain.add(btnSubmit);

        btnLogin = new RoundedButton("No Account Yet? Register Now");
        btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnLogin.setFocusPainted(false);
        btnLogin.setFont(Resources.createPoppinsFont(Resources.FontWeight.MEDIUM, 12));
        btnLogin.setForeground(Resources.PRIMARY);
        btnLogin.setBackground(Resources.LIGHT);
        btnLogin.setMaximumSize(txtUserId.getPreferredSize());
        pnlMain.add(btnLogin);
    }

    public JTextField getUserId() {
        return txtUserId;
    }

    public JTextField getAge() {
        return txtAge;
    }

    public JTextField getTxtPassword() {
        return txtPassword;
    }

    public RoundedButton getBtnSubmit() {
        return btnSubmit;
    }

    public RoundedButton getBtnLogin() {
        return btnLogin;
    }
}
