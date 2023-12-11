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
import com.banksystem.ui.withdraw.WithdrawPresenter;
import com.banksystem.ui.withdraw.WithdrawView;
import com.banksystem.ui.register.RegisterPresenter;

public abstract class Navigation {

    public static void login() {
        LoginView loginView = new LoginView();
        new LoginPresenter(loginView);
    }

    public static void register() {
        RegisterView registerView = new RegisterView();
        new RegisterPresenter(registerView);
    }

    public static void menu() {
        MenuView menuView = new MenuView();
        new MenuPresenter(menuView);
    }

    public static void profile() {
        ProfileView profileView = new ProfileView();
        new ProfilePresenter(profileView);
    }

    public static void withdraw() {
        WithdrawView withdrawView = new WithdrawView();
        new WithdrawPresenter(withdrawView);
    }

    public static void deposit() {
        DepositView depositView = new DepositView();
        new DepositPresenter(depositView);
    }

}
