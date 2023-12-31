package com.banksystem.ui.transactions;

import com.banksystem.navigation.Navigation;
import com.banksystem.repository.Repository;

public class TransactionsPresenter {
    private TransactionsView view;

    public TransactionsPresenter(TransactionsView view) {
        this.view = view;

        this.view.getBtnBack().addActionListener(e -> redirectToMenu());

        showView();
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

        view.setTransactions(repository.getTransactions());

        view.pack();
        view.setLocationRelativeTo(null);
        view.setVisible(true);

    }

}
