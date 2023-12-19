package com.banksystem.navigation;

import com.banksystem.ui.deposit.DepositPresenter;
import com.banksystem.ui.deposit.DepositView;
import com.banksystem.ui.login.LoginPresenter;
import com.banksystem.ui.login.LoginView;
import com.banksystem.ui.menu.MenuPresenter;
import com.banksystem.ui.menu.MenuView;
import com.banksystem.ui.profile.ProfilePresenter;
import com.banksystem.ui.profile.ProfileView;
import com.banksystem.ui.register.RegisterView;
import com.banksystem.ui.transactions.TransactionsPresenter;
import com.banksystem.ui.transactions.TransactionsView;
import com.banksystem.ui.transfer.TransferPresenter;
import com.banksystem.ui.transfer.TransferView;
import com.banksystem.ui.withdraw.WithdrawPresenter;
import com.banksystem.ui.withdraw.WithdrawView;
import com.banksystem.ui.register.RegisterPresenter;

// Navigation class for the application for a more centralized navigation
public abstract class Navigation {

    // Show the login view
    public static void login() {
        LoginView loginView = new LoginView();
        new LoginPresenter(loginView);
    }

    // Show the register view
    public static void register() {
        RegisterView registerView = new RegisterView();
        new RegisterPresenter(registerView);
    }

    // Show the menu view
    public static void menu() {
        MenuView menuView = new MenuView();
        new MenuPresenter(menuView);
    }

    // Show the profile view
    public static void profile() {
        ProfileView profileView = new ProfileView();
        new ProfilePresenter(profileView);
    }

    // Show the withdraw view
    public static void withdraw() {
        WithdrawView withdrawView = new WithdrawView();
        new WithdrawPresenter(withdrawView);
    }

    // Show the deposit view
    public static void deposit() {
        DepositView depositView = new DepositView();
        new DepositPresenter(depositView);
    }

    // Show the transfer view
    public static void transfer() {
        TransferView transferView = new TransferView();
        new TransferPresenter(transferView);
    }

    // Show the transactions view
    public static void transactions() {
        TransactionsView transactionsView = new TransactionsView();
        new TransactionsPresenter(transactionsView);
    }

}
