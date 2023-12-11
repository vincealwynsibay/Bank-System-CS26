package com.banksystem.ui.register;

import com.banksystem.data.SavingsAccount;
import com.banksystem.navigation.Navigation;
import com.banksystem.repository.Repository;

public class RegisterPresenter {
    private RegisterView view;

    /**
     * Constructor
     * 
     * @param view view attached to this controller
     */
    public RegisterPresenter(RegisterView view) {
        this.view = view;

        // Attach click listener to the view components
        view.getBtnSubmit().addActionListener(e -> register());
        view.getBtnLogin().addActionListener(e -> redirectToLogin());
        showView();
    }

    /**
     * Shows the view
     */
    private void showView() {
        view.pack();
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }

    /**
     * Authenticates the user
     */
    private void register() {
        // create account
        Repository repository = Repository.getInstance();

        // redirect to login
        repository.register(view.getAccountType().getSelectedItem().toString(), view.getNameInput().getText(),
                Integer.parseInt(view.getAge().getText()), view.getPassword().getText());

        view.dispose();
    }

    private void redirectToLogin() {
        view.dispose();
        Navigation.login();
    }
}
