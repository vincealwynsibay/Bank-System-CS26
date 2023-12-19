package com.banksystem.ui.transfer;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.banksystem.components.HintTextField;
import com.banksystem.components.RoundedButton;
import com.banksystem.config.Config;
import com.banksystem.res.Resources;
import com.banksystem.utils.Util;

public class TransferView extends JFrame {

    private JLabel lblHeading;
    private JLabel lblSub;
    private HintTextField txtTransferAmount;
    private HintTextField txtDestinationAccount;
    private RoundedButton btnSubmit;
    private RoundedButton btnBack;
    private JLabel lblAvailableBalance;
    private JPanel pnlMain;

    public TransferView() {
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

        // Add the back button to redirect to the menu view
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

        // Add the heading
        lblHeading = new JLabel("Transfer");
        lblHeading.setFont(Resources.createPoppinsFont(Resources.FontWeight.MEDIUM, 25));
        lblHeading.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlMain.add(lblHeading);

        // Add the sub heading
        lblSub = new JLabel("Enter the amount you want to transfer");
        lblSub.setFont(Resources.createPoppinsFont(Resources.FontWeight.MEDIUM, 12));
        lblSub.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlMain.add(lblSub);

        pnlMain.add(Box.createRigidArea(new Dimension(0, 32)));

        // Add the text field for amount
        txtTransferAmount = new HintTextField("Enter Amount", 16);
        txtTransferAmount.setAlignmentX(Component.CENTER_ALIGNMENT);
        txtTransferAmount.setFont(Resources.createPoppinsFont(Resources.FontWeight.MEDIUM, 16));
        txtTransferAmount.setMargin(new Insets(8, 8, 8, 8));
        txtTransferAmount.setMaximumSize(txtTransferAmount.getPreferredSize());
        pnlMain.add(txtTransferAmount);

        pnlMain.add(Box.createRigidArea(new Dimension(0, 16)));

        // Add the text field for destination account
        txtDestinationAccount = new HintTextField("Enter Destination Account", 16);
        txtDestinationAccount.setAlignmentX(Component.CENTER_ALIGNMENT);
        txtDestinationAccount.setFont(Resources.createPoppinsFont(Resources.FontWeight.MEDIUM, 16));
        txtDestinationAccount.setMargin(new Insets(8, 8, 8, 8));
        txtDestinationAccount.setMaximumSize(txtTransferAmount.getPreferredSize());
        pnlMain.add(txtDestinationAccount);

        pnlMain.add(Box.createRigidArea(new Dimension(0, 16)));

        // Add the available balance label
        lblAvailableBalance = new JLabel("Available Balance:  0.00");
        lblAvailableBalance.setFont(Resources.createPoppinsFont(Resources.FontWeight.MEDIUM, 12));
        lblAvailableBalance.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblAvailableBalance.setMaximumSize(txtTransferAmount.getPreferredSize());
        pnlMain.add(lblAvailableBalance);

        pnlMain.add(Box.createRigidArea(new Dimension(0, 16)));

        // Add the submit button
        btnSubmit = new RoundedButton("TRANSFER");
        btnSubmit.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnSubmit.setFont(Resources.createPoppinsFont(Resources.FontWeight.BOLD, 12));
        btnSubmit.setFocusPainted(false);
        btnSubmit.setForeground(Resources.LIGHT);
        btnSubmit.setBackground(Resources.PRIMARY);
        btnSubmit.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 127)));

        Dimension btnSize = new Dimension(txtTransferAmount.getPreferredSize().width, 40);
        btnSubmit.setMaximumSize(btnSize);

        pnlMain.add(btnSubmit);
    }

    public HintTextField getTransferAmount() {
        return txtTransferAmount;
    }

    public HintTextField getDestinationAccount() {
        return txtDestinationAccount;
    }

    public void setAvailableBalance(double amount) {
        lblAvailableBalance.setText("Available Balance: $ " + amount);
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
        TransferView view = new TransferView();
        view.setVisible(true);
    }

}
