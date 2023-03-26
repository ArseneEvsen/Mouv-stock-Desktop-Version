package view.creationMode;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import view.creationMode.Retrieve.RetrieveStart;

public class ProductTypeGUI extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel questionLabel;
    private JButton batchProductButton, singleProductButton;

    public ProductTypeGUI() {
    	
    	
        super("Type de produit");
        setVisible(true);
        setLayout(new FlowLayout());
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

        questionLabel = new JLabel("Est-ce que le code-barre à enregistrer désigne un lot de produits ou un produit seul ?");
        add(questionLabel);

        batchProductButton = new JButton("Lot de produits");
        add(batchProductButton);

        singleProductButton = new JButton("Produit seul");
        add(singleProductButton);

        batchProductButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                new BatchArticleGUI().setVisible(true);
            }
        });

        singleProductButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                new ArticleGUI().setVisible(true);
            }
        });

        setSize(500, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
    	new ProductTypeGUI();    
    	}
}
