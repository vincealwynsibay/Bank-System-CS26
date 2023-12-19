package com.banksystem.ui.menu;

import com.banksystem.navigation.Navigation;
import com.banksystem.repository.Repository;

public class MenuPresenter {
    private MenuView view;

    public MenuPresenter(MenuView view) {
        this.view = view;

        // Attach click listener to the view components
        this.view.getBtnWithdraw().addActionListener(e -> redirectToWithdraw());
        this.view.getBtnDeposit().addActionListener(e -> redirectToDeposit());
        this.view.getBtnSeeProfile().addActionListener(e -> redirectToSeeProfile());
        this.view.getBtnLogout().addActionListener(e -> logout());
        this.view.getBtnTransfer().addActionListener(e -> redirectToTransfer());
        this.view.getBtnTransactions().addActionListener(e -> redirectToTransactions());

        showView();
    }

    // Show the view
    private void showView() {
        view.pack();
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }

    private void redirectToWithdraw() {
        view.dispose();
        Navigation.withdraw();
    }

    private void redirectToDeposit() {
        view.dispose();
        Navigation.deposit();
    }

    private void redirectToSeeProfile() {
        view.dispose();
        Navigation.profile();
    }

    private void redirectToTransfer() {
        view.dispose();
        Navigation.transfer();
    }

    private void redirectToTransactions() {
        view.dispose();
        Navigation.transactions();
    }

    private void logout() {
        view.dispose();
        Repository currentUser = new Repository();
        currentUser.logoutUser();
        Navigation.login();
    }
}
