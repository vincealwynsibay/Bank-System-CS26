package com.banksystem.ui.deposit;

import com.banksystem.navigation.Navigation;
import com.banksystem.repository.Repository;

public class DepositPresenter {
    private DepositView view;

    public DepositPresenter(DepositView view) {
        this.view = view;

        this.view.getSubmit().addActionListener(e -> deposit());
        this.view.getBack().addActionListener(e -> redirectToMenu());
        showView();
    }

    private void deposit() {
        Repository repository = Repository.getInstance();

        if (repository.getCurrentAccount() == null) {
            view.showMessage("You must login first");
            Navigation.login();
            return;
        }

        try {
            double amount = Double.parseDouble(view.getWithdrawAmount().getText());

            if (amount < 0) {
                throw new Exception("Invalid amount");
            }

            repository.getCurrentAccount().deposit(amount);
            view.showMessage("Deposit successful");
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
        view.pack();
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
}
