package com.banksystem.ui.deposit;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.banksystem.components.HintTextField;
import com.banksystem.components.RoundedButton;
import com.banksystem.config.Config;
import com.banksystem.res.Resources;

public class DepositView extends JFrame {
    private JLabel lblHeading;
    private JLabel lblSub;
    private HintTextField txtDepositAmount;
    private RoundedButton btnSubmit;
    private RoundedButton btnBack;
    private JPanel pnlMain;

    public DepositView() {
        this.setTitle("Deposit");
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setMinimumSize(new Dimension(Config.WINDOW_WIDTH / 2, 400));
        pnlMain = new JPanel();
        pnlMain.setLayout(new BoxLayout(pnlMain, BoxLayout.Y_AXIS));
        pnlMain.setBackground(Color.WHITE);
        pnlMain.setBorder(new EmptyBorder(48, 48, 48, 48));
        this.getContentPane().add(pnlMain);

        // TODO: back button size
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

        lblHeading = new JLabel("Deposit");
        lblHeading.setFont(new Font("Poppins", Font.BOLD, 25));
        lblHeading.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlMain.add(lblHeading);

        lblSub = new JLabel("Enter the amount you want to deposit");
        lblSub.setFont(new Font("Poppins", Font.PLAIN, 12));
        lblSub.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlMain.add(lblSub);

        pnlMain.add(Box.createRigidArea(new Dimension(0, 32)));

        txtDepositAmount = new HintTextField("Enter Amount (₱)", 16);
        txtDepositAmount.setAlignmentX(Component.CENTER_ALIGNMENT);
        txtDepositAmount.setFont(new Font("Poppins", Font.PLAIN, 16));
        txtDepositAmount.setMargin(new Insets(12, 12, 12, 12));
        txtDepositAmount.setMaximumSize(txtDepositAmount.getPreferredSize());
        pnlMain.add(txtDepositAmount);

        pnlMain.add(Box.createRigidArea(new Dimension(0, 16)));

        btnSubmit = new RoundedButton("DEPOSIT");
        btnSubmit.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnSubmit.setFont(new Font("Poppins", Font.BOLD, 12));
        btnSubmit.setFocusPainted(false);
        btnSubmit.setForeground(Resources.LIGHT);
        btnSubmit.setBackground(Resources.PRIMARY);
        btnSubmit.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 127)));

        Dimension btnSize = new Dimension(txtDepositAmount.getPreferredSize().width, 30);
        btnSubmit.setMaximumSize(btnSize);

        pnlMain.add(btnSubmit);
    }

    public HintTextField getWithdrawAmount() {
        return txtDepositAmount;
    }

    public RoundedButton getSubmit() {
        return btnSubmit;
    }

    public RoundedButton getBack() {
        return btnBack;
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public static void main(String[] args) {

        new DepositView().setVisible(true);
    }
}