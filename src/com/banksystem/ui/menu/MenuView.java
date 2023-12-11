package com.banksystem.ui.menu;

import javax.swing.*;

import com.banksystem.config.Config;
import com.banksystem.res.Resources;

import javax.swing.border.EmptyBorder;

import java.awt.*;

public class MenuView extends JFrame {

        private JPanel pnlMain;
        private JLabel lblHeading;
        private JLabel lblSub;
        private JPanel pnlMenu;
        private JButton btnWithdraw;
        private JButton btnDeposit;
        private JButton btnSeeProfile;
        private JButton btnLogout;
        private JButton btnTransfer;
        private JButton btnTransactions;

        public MenuView() {
                setTitle(Config.TITLE);
                setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                this.setMinimumSize(new Dimension(Config.WINDOW_WIDTH / 2, 400));

                pnlMain = new JPanel();
                pnlMain.setLayout(new BoxLayout(pnlMain, BoxLayout.Y_AXIS));
                // pnlMain.setLayout(new GridLayout(2, 2));
                pnlMain.setBackground(Color.WHITE);
                pnlMain.setBorder(new EmptyBorder(48, 48, 48, 48));
                this.getContentPane().add(pnlMain);

                lblHeading = new JLabel("Menu");
                lblHeading.setFont(Resources.createPoppinsFont(Resources.FontWeight.BOLD, 25));
                lblHeading.setAlignmentX(Component.CENTER_ALIGNMENT);
                pnlMain.add(lblHeading);

                pnlMain.add(Box.createRigidArea(new Dimension(10, 4)));

                lblSub = new JLabel(
                                "<html><div style='text-align: center;'>What do you want to do?</div></html>");
                lblSub.setFont(Resources.createPoppinsFont(Resources.FontWeight.PLAIN, 14));
                lblSub.setAlignmentX(Component.CENTER_ALIGNMENT);
                lblSub.setHorizontalAlignment(JLabel.CENTER);
                pnlMain.add(lblSub);

                pnlMenu = new JPanel();
                pnlMenu.setLayout(new GridLayout(3, 3));
                pnlMenu.setBackground(Color.WHITE);
                pnlMenu.setBorder(new EmptyBorder(48, 48, 48, 48));

                pnlMain.add(Box.createRigidArea(new Dimension(0, 32)));

                btnWithdraw = new JButton("WITHDRAW");
                btnWithdraw.setAlignmentX(Component.CENTER_ALIGNMENT);
                btnWithdraw.setFocusPainted(false);
                btnWithdraw.setFont(Resources.createPoppinsFont(Resources.FontWeight.BOLD,
                                24));
                btnWithdraw.setForeground(Resources.PRIMARY);
                btnWithdraw.setBackground(Resources.LIGHT);
                btnWithdraw.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0,
                                127)));

                btnDeposit = new JButton("DEPOSIT");
                btnDeposit.setAlignmentX(Component.CENTER_ALIGNMENT);
                btnDeposit.setFocusPainted(false);
                btnDeposit.setFont(Resources.createPoppinsFont(Resources.FontWeight.BOLD,
                                24));
                btnDeposit.setForeground(Resources.PRIMARY);
                btnDeposit.setBackground(Resources.LIGHT);
                btnDeposit.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0,
                                127)));

                // btnTransfer = new JButton("TRANSFER");
                // btnTransfer.setAlignmentX(Component.CENTER_ALIGNMENT);
                // btnTransfer.setFocusPainted(false);
                // btnTransfer.setFont(Resources.createPoppinsFont(Resources.FontWeight.BOLD,
                // 24));
                // btnTransfer.setForeground(Resources.PRIMARY);
                // btnTransfer.setBackground(Resources.LIGHT);
                // btnTransfer.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0,
                // 127)));

                // btnTransactions = new JButton("TRANSACTIONS");
                // btnTransactions.setAlignmentX(Component.CENTER_ALIGNMENT);
                // btnTransactions.setFocusPainted(false);
                // btnTransactions.setFont(Resources.createPoppinsFont(Resources.FontWeight.BOLD,
                // 24));
                // btnTransactions.setForeground(Resources.PRIMARY);
                // btnTransactions.setBackground(Resources.LIGHT);
                // btnTransactions.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0,
                // 127)));

                btnSeeProfile = new JButton("SEE PROFILE");
                btnSeeProfile.setAlignmentX(Component.CENTER_ALIGNMENT);
                btnSeeProfile.setFocusPainted(false);
                btnSeeProfile.setFont(Resources.createPoppinsFont(Resources.FontWeight.BOLD,
                                24));
                btnSeeProfile.setForeground(Resources.PRIMARY);
                btnSeeProfile.setBackground(Resources.LIGHT);
                btnSeeProfile.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0,
                                127)));

                btnLogout = new JButton("LOGOUT");
                btnLogout.setAlignmentX(Component.CENTER_ALIGNMENT);
                btnLogout.setFocusPainted(false);
                btnLogout.setFont(Resources.createPoppinsFont(Resources.FontWeight.BOLD,
                                24));
                btnLogout.setForeground(Resources.PRIMARY);
                btnLogout.setBackground(Resources.LIGHT);
                btnLogout.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0,
                                127)));

                pnlMenu.add(btnWithdraw);
                pnlMenu.add(btnDeposit);
                // pnlMenu.add(btnTransfer);
                // pnlMenu.add(btnTransactions);
                pnlMenu.add(btnSeeProfile);
                pnlMenu.add(btnLogout);
                pnlMain.add(pnlMenu);
        }

        public JButton getBtnWithdraw() {
                return btnWithdraw;
        }

        public JButton getBtnDeposit() {
                return btnDeposit;
        }

        public JButton getBtnTransfer() {
                return btnTransfer;
        }

        public JButton getbtnTransactions() {
                return btnTransactions;
        }

        public JButton getBtnSeeProfile() {
                return btnSeeProfile;
        }

        public JButton getBtnLogout() {
                return btnLogout;
        }

}
