package view.creationMode;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import modele.Article;
import modele.ArticleBatch;
import modele.dao.ArticleBatchDao;
import view.creationMode.Retrieve.RetrieveStart;

public class BatchArticleGUI extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel codebarreLotLabel, quantiteLotLabel, codebarreArticleLabel, prixLotLabel;
    private JTextField codebarreLotField, quantiteLotField, codebarreArticleField, prixLotField;
    private JButton createButton;

    public BatchArticleGUI() {
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
        
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(5, 5, 5, 5);
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.CENTER; 

        gc.gridx = 0;
        gc.gridy = 0;
        codebarreLotLabel = new JLabel("Code-barre du lot: ");
        add(codebarreLotLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        codebarreLotField = new JTextField(10);
        add(codebarreLotField, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        quantiteLotLabel = new JLabel("Quantité du lot: ");
        add(quantiteLotLabel, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        quantiteLotField = new JTextField(10);
        add(quantiteLotField, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        codebarreArticleLabel = new JLabel("Code-barre de l'article de base: ");
        add(codebarreArticleLabel, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        codebarreArticleField = new JTextField(10);
        add(codebarreArticleField, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        prixLotLabel = new JLabel("Prix du lot: ");
        add(prixLotLabel, gc);

        gc.gridx = 1;
        gc.gridy = 3;
        prixLotField = new JTextField(10);
        add(prixLotField, gc);

        gc.gridx = 0;
        gc.gridy = 4;
        gc.gridwidth = 2;
        createButton = new JButton("Créer");
        add(createButton, gc);

        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(checkFields()) {
                String codebarreLot = codebarreLotField.getText();
                Integer quantiteLot = Integer.parseInt(quantiteLotField.getText());
                String codebarreArticle = codebarreArticleField.getText();
                float prixLot = Float.parseFloat(prixLotField.getText());
                
                Article unArticle = new Article(null,0,null,null,null,null,0,0,codebarreArticle,null);
                ArticleBatch unLotArticle = new ArticleBatch(codebarreLot,quantiteLot,prixLot,unArticle);
                int result = ArticleBatchDao.CreateArticleBatch(unLotArticle);
                System.out.println(result);
            	}
            	else{
                    JOptionPane.showMessageDialog(null, "Tous les champs doivent être remplis !");
                }
            }
        });
        
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
 // Vérification qu'aucun champs obligatoires ne soit vides + que les champs prix et stock soient supérieur>=0
    private boolean checkFields() {
        if(!codebarreLotField.getText().isEmpty()
            && !quantiteLotField.getText().isEmpty()
            && !codebarreArticleField.getText().isEmpty()
            && !prixLotField.getText().isEmpty()
        	&& !(Integer.parseInt(quantiteLotField.getText())<0) 
        	&& !(Float.parseFloat(prixLotField.getText()) <0))
        {
            createButton.setEnabled(true);
            return true;
        } else {
            return false;
        }
    }
    
    public static void main(String[] args) {
        new BatchArticleGUI();
    }
}

