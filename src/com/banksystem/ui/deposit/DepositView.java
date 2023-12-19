package com.banksystem.ui.deposit;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.banksystem.components.HintTextField;
import com.banksystem.components.RoundedButton;
import com.banksystem.config.Config;
import com.banksystem.res.Resources;
import com.banksystem.utils.Util;

public class DepositView extends JFrame {
    private JLabel lblHeading;
    private JLabel lblSub;
    private HintTextField txtDepositAmount;
    private RoundedButton btnSubmit;
    private RoundedButton btnBack;
    private JPanel pnlMain;

    public DepositView() {
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

        // Add the back button to the menu view
        btnBack = new RoundedButton("BACK TO MENU");
        btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnBack.setFont(Resources.createPoppinsFont(Resources.FontWeight.MEDIUM,
                10));
        btnBack.setFocusPainted(false);
        btnBack.setForeground(Resources.LIGHT_GRAY);
        btnBack.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 127)));
        Dimension btnBackDimension = new Dimension(100, 30);
        btnBack.setMaximumSize(btnBackDimension);
        pnlMain.add(btnBack);

        pnlMain.add(Box.createRigidArea(new Dimension(0, 32)));

        // Add the heading
        lblHeading = new JLabel("Deposit");
        lblHeading.setFont(Resources.createPoppinsFont(Resources.FontWeight.MEDIUM, 25));
        lblHeading.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlMain.add(lblHeading);

        // Add the sub heading
        lblSub = new JLabel("Enter the amount you want to deposit");
        lblSub.setFont(Resources.createPoppinsFont(Resources.FontWeight.MEDIUM, 12));
        lblSub.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlMain.add(lblSub);

        pnlMain.add(Box.createRigidArea(new Dimension(0, 32)));

        // Add the text field for name
        txtDepositAmount = new HintTextField("Enter Amount", 16);
        txtDepositAmount.setAlignmentX(Component.CENTER_ALIGNMENT);
        txtDepositAmount.setFont(Resources.createPoppinsFont(Resources.FontWeight.MEDIUM, 16));
        txtDepositAmount.setMargin(new Insets(12, 12, 12, 12));
        txtDepositAmount.setMaximumSize(txtDepositAmount.getPreferredSize());
        pnlMain.add(txtDepositAmount);

        pnlMain.add(Box.createRigidArea(new Dimension(0, 16)));

        // Add the submit button
        btnSubmit = new RoundedButton("DEPOSIT");
        btnSubmit.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnSubmit.setFont(Resources.createPoppinsFont(Resources.FontWeight.BOLD, 12));
        btnSubmit.setFocusPainted(false);
        btnSubmit.setForeground(Resources.LIGHT);
        btnSubmit.setBackground(Resources.PRIMARY);
        btnSubmit.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 127)));

        Dimension btnSize = new Dimension(txtDepositAmount.getPreferredSize().width, 40);
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
