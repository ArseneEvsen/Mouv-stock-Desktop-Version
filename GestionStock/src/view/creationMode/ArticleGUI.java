package view.creationMode;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import modele.Article;
import modele.dao.ArticleDao;
import modele.dao.GetForeignKey;
import view.creationMode.Retrieve.RetrieveStart;

public class ArticleGUI extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel nomArticleLabel, codebarreLabel, stockLabel, groupeLabel, sousGroupe1Label, sousGroupe2Label, uniteLabel, quantiteLabel, prixLabel, marqueLabel;
    private JTextField nomArticleField, codebarreField, stockField, quantiteField, prixField;
    private JComboBox groupeBox, sousGroupe1Box, sousGroupe2Box, uniteBox, marqueBox;
    private JButton createButton;

    public ArticleGUI() {
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
        nomArticleLabel = new JLabel("Nom de l'article: ");
        add(nomArticleLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        nomArticleField = new JTextField(10);
        add(nomArticleField, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        codebarreLabel = new JLabel("Code-barre: ");
        add(codebarreLabel, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        codebarreField = new JTextField(10);
        add(codebarreField, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        stockLabel = new JLabel("Stock: ");
        add(stockLabel, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        stockField = new JTextField(10);
        add(stockField, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        quantiteLabel = new JLabel("Quantité de l'unité: ");
        add(quantiteLabel, gc);

        gc.gridx = 1;
        gc.gridy = 3;
        quantiteField = new JTextField(10);
        add(quantiteField, gc);

        gc.gridx = 0;
        gc.gridy = 4;
        prixLabel = new JLabel("Prix: ");
        add(prixLabel, gc);

        gc.gridx = 1;
        gc.gridy = 4;
        prixField = new JTextField(10);
        add(prixField, gc);
        
        gc.gridx = 0;
        gc.gridy = 5;
        groupeLabel = new JLabel("Groupe: ");
        add(groupeLabel, gc);

        gc.gridx = 1;
        gc.gridy = 5;
        groupeBox = new JComboBox();
        ArrayList<String> listOfGroups = GetForeignKey.retrieveGroups();
        for( String groups : listOfGroups) {
			groupeBox.addItem(groups);
		}
		add(groupeBox, gc);

        gc.gridx = 0;
        gc.gridy = 6;
        sousGroupe1Label = new JLabel("Sous-groupe 1: ");
        add(sousGroupe1Label, gc);
        
        gc.gridx = 1;
        gc.gridy = 6;
        sousGroupe1Box = new JComboBox();
        ArrayList<String> listOfUnderGroups = GetForeignKey.retrieveUnderGroups();
        for( String undergroups : listOfUnderGroups) {
        	sousGroupe1Box.addItem(undergroups);
		}
        sousGroupe1Box.addItem(null);
        add(sousGroupe1Box, gc);

        gc.gridx = 0;
        gc.gridy = 7;
        sousGroupe2Label = new JLabel("Sous-groupe 2: ");
        add(sousGroupe2Label, gc);

        gc.gridx = 1;
        gc.gridy = 7;
        sousGroupe2Box = new JComboBox();
        ArrayList<String> listOfUnderGroups2 = GetForeignKey.retrieveUnderGroups();
        for( String undergroups : listOfUnderGroups2) {
        	sousGroupe2Box.addItem(undergroups);
		}
        sousGroupe2Box.addItem(null);
        add(sousGroupe2Box, gc);

        gc.gridx = 0;
        gc.gridy = 8;
        uniteLabel = new JLabel("Unité: ");
        add(uniteLabel, gc);

        gc.gridx = 1;
        gc.gridy = 8;
        uniteBox = new JComboBox();
        ArrayList<String> listOfUnite = GetForeignKey.retrieveUnite();
        for( String unite : listOfUnite) {
        	uniteBox.addItem(unite);
		}
        add(uniteBox, gc);

        gc.gridx = 0;
        gc.gridy = 9;
        marqueLabel = new JLabel("Marque: ");
        add(marqueLabel, gc);

        gc.gridx = 1;
        gc.gridy = 9;
        marqueBox = new JComboBox();
        ArrayList<String> listOfBrands = GetForeignKey.retrieveBrands();
        for( String brands : listOfBrands) {
        	marqueBox.addItem(brands);
		}
        add(marqueBox, gc);
    

        gc.gridx = 0;
        gc.gridy = 10;
        gc.gridwidth = 2;
        createButton = new JButton("Créer");
        add(createButton, gc);


        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(checkFields()) {
                String nomArticle = nomArticleField.getText();
                String codebarre = codebarreField.getText();
                Integer stock = Integer.parseInt(stockField.getText());
                String groupe = (String) groupeBox.getSelectedItem();
                String sousGroupe1 = (String) sousGroupe1Box.getSelectedItem();
                String sousGroupe2 = (String) sousGroupe2Box.getSelectedItem();
                String unite = (String) uniteBox.getSelectedItem();
                float quantite = Float.parseFloat(quantiteField.getText());
                float prix = Float.parseFloat(prixField.getText());
                String marque = (String) marqueBox.getSelectedItem();
                
              
                Article unArticle = new Article(nomArticle,stock, sousGroupe1,sousGroupe2, groupe, unite, quantite,prix,codebarre,marque);
                int result = ArticleDao.CreateArticle(unArticle);
                System.out.println(result);
            	}else{
                    JOptionPane.showMessageDialog(null, "Tous les champs, excepté 'sous-groupe 1' et 'sous-groupe 2' doivent obligatoirement être renseignés !");
                }

            }
        });
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Vérification qu'aucun champs obligatoires ne soit vides + que les champs prix et stock soient supérieur>=0
    private boolean checkFields() {
        if(!nomArticleField.getText().isEmpty() && !codebarreField.getText().isEmpty() && !stockField.getText().isEmpty() && !quantiteField.getText().isEmpty() && !prixField.getText().isEmpty()
        		&& !(Integer.parseInt(stockField.getText())<0) && !(Float.parseFloat(prixField.getText()) <0)  ) 
        {
            createButton.setEnabled(true);
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        new ArticleGUI();
    }
}

