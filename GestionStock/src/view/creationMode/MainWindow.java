package view.creationMode;

import javax.swing.*;

import view.creationMode.Retrieve.RetrieveStart;
import view.creationMode.creationField.CreationChoice;

import java.awt.*;
import java.awt.event.*;

public class MainWindow extends JFrame {

    public MainWindow() {
        setTitle("Main Window");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton stockButton = new JButton("Mode Stock");
        stockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new StockActionChoice();
                dispose();
            }
        });
        add(stockButton);

        JButton sellButton = new JButton("Mode Vente");
        sellButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SellGUI();
                dispose();
            }
        });
        add(sellButton);

        JButton creationButton = new JButton("Mode Creation");
        creationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	new SelectCreation();
            	dispose();
            }
        });
        add(creationButton);

        JButton retrieveButton = new JButton("Mode Recherche");
        retrieveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 RetrieveStart exampleUI = new RetrieveStart();
                 exampleUI.setVisible(true);
                 dispose();
            }
        });
        add(retrieveButton);
        
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}
