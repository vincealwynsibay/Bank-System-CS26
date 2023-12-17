package com.banksystem;

import com.banksystem.navigation.Navigation;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Navigation.login();
    }

    // public static void main(String[] args) {
    // SwingUtilities.invokeLater(() -> createAndShowGUI());
    // }

    // private static void createAndShowGUI() {
    // JFrame frame = new JFrame("Scrollable List Example");
    // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // // Create a list of items (replace this with your content)
    // ArrayList<String> items = new ArrayList<>();
    // for (int i = 1; i <= 50; i++) {
    // items.add("Item " + i);
    // }

    // // Create a JList with the items
    // JList<String> itemList = new JList<>(items.toArray(new String[0]));

    // // Create a JScrollPane and add the JList to it
    // JScrollPane scrollPane = new JScrollPane(itemList);

    // // Set the layout manager of the content pane
    // frame.setLayout(new BorderLayout());

    // // Add the JScrollPane to the content pane
    // frame.add(scrollPane, BorderLayout.CENTER);

    // // Set frame properties
    // frame.setSize(300, 200);
    // frame.setLocationRelativeTo(null);
    // frame.setVisible(true);
    // }
}
