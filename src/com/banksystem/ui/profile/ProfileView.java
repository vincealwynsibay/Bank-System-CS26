package com.banksystem.ui.profile;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.banksystem.components.RoundedButton;
import com.banksystem.config.Config;
import com.banksystem.data.Account;
import com.banksystem.data.Transaction;
import com.banksystem.data.TransactionType;
import com.banksystem.res.Resources;

public class ProfileView extends JFrame {

    private JPanel pnlMain;
    private JPanel pnlTransactions;
    private JLabel lblHeading;
    private JLabel lblSub;
    private JLabel lblName;
    private JLabel lblAccountId;
    private JLabel lblAge;
    private JLabel lblBalance;
    private JLabel lblCreatedAt;
    private RoundedButton btnBack;

    public ProfileView() {
        this.setTitle(Config.TITLE);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setMinimumSize(new Dimension(Config.WINDOW_WIDTH / 2, 400));

        pnlMain = new JPanel();
        pnlMain.setLayout(new BoxLayout(pnlMain, BoxLayout.Y_AXIS));
        pnlMain.setBackground(Color.WHITE);
        pnlMain.setBorder(new EmptyBorder(48, 48, 48, 48));
        this.getContentPane().add(pnlMain);

        btnBack = new RoundedButton("BACK TO MENU");
        btnBack.setAlignmentX(Component.RIGHT_ALIGNMENT);
        btnBack.setFont(new Font("Poppins", Font.BOLD, 10));
        btnBack.setFocusPainted(false);
        btnBack.setForeground(Resources.LIGHT_GRAY);
        btnBack.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 127)));
        Dimension btnBackDimension = new Dimension(100, 30);
        btnBack.setMaximumSize(btnBackDimension);
        pnlMain.add(btnBack);

        pnlMain.add(Box.createRigidArea(new Dimension(0, 32)));

        lblHeading = new JLabel("Your Profile");
        lblHeading.setFont(Resources.createPoppinsFont(Resources.FontWeight.BOLD, 25));
        lblHeading.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlMain.add(lblHeading);

        pnlMain.add(Box.createRigidArea(new Dimension(0, 4)));

        lblSub = new JLabel("See your personal information.");
        lblSub.setFont(Resources.createPoppinsFont(Resources.FontWeight.PLAIN, 14));
        lblSub.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblSub.setHorizontalAlignment(JLabel.CENTER);
        pnlMain.add(lblSub);

        pnlMain.add(Box.createRigidArea(new Dimension(0, 32)));

        lblAccountId = new JLabel("Account ID: ");
        lblAccountId.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblAccountId.setHorizontalAlignment(JLabel.LEFT);
        lblAccountId.setFont(Resources.createPoppinsFont(Resources.FontWeight.MEDIUM, 16));
        pnlMain.add(lblAccountId);

        pnlMain.add(Box.createRigidArea(new Dimension(0, 32)));
        lblName = new JLabel("Name: ");
        lblName.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblName.setHorizontalAlignment(JLabel.LEFT);
        lblName.setFont(Resources.createPoppinsFont(Resources.FontWeight.MEDIUM, 16));
        pnlMain.add(lblName);

        pnlMain.add(Box.createRigidArea(new Dimension(0, 32)));

        lblAge = new JLabel("Age: ");
        lblAge.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblAge.setHorizontalAlignment(JLabel.LEFT);
        lblAge.setFont(Resources.createPoppinsFont(Resources.FontWeight.MEDIUM, 16));
        lblAge.setPreferredSize(lblName.getPreferredSize());
        pnlMain.add(lblAge);

        pnlMain.add(Box.createRigidArea(new Dimension(0, 32)));

        lblBalance = new JLabel("Balance: ");
        lblBalance.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblBalance.setHorizontalAlignment(JLabel.LEFT);
        lblBalance.setFont(Resources.createPoppinsFont(Resources.FontWeight.MEDIUM, 16));
        lblBalance.setPreferredSize(lblName.getPreferredSize());
        pnlMain.add(lblBalance);

        // display list of transactions
        pnlMain.add(Box.createRigidArea(new Dimension(0, 32)));
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        // add to transactions panel
        pnlTransactions = new JPanel();
        pnlTransactions.setLayout(new BoxLayout(pnlTransactions, BoxLayout.Y_AXIS));
        pnlTransactions.setBackground(Color.WHITE);
        pnlTransactions.setBorder(new EmptyBorder(0, 0, 0, 0));
        pnlMain.add(pnlTransactions);

        JLabel lblTransactions = new JLabel("Transactions");
        lblTransactions.setFont(Resources.createPoppinsFont(Resources.FontWeight.BOLD, 16));

        pnlTransactions.add(lblTransactions);
        pnlTransactions.add(Box.createRigidArea(new Dimension(0, 16)));

        for (Transaction transaction : transactions) {
            JLabel lblTransaction = new JLabel(
                    transaction.getTransactionType() + " : " + "$" + transaction.getAmount());
            lblTransaction.setFont(Resources.createPoppinsFont(Resources.FontWeight.MEDIUM, 14));
            pnlTransactions.add(lblTransaction);
            pnlTransactions.add(Box.createRigidArea(new Dimension(0, 8)));
        }

        pnlTransactions.add(Box.createRigidArea(new Dimension(0, 32)));

    }

    public void setAccountId(String accountId) {
        lblAccountId.setText("Account ID: " + accountId);
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

    public RoundedButton getBack() {
        return btnBack;
    }
}
