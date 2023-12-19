package com.banksystem.components;

import javax.swing.*;
import java.awt.*;

// Custom ComboBox with rounded corners
public class RoundedComboBox<E> extends JComboBox<E> {

    public RoundedComboBox() {
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
    }

    public RoundedComboBox(E[] items) {
        super(items);
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
    }

    public RoundedComboBox(ComboBoxModel<E> aModel) {
        super(aModel);
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
        super.paintComponent(g);
    }

    // @Override
    // protected void paintBorder(Graphics g) {
    // g.setColor(Color.GRAY);
    // g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
    // }
}
