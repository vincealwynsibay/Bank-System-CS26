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

    // Show the view
    private void showView() {
        view.pack();
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }

    // Login the user
    private void login() {
        repository = Repository.getInstance();

        // Get the name and password from the view
        String name = view.getTxtName().getText();
        String password = view.getTxtPassword().getText();

        // Check if the name and password are empty, if not show an error message
        if (name.isEmpty() || password.isEmpty()) {
            view.showMessage("Please fill all the fields");
            return;
        }

        // Check if the credentials are valid, if not show an error message
        if (repository.login(name, password)) {

            // Redirect to the menu view
            view.dispose();
            Navigation.menu();
        } else {
            view.showMessage("Invalid credentials");
        }

    }

    // Redirect to the register view
    private void redirectToRegister() {
        view.dispose();
        Navigation.register();
    }

}
