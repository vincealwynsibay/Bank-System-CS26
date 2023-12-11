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

    private void withdraw() {
        Repository repository = Repository.getInstance();

        try {
            double amount = Double.parseDouble(view.getWithdrawAmount().getText());
            if (repository.getCurrentAccount().withdraw(amount) == -1) {
                view.showMessage("Insufficient balance");
                return;
            }

            if (amount < 0) {
                throw new Exception("Invalid amount");
            }

            view.showMessage("Withdraw successful");
        } catch (NumberFormatException e) {
            view.showMessage("Invalid amount");
        } catch (Exception e) {
            view.showMessage(e.getMessage());
        }
    }

    private void showView() {
        view.pack();
        view.setLocationRelativeTo(null);
        view.setVisible(true);

        Repository repository = Repository.getInstance();

        if (repository.getCurrentAccount() == null) {
            view.showMessage("You must select an account first");
            Navigation.login();
            return;
        }

        view.setAvailableBalance(repository.getCurrentAccount().getBalance());
    }
}
