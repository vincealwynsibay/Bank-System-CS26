package com.banksystem.ui.transactions;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.banksystem.components.HintTextField;
import com.banksystem.components.RoundedButton;
import com.banksystem.config.Config;
import com.banksystem.data.Transaction;
import com.banksystem.res.Resources;
import java.util.ArrayList;

public class TransactionsView extends JFrame {
    private JLabel lblHeading;
    private JLabel lblSub;
    private RoundedButton btnBack;
    private JPanel pnlMain;
    private JPanel pnlTransactions;

    public TransactionsView() {
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
        btnBack.setFont(Resources.createPoppinsFont(Resources.FontWeight.MEDIUM, 10));
        btnBack.setFocusPainted(false);
        btnBack.setForeground(Resources.LIGHT_GRAY);
        btnBack.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 127)));
        Dimension btnBackDimension = new Dimension(100, 30);
        btnBack.setMaximumSize(btnBackDimension);
        pnlMain.add(btnBack);

        pnlMain.add(Box.createRigidArea(new Dimension(0, 32)));

        lblHeading = new JLabel("Transactions");
        lblHeading.setFont(Resources.createPoppinsFont(Resources.FontWeight.MEDIUM, 25));
        lblHeading.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlMain.add(lblHeading);

        lblSub = new JLabel("Here are your transactions");
        lblSub.setFont(Resources.createPoppinsFont(Resources.FontWeight.MEDIUM, 12));
        lblSub.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlMain.add(lblSub);

        pnlMain.add(Box.createRigidArea(new Dimension(0, 32)));

        pnlTransactions = new JPanel();
        pnlTransactions.setLayout(new BoxLayout(pnlTransactions, BoxLayout.Y_AXIS));
        pnlTransactions.setBackground(Color.WHITE);
        pnlTransactions.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 127)));
        pnlMain.add(pnlTransactions);

        pnlMain.add(Box.createRigidArea(new Dimension(0, 32)));

        this.pack();
        this.setLocationRelativeTo(null);
    }

    public void setTransactions(ArrayList<Transaction> transactions) {

        for (Transaction transaction : transactions) {
            JLabel lblTransaction = new JLabel(
                    transaction.getTransactionType() + " : " + "$" + transaction.getAmount());
            lblTransaction.setFont(Resources.createPoppinsFont(Resources.FontWeight.MEDIUM,
                    14));
            pnlTransactions.add(lblTransaction);
            pnlTransactions.add(Box.createRigidArea(new Dimension(0, 8)));
        }
    }

    public RoundedButton getBtnBack() {
        return btnBack;
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

}
