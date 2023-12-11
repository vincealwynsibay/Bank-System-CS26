package com.banksystem.ui.register;

import com.banksystem.navigation.Navigation;

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
        view.dispose();
    }

    private void redirectToLogin() {
        view.dispose();
        Navigation.login();
    }
}
