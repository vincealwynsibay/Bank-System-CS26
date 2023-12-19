package com.banksystem.ui.register;

import com.banksystem.data.SavingsAccount;
import com.banksystem.navigation.Navigation;
import com.banksystem.repository.Repository;

public class RegisterPresenter {
    private RegisterView view;

    public RegisterPresenter(RegisterView view) {
        this.view = view;

        // Attach click listener to the view components
        view.getBtnSubmit().addActionListener(e -> register());
        view.getBtnLogin().addActionListener(e -> redirectToLogin());
        showView();
    }

    // Show the view
    private void showView() {
        view.pack();
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }

    // Register the user
    private void register() {
        Repository repository = Repository.getInstance();

        try {
            boolean isCreatedSuccessfully = repository.register(view.getNameInput().getText(),
                    Integer.parseInt(view.getAge().getText()), view.getPassword().getText(),
                    view.getAccountType().getSelectedItem().toString());

            // Check if the account is created successfully, if not show an error message
            if (!isCreatedSuccessfully) {
                view.showMessage("Account already exists");
                return;
            }

            view.showMessage("Account created successfully");

        } catch (Exception e) {
            view.showMessage(e.getMessage());
            return;
        }

        // Redirect to the login view
        view.dispose();
        Navigation.login();
    }

    private void redirectToLogin() {
        view.dispose();
        Navigation.login();
    }
}
