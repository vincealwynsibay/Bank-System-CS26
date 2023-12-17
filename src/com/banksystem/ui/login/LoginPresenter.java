package com.banksystem.ui.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import com.banksystem.navigation.Navigation;
import com.banksystem.repository.Repository;

public class LoginPresenter {
    private LoginView view;
    private Repository repository;

    public LoginPresenter(LoginView view) {
        this.view = view;

        // Attach click listener to the view components
        view.getBtnSubmit().addActionListener(e -> login());
        view.getBtnRegister().addActionListener(e -> redirectToRegister());
        showView();
    }

    private void showView() {
        view.pack();
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }

    private void login() {
        repository = Repository.getInstance();

        String accountId = view.getAccountId().getText();
        String password = view.getTxtPassword().getText();

        if (accountId.isEmpty() || password.isEmpty()) {
            view.showMessage("Please fill all the fields");
            return;
        }

        if (repository.login(accountId, password)) {
            System.out.print(repository.getCurrentAccount().getName());
            view.dispose();
            Navigation.menu();
        } else {
            view.showMessage("Invalid credentials");
        }

    }

    private void redirectToRegister() {
        view.dispose();
        Navigation.register();
    }

}
