package com.banksystem.ui.menu;

import com.banksystem.navigation.Navigation;
import com.banksystem.repository.Repository;

public class MenuPresenter {
    private MenuView view;

    public MenuPresenter(MenuView view) {
        this.view = view;

        this.view.getBtnWithdraw().addActionListener(e -> redirectToWithdraw());
        this.view.getBtnDeposit().addActionListener(e -> redirectToDeposit());
        this.view.getBtnSeeProfile().addActionListener(e -> redirectToSeeProfile());
        this.view.getBtnLogout().addActionListener(e -> logout());
        // this.view.getBtnTransfer().addActionListener(e -> redirectToTransfer());

        showView();
    }

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

    // private void redirectToTransfer() {
    // view.dispose();
    // Navigation.transfer();
    // }

    private void logout() {
        view.dispose();
        Repository currentUser = new Repository();
        currentUser.logoutUser();
        Navigation.login();
        // Navigation.transfer();
    }
}
