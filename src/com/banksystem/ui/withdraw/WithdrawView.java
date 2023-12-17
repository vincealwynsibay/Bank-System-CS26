package com.banksystem.ui.withdraw;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.banksystem.components.HintTextField;
import com.banksystem.components.RoundedButton;
import com.banksystem.config.Config;
import com.banksystem.res.Resources;
import com.banksystem.utils.Util;

public class WithdrawView extends JFrame {
    private JLabel lblHeading;
    private JLabel lblSub;
    private HintTextField txtWithdrawAmount;
    private RoundedButton btnSubmit;
    private RoundedButton btnBack;
    private JLabel lblAvailableBalance;
    private JPanel pnlMain;

    public WithdrawView() {
        this.setTitle("Withdraw");
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setMinimumSize(new Dimension(Config.WINDOW_WIDTH / 2, (Config.WINDOW_HEIGHT / 2) + 100));
        this.setIconImage(Util.createImageIcon(this, "../../" + Resources.LOGO_PATH).getImage());

        pnlMain = new JPanel();
        pnlMain.setLayout(new BoxLayout(pnlMain, BoxLayout.Y_AXIS));
        pnlMain.setBackground(Color.WHITE);
        pnlMain.setBorder(new EmptyBorder(48, 48, 48, 48));
        this.getContentPane().add(pnlMain);

        btnBack = new RoundedButton("BACK TO MENU");
        btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnBack.setFont(Resources.createPoppinsFont(Resources.FontWeight.MEDIUM, 10));
        btnBack.setFocusPainted(false);
        btnBack.setForeground(Resources.LIGHT_GRAY);
        btnBack.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 127)));
        Dimension btnBackDimension = new Dimension(100, 30);
        btnBack.setMaximumSize(btnBackDimension);
        pnlMain.add(btnBack);

        pnlMain.add(Box.createRigidArea(new Dimension(0, 32)));

        lblHeading = new JLabel("Withdraw");
        lblHeading.setFont(Resources.createPoppinsFont(Resources.FontWeight.MEDIUM, 25));
        lblHeading.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlMain.add(lblHeading);

        lblSub = new JLabel("Enter the amount you want to withdraw");
        lblSub.setFont(Resources.createPoppinsFont(Resources.FontWeight.MEDIUM, 12));
        lblSub.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlMain.add(lblSub);

        pnlMain.add(Box.createRigidArea(new Dimension(0, 32)));

        txtWithdrawAmount = new HintTextField("Enter Amount", 16);
        txtWithdrawAmount.setAlignmentX(Component.CENTER_ALIGNMENT);
        txtWithdrawAmount.setFont(Resources.createPoppinsFont(Resources.FontWeight.MEDIUM, 16));
        txtWithdrawAmount.setMargin(new Insets(12, 12, 12, 12));
        txtWithdrawAmount.setMaximumSize(txtWithdrawAmount.getPreferredSize());
        pnlMain.add(txtWithdrawAmount);

        lblAvailableBalance = new JLabel("Available Balance:  0.00");
        lblAvailableBalance.setFont(Resources.createPoppinsFont(Resources.FontWeight.MEDIUM, 12));
        lblAvailableBalance.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblAvailableBalance.setMaximumSize(txtWithdrawAmount.getPreferredSize());
        pnlMain.add(lblAvailableBalance);

        pnlMain.add(Box.createRigidArea(new Dimension(0, 16)));

        btnSubmit = new RoundedButton("WITHDRAW");
        btnSubmit.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnSubmit.setFont(Resources.createPoppinsFont(Resources.FontWeight.BOLD, 12));
        btnSubmit.setFocusPainted(false);
        btnSubmit.setForeground(Resources.LIGHT);
        btnSubmit.setBackground(Resources.PRIMARY);
        btnSubmit.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 127)));

        Dimension btnSize = new Dimension(txtWithdrawAmount.getPreferredSize().width, 40);
        btnSubmit.setMaximumSize(btnSize);

        pnlMain.add(btnSubmit);
    }

    public HintTextField getWithdrawAmount() {
        return txtWithdrawAmount;
    }

    public void setAvailableBalance(double amount) {
        lblAvailableBalance.setText("Available Balance: ₱ " + amount);
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
        WithdrawView wv = new WithdrawView();
        wv.setAvailableBalance(1000.0);
        wv.setVisible(true);
    }
}
