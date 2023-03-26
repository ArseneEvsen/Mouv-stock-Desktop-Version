package view.creationMode;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import view.creationMode.Retrieve.RetrieveStart;
import view.creationMode.creationField.CreationChoice;

public class SelectCreation extends JFrame {
    private JButton productButton;
    private JButton creationButton;

    public SelectCreation() {
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
        
    	setVisible(true);
        setTitle("Choix d'opération");
        setSize(400, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        productButton = new JButton("Enregistrer un produit ou un lot de produits");
        creationButton = new JButton("Créer des marques / sous-groupes / groupes");
        productButton.addActionListener(e -> new ProductTypeGUI());
        creationButton.addActionListener(e -> new CreationChoice());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2,1,0,20));
        mainPanel.add(productButton);
        mainPanel.add(creationButton);
        mainPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        setContentPane(mainPanel);
    }

    public static void main(String[] args) {
        new SelectCreation();
    }
}
