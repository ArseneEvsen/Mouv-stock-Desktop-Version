package view.creationMode;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modele.dao.AddStock;
import view.creationMode.Retrieve.RetrieveStart;

public class AddStockGUI extends JFrame {
    public AddStockGUI() {
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
        
        setLayout(new FlowLayout());

        JLabel label = new JLabel("Veuillez scanner le produit ou le lot de produit");
        add(label);

        JTextField codebarreField = new JTextField(20);
        add(codebarreField);

        JButton addButton = new JButton("Ajouter");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codebarre = codebarreField.getText();
                if(codebarre.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Le champ codebarre est vide, veuillez entrer un codebarre valide.");
                }
                else { 
               try {
				AddStock.AddStock(codebarre);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
					}
                }
            }
        });
        add(addButton);

        setTitle("Scanner Input");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    

    public static void main(String[] args) {
        new AddStockGUI();
    }
}
