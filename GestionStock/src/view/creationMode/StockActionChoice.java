package view.creationMode;

import javax.swing.*;

import view.creationMode.Retrieve.RetrieveStart;

import java.awt.*;
import java.awt.event.*;

public class StockActionChoice extends JFrame {

    public StockActionChoice() {
    	// Création de la barre de menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu Principal");
        JMenuItem menuStock = new JMenuItem("Mode Stock");
        JMenuItem menuVente = new JMenuItem("Mode Vente");
        JMenuItem menuRecherche = new JMenuItem("Mode Recherche");
        JMenuItem menuCreation = new JMenuItem("Mode Création");

        menuStock.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	new StockActionChoice();
            	dispose();
            }
        });
        menuVente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	new SellGUI();
            	dispose();
            }
        });
        menuRecherche.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	RetrieveStart exampleUI = new RetrieveStart();
                exampleUI.setVisible(true);
                dispose();
            }
        });
        menuCreation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	new SelectCreation();
                dispose();
            }
        });

        menu.add(menuCreation);
        menu.add(menuStock);
        menu.add(menuVente);
        menu.add(menuRecherche);
        menuBar.add(menu);

        setJMenuBar(menuBar);
        
        setTitle("Stock Window");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel label = new JLabel("Choisissez l'action de stock que vous voulez effectuer :");
        add(label);

        JButton addButton = new JButton("Ajouter du stock");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AddStockGUI();
                dispose();
            }
        });
        add(addButton);

        JButton removeButton = new JButton("Retirer du stock");
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new RemoveStockGUI();
                dispose();
            }
        });
        add(removeButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        new StockActionChoice();
    }
}
