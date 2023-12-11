package com.banksystem.ui.profile;

import com.banksystem.data.Account;
import com.banksystem.navigation.Navigation;
import com.banksystem.repository.Repository;

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
            // view.getInterestRate().setText(String.valueOf(repository.getCurrentAccount().getInterestRate()));
            // view.getCreatedAt().setText(repository.getCurrentAccount().getCreated_at());
            // view.getUpdatedAt().setText(repository.getCurrentAccount().getUpdated_at());
        } else {

        }
    }
}
