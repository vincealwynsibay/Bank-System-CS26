package com.banksystem.ui.profile;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.banksystem.components.RoundedButton;
import com.banksystem.config.Config;
import com.banksystem.data.Transaction;
import com.banksystem.data.TransactionType;
import com.banksystem.res.Resources;

public class ProfileView extends JFrame {
    // TODO: FINALIZE DESIGN
    private JPanel pnlMain;
    private JPanel pnlTransactions;
    private JLabel lblHeading;
    private JLabel lblSub;
    private JLabel lblName;
    private JLabel lblAccountId;
    private JLabel lblAge;
    private JLabel lblBalance;
    private JLabel lblAccountType;
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

        pnlMain.add(Box.createRigidArea(new Dimension(0, 32)));

        lblAccountType = new JLabel("Account Type: ");
        lblAccountType.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblAccountType.setHorizontalAlignment(JLabel.LEFT);
        lblAccountType.setFont(Resources.createPoppinsFont(Resources.FontWeight.MEDIUM, 16));
        lblAccountType.setPreferredSize(lblName.getPreferredSize());
        pnlMain.add(lblAccountType);

        pnlMain.add(Box.createRigidArea(new Dimension(0, 32)));
        pnlTransactions = new JPanel();
        pnlTransactions.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlTransactions.setLayout(new BoxLayout(pnlTransactions, BoxLayout.Y_AXIS));
        pnlTransactions.setBackground(Color.WHITE);
        pnlTransactions.setBorder(new EmptyBorder(0, 0, 0, 0));
        pnlMain.add(pnlTransactions);

        pnlMain.add(Box.createRigidArea(new Dimension(0, 32)));

        lblCreatedAt = new JLabel("Created At: ");
        lblCreatedAt.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblCreatedAt.setHorizontalAlignment(JLabel.LEFT);
        lblCreatedAt.setFont(Resources.createPoppinsFont(Resources.FontWeight.MEDIUM, 16));
        lblCreatedAt.setPreferredSize(lblName.getPreferredSize());
        pnlMain.add(lblCreatedAt);

    }

    public void setTransactions(ArrayList<Transaction> transactions) {

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
        view.setAccountId("123456789");
        view.setName("John Doe");
        view.setAge(20);
        view.setBalance(1000);
        view.setAccountType("Savings");
        view.setCreatedAt("2021-01-01");

        // create 3 transactions
        Transaction t1 = new Transaction(TransactionType.DEPOSIT, 1000);
        Transaction t2 = new Transaction(TransactionType.WITHDRAW, 500);
        Transaction t3 = new Transaction(TransactionType.DEPOSIT, 1000);

        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(t1);
        transactions.add(t2);
        transactions.add(t3);

        view.setTransactions(transactions);

        view.setVisible(true);
    }
}
