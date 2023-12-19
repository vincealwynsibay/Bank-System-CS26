package com.banksystem.ui.profile;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.banksystem.components.RoundedButton;
import com.banksystem.config.Config;
import com.banksystem.res.Resources;
import com.banksystem.utils.Util;

public class ProfileView extends JFrame {
    private JPanel pnlMain;
    private JPanel pnlContent;
    private JLabel lblHeading;
    private JLabel lblSub;
    private JLabel lblName;
    private JLabel lblAge;
    private JLabel lblBalance;
    private JLabel lblAccountType;
    private JLabel lblCreatedAt;
    private RoundedButton btnBack;

    public ProfileView() {
        // Set the frame preferences
        this.setTitle(Config.TITLE);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setMinimumSize(new Dimension(Config.WINDOW_WIDTH / 2, ((Config.WINDOW_HEIGHT / 2) + 100) + 100));
        this.setIconImage(Util.createImageIcon(this, "../../" + Resources.LOGO_PATH).getImage());

        pnlMain = new JPanel();
        pnlMain.setLayout(new BoxLayout(pnlMain, BoxLayout.Y_AXIS));
        pnlMain.setBackground(Color.WHITE);
        pnlMain.setBorder(new EmptyBorder(48, 48, 48, 48));
        this.getContentPane().add(pnlMain);

        // Add the back button to the menu view
        btnBack = new RoundedButton("BACK TO MENU");
        btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnBack.setFont(Resources.createPoppinsFont(Resources.FontWeight.BOLD, 10));
        btnBack.setFocusPainted(false);
        btnBack.setForeground(Resources.LIGHT_GRAY);
        btnBack.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 127)));
        Dimension btnBackDimension = new Dimension(100, 40);
        btnBack.setMaximumSize(btnBackDimension);
        pnlMain.add(btnBack);

        pnlMain.add(Box.createRigidArea(new Dimension(0, 32)));

        // Add the heading
        lblHeading = new JLabel("Your Profile");
        lblHeading.setFont(Resources.createPoppinsFont(Resources.FontWeight.BOLD, 25));
        lblHeading.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlMain.add(lblHeading);

        pnlMain.add(Box.createRigidArea(new Dimension(0, 4)));

        // Add the sub heading
        lblSub = new JLabel("See your personal information.");
        lblSub.setFont(Resources.createPoppinsFont(Resources.FontWeight.PLAIN, 14));
        lblSub.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblSub.setHorizontalAlignment(JLabel.CENTER);
        pnlMain.add(lblSub);

        // Panel for the content
        pnlContent = new JPanel();
        pnlContent.setLayout(new BoxLayout(pnlContent, BoxLayout.Y_AXIS));
        pnlContent.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlContent.setBackground(Color.WHITE);
        pnlContent.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 0)));
        pnlContent.setMinimumSize(new Dimension(400, 0));

        pnlMain.add(Box.createRigidArea(new Dimension(0, 32)));

        // Add the label for the name
        lblName = new JLabel("Name: ");
        lblName.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblName.setHorizontalAlignment(JLabel.LEFT);
        lblName.setFont(Resources.createPoppinsFont(Resources.FontWeight.MEDIUM, 16));
        pnlContent.add(lblName);

        pnlContent.add(Box.createRigidArea(new Dimension(0, 32)));

        // Add the label for the age
        lblAge = new JLabel("Age: ");
        lblAge.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblAge.setHorizontalAlignment(JLabel.LEFT);
        lblAge.setFont(Resources.createPoppinsFont(Resources.FontWeight.MEDIUM, 16));
        lblAge.setPreferredSize(lblName.getPreferredSize());
        pnlContent.add(lblAge);

        pnlContent.add(Box.createRigidArea(new Dimension(0, 32)));

        // Add the label for the balance
        lblBalance = new JLabel("Balance: ");
        lblBalance.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblBalance.setHorizontalAlignment(JLabel.LEFT);
        lblBalance.setFont(Resources.createPoppinsFont(Resources.FontWeight.MEDIUM, 16));
        lblBalance.setPreferredSize(lblName.getPreferredSize());
        pnlContent.add(lblBalance);

        pnlContent.add(Box.createRigidArea(new Dimension(0, 32)));

        // Add the label for the account type
        lblAccountType = new JLabel("Account Type: ");
        lblAccountType.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblAccountType.setHorizontalAlignment(JLabel.LEFT);
        lblAccountType.setFont(Resources.createPoppinsFont(Resources.FontWeight.MEDIUM, 16));
        lblAccountType.setPreferredSize(lblName.getPreferredSize());
        pnlContent.add(lblAccountType);

        pnlContent.add(Box.createRigidArea(new Dimension(0, 32)));

        // Add the label for the created at
        lblCreatedAt = new JLabel("Created At: ");
        lblCreatedAt.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblCreatedAt.setHorizontalAlignment(JLabel.LEFT);
        lblCreatedAt.setFont(Resources.createPoppinsFont(Resources.FontWeight.MEDIUM, 16));
        lblCreatedAt.setPreferredSize(lblName.getPreferredSize());
        pnlContent.add(lblCreatedAt);

        pnlMain.add(pnlContent);
    }

    public void setName(String name) {
        lblName.setText("Name: " + name);
    }

    public void setAge(int age) {
        lblAge.setText("Age: " + age);
    }

    public void setBalance(double balance) {
        lblBalance.setText("Balance: " + balance);
    }

    public void setAccountType(String accountType) {
        lblAccountType.setText("Account Type: " + accountType);
    }

    public void setCreatedAt(String createdAt) {
        lblCreatedAt.setText("Created At: " + createdAt);
    }

    public RoundedButton getBack() {
        return btnBack;
    }

    public static void main(String[] args) {
        ProfileView view = new ProfileView();
        view.setName("John Doe");
        view.setAge(20);
        view.setBalance(1000);
        view.setAccountType("Savings");
        view.setCreatedAt("2021-01-01");

        view.setVisible(true);
    }
}
