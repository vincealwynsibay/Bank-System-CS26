package com.banksystem.ui.profile;

import com.banksystem.data.Account;
import com.banksystem.data.SavingsAccount;
import com.banksystem.navigation.Navigation;
import com.banksystem.repository.Repository;

import java.time.format.DateTimeFormatter;

public class ProfilePresenter {
    private ProfileView view;

    public ProfilePresenter(ProfileView view) {
        this.view = view;

        this.view.getBack().addActionListener(e -> redirectToMenu());
        showView();
    }

    private void redirectToMenu() {
        view.dispose();
        Navigation.menu();
    }

    private void showView() {
        view.pack();
        view.setLocationRelativeTo(null);
        view.setVisible(true);

        Repository repository = Repository.getInstance();

        Account currentUser = repository.getCurrentAccount();
        if (currentUser != null) {
            view.setName(currentUser.getName());
            view.setAge(currentUser.getAge());
            view.setBalance(currentUser.getBalance());
            view.setAccountId(currentUser.getAccountId());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");

            view.setCreatedAt(currentUser.getCreatedAt().format(formatter));

            if (currentUser instanceof SavingsAccount) {
                view.setAccountType("Savings Account");
            } else {
                view.setAccountType("Checking Account");
            }

            view.setTransactions(currentUser.getTransactions());
        } else {
            view.dispose();
            Navigation.login();
        }
    }
}
