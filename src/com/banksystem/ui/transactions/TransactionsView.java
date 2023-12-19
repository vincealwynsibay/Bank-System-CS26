package com.banksystem.ui.transactions;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.banksystem.components.HintTextField;
import com.banksystem.components.RoundedButton;
import com.banksystem.config.Config;
import com.banksystem.data.Transaction;
import com.banksystem.res.Resources;
import com.banksystem.utils.Util;

import java.util.ArrayList;

public class TransactionsView extends JFrame {
    private JLabel lblHeading;
    private JLabel lblSub;
    private RoundedButton btnBack;
    private JPanel pnlMain;
    private JList<String> itemList;
    private JScrollPane scrollPane;

    public TransactionsView() {
        // Set the frame preferences
        this.setTitle(Config.TITLE);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setMinimumSize(new Dimension(Config.WINDOW_WIDTH / 2, (Config.WINDOW_HEIGHT / 2) + 100));
        this.setIconImage(Util.createImageIcon(this, "../../" + Resources.LOGO_PATH).getImage());

        pnlMain = new JPanel();
        pnlMain.setLayout(new BoxLayout(pnlMain, BoxLayout.Y_AXIS));
        pnlMain.setBackground(Color.WHITE);
        pnlMain.setBorder(new EmptyBorder(48, 48, 48, 48));

        this.getContentPane().add(pnlMain);

        // Add the back button to redirect to the menu view
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

        // Add the heading
        lblHeading = new JLabel("Transactions");
        lblHeading.setFont(Resources.createPoppinsFont(Resources.FontWeight.MEDIUM, 25));
        lblHeading.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlMain.add(lblHeading);

        // Add the sub heading
        lblSub = new JLabel("Here are your transactions");
        lblSub.setFont(Resources.createPoppinsFont(Resources.FontWeight.MEDIUM, 12));
        lblSub.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlMain.add(lblSub);

        pnlMain.add(Box.createRigidArea(new Dimension(0, 32)));

        // Add the list of transactions
        scrollPane = new JScrollPane(itemList);

        pnlMain.add(scrollPane);
        pnlMain.add(Box.createRigidArea(new Dimension(0, 32)));

        this.pack();
        this.setLocationRelativeTo(null);
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Transaction transaction : transactions) {
            String transactionDetail = transaction.getTransactionType() + " : " + "$" + transaction.getAmount();
            listModel.addElement(transactionDetail);
        }
        JList<String> transactionsList = new JList<>(listModel);
        transactionsList.setFont(Resources.createPoppinsFont(Resources.FontWeight.MEDIUM, 14));
        scrollPane.setViewportView(transactionsList);
    }

    public RoundedButton getBtnBack() {
        return btnBack;
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

}
