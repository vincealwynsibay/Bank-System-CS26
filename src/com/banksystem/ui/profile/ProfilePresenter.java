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

        // Attach click listener to the view components
        this.view.getBack().addActionListener(e -> redirectToMenu());
        showView();
    }

    // Show the view
    private void showView() {

        Repository repository = Repository.getInstance();
        Account currentUser = repository.getCurrentAccount();

        // Check if the user is logged in, if not redirect to the login view
        if (currentUser != null) {
            view.setName(currentUser.getName());
            view.setAge(currentUser.getAge());
            view.setBalance(currentUser.getBalance());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");

            view.setCreatedAt(currentUser.getCreatedAt().format(formatter));

            // Check if the user is a savings account or a checking account
            // and set the account type accordingly
            if (currentUser instanceof SavingsAccount) {
                view.setAccountType("Savings Account");
            } else {
                view.setAccountType("Checking Account");
            }

            view.pack();
            view.setLocationRelativeTo(null);
            view.setVisible(true);
        } else {
            view.dispose();
            Navigation.login();
        }
    }

    private void redirectToMenu() {
        view.dispose();
        Navigation.menu();
    }
}
