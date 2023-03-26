package view.creationMode.Retrieve;

import javax.swing.*;

import modele.Article;
import modele.ArticleBatch;
import view.creationMode.SelectCreation;
import view.creationMode.SellGUI;
import view.creationMode.StockActionChoice;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayArticleBatch extends JFrame {
    private JLabel qteArticleLabel;
    private JLabel prixLotLabel;
    private JLabel nomArticleLabel;
    private JButton displayArticleButton;

    public DisplayArticleBatch(ArticleBatch articleBatch) {
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
        
        setTitle("Détails du lot d'articles");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2));
        setVisible(true);

        qteArticleLabel = new JLabel("Nombre d'article présent dans le lot : " + articleBatch.getQteArticle());
        add(qteArticleLabel);

        prixLotLabel = new JLabel("Prix du lot : " + articleBatch.getPrixLot());
        add(prixLotLabel);

        nomArticleLabel = new JLabel("Nom de l'article : " + articleBatch.getUnArticle().getNomArticle());
        add(nomArticleLabel);

        displayArticleButton = new JButton("Afficher l'article associé");
        displayArticleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Article associatedArticle = articleBatch.getUnArticle();
                DisplayArticle displayArticleUI = new DisplayArticle(associatedArticle);
            
            }
        });
        add(displayArticleButton);
    }

}
