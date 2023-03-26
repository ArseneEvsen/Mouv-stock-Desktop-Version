package view.creationMode.Retrieve;

import javax.swing.*;

import modele.Article;
import modele.ArticleBatch;
import modele.dao.BarcodeOrigin;
import modele.dao.DoTheProductExist;
import modele.dao.retrieve.RetrieveArticle;
import modele.dao.retrieve.RetrieveArticleBatch;
import view.creationMode.SelectCreation;
import view.creationMode.SellGUI;
import view.creationMode.StockActionChoice;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RetrieveStart extends JFrame {
    private JTextField codebarreField;
    private JButton searchButton;

    public RetrieveStart() {
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
        
        setTitle("Recherche d'article");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        

        codebarreField = new JTextField(20);
        add(new JLabel("Recherche d'article : "));
        add(codebarreField);

        searchButton = new JButton("Rechercher");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codebarre = codebarreField.getText();
                if (codebarre.isEmpty()) {
                    JOptionPane.showMessageDialog(RetrieveStart.this, "Le champ 'Codebarre' est vide.");
                    return;
                }

                if (!DoTheProductExist.DoTheProductExist(codebarre)) {
                    JOptionPane.showMessageDialog(RetrieveStart.this, "Le produit n'existe pas.");
                    return;
                }

                String origin = BarcodeOrigin.BarcodeOrigin(codebarre);
                if (origin.equals("article")) {
                    Article article = RetrieveArticle.retrieveArticle(codebarre);
                    //Afficher les informations de l'objet Article
                    new DisplayArticle(article);
                } else if (origin.equals("codebarre")) {
                    ArticleBatch articleBatch = RetrieveArticleBatch.retrieveArticleBatch(codebarre);
                    //Afficher les informations de l'objet ArticleBatch
                    new DisplayArticleBatch(articleBatch);
                }
            }
        });
        add(searchButton);
    }

    public static void main(String[] args) {
    	RetrieveStart exampleUI = new RetrieveStart();
        exampleUI.setVisible(true);
       
    }
}
