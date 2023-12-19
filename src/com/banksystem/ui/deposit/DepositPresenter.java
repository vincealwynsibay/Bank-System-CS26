package com.banksystem.ui.deposit;

import com.banksystem.navigation.Navigation;
import com.banksystem.repository.Repository;

public class DepositPresenter {
    private DepositView view;

    public DepositPresenter(DepositView view) {
        this.view = view;

        // Attach click listener to the view components
        this.view.getSubmit().addActionListener(e -> deposit());
        this.view.getBack().addActionListener(e -> redirectToMenu());
        showView();
    }

    private void deposit() {
        Repository repository = Repository.getInstance();

        // Check if the user is logged in, if not redirect to the login view
        if (repository.getCurrentAccount() == null) {
            view.showMessage("You must login first");
            Navigation.login();
            return;
        }

        try {
            double amount = Double.parseDouble(view.getWithdrawAmount().getText());

            // Check if the amount is valid, if not show an error message
            if (amount < 0) {
                throw new Exception("Invalid amount");
            }

            // Deposit the amount
            repository.getCurrentAccount().deposit(amount);
            view.showMessage("Deposit successful");

            // Redirect to the menu view
            view.dispose();
            Navigation.menu();
        } catch (NumberFormatException e) {
            view.showMessage("Invalid amount");
        } catch (Exception e) {
            view.showMessage(e.getMessage());
        }
    }

    private void redirectToMenu() {
        view.dispose();
        Navigation.menu();
    }

    private void showView() {

        Repository repository = Repository.getInstance();

        // Check if the user is logged in, if not redirect to the login view
        if (repository.getCurrentAccount() == null) {
            view.showMessage("You must select an account first");
            Navigation.login();
            return;
        }

        view.pack();
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
}
