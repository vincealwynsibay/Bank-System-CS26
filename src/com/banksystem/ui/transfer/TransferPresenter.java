package com.banksystem.ui.transfer;

import com.banksystem.navigation.Navigation;
import com.banksystem.repository.Repository;

public class TransferPresenter {
    private TransferView view;

    public TransferPresenter(TransferView view) {
        this.view = view;
        // Add the action listeners
        this.view.getSubmit().addActionListener(e -> transfer());
        this.view.getBack().addActionListener(e -> redirectToMenu());
        showView();
    }

    private void redirectToMenu() {
        view.dispose();
        Navigation.menu();
    }

    // Transfer the amount
    private void transfer() {
        Repository repository = Repository.getInstance();

        try {
            double amount = Double.parseDouble(view.getTransferAmount().getText());

            // Check if the user has sufficient balance, if not show an error message
            if (repository.getCurrentAccount().getBalance() - amount < 0) {
                view.showMessage("Insufficient balance");
                return;
            }

            if (amount < 0) {
                throw new Exception("Invalid amount");
            }

            String destinationAccount = view.getDestinationAccount().getText();
            repository.transfer(destinationAccount, amount);

            view.showMessage("Transfer successful");
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

        if (repository.getCurrentAccount() == null) {
            view.showMessage("You must select an account first");
            Navigation.login();
            return;
        }

        view.setAvailableBalance(repository.getCurrentAccount().getBalance());

        view.pack();
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
}