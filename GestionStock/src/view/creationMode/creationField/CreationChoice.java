package view.creationMode.creationField;

import javax.swing.*;

import view.creationMode.SelectCreation;
import view.creationMode.SellGUI;
import view.creationMode.StockActionChoice;
import view.creationMode.Retrieve.RetrieveStart;

import java.awt.*;
import java.awt.event.*;

public class CreationChoice extends JFrame {

    public CreationChoice() {
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
        
        setTitle("Main Window");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton stockButton = new JButton("Créer une marque");
        stockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CreateBrandGUI();
            }
        });
        add(stockButton);

        JButton sellButton = new JButton("Créer un sous-groupe");
        sellButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CreateUnderGroupGUI();
            }
        });
        add(sellButton);

        JButton creationButton = new JButton("Créer un groupe");
        creationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	new CreateGroupGUI();
            }
        });
        add(creationButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        new CreationChoice();
    }
}
