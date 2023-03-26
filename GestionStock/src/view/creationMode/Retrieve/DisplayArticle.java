package view.creationMode.Retrieve;

import javax.swing.*;

import modele.Article;
import view.creationMode.SelectCreation;
import view.creationMode.SellGUI;
import view.creationMode.StockActionChoice;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayArticle extends JFrame {
	
    private JLabel nomArticleLabel;
    private JLabel stockLabel;
    private JLabel sousgroupeLabel;
    private JLabel sousgroupe2Label;
    private JLabel groupeLabel;
    private JLabel uniteLabel;
    private JLabel qteUniteLabel;
    private JLabel prixLabel;
    private JLabel codebarreLabel;
    private JLabel marqueLabel;

    public DisplayArticle(Article article) {
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
        
        setTitle("Détails de l'article");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(9, 2));
        setVisible(true);

        nomArticleLabel = new JLabel("Nom de l'article : " + article.getNomArticle());
        add(nomArticleLabel);

        stockLabel = new JLabel("Stock : " + article.getStock());
        add(stockLabel);

        sousgroupeLabel = new JLabel("Sous-groupe : " + article.getSousgroupe());
        add(sousgroupeLabel);

        sousgroupe2Label = new JLabel("Sous-groupe 2 : " + article.getSousgroupe2());
        add(sousgroupe2Label);

        groupeLabel = new JLabel("Groupe : " + article.getGroupe());
        add(groupeLabel);

        uniteLabel = new JLabel("Unité : " + article.getUnite());
        add(uniteLabel);

        qteUniteLabel = new JLabel("Quantité par unité : " + article.getUnite());
        add(qteUniteLabel);

        prixLabel = new JLabel("Prix : " + article.getPrix());
        add(prixLabel);

        codebarreLabel = new JLabel("Code barre : " + article.getCodebarre());
        add(codebarreLabel);

        marqueLabel = new JLabel("Marque : " + article.getMarque());
        add(marqueLabel);
    }


}
