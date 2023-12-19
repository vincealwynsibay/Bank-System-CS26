package com.banksystem.ui.withdraw;

import com.banksystem.navigation.Navigation;
import com.banksystem.repository.Repository;

public class WithdrawPresenter {
    private WithdrawView view;

    public WithdrawPresenter(WithdrawView view) {
        this.view = view;
        this.view.getSubmit().addActionListener(e -> withdraw());
        this.view.getBack().addActionListener(e -> redirectToMenu());
        showView();
    }

    private void redirectToMenu() {
        view.dispose();
        Navigation.menu();
    }

    // Withdraw the amount
    private void withdraw() {
        Repository repository = Repository.getInstance();

        try {
            double amount = Double.parseDouble(view.getWithdrawAmount().getText());

            // Check if the user has sufficient balance, if not show an error message
            if (repository.getCurrentAccount().withdraw(amount) == -1) {
                view.showMessage("Insufficient balance");
                return;
            }

            if (amount < 0) {
                throw new Exception("Invalid amount");
            }

            view.showMessage("Withdraw successful");
            view.dispose();
            Navigation.menu();
        } catch (NumberFormatException e) {
            view.showMessage("Invalid amount");
        } catch (Exception e) {
            view.showMessage(e.getMessage());
        }
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

        view.setAvailableBalance(repository.getCurrentAccount().getBalance());
    }
}
