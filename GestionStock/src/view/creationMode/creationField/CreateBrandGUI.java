package view.creationMode.creationField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import modele.dao.creationField.CreateBrand;
import view.creationMode.SelectCreation;
import view.creationMode.SellGUI;
import view.creationMode.StockActionChoice;
import view.creationMode.Retrieve.RetrieveStart;

public class CreateBrandGUI extends JFrame {
    private JLabel label;
    private JTextField brandField;
    private JButton createButton;

    public CreateBrandGUI() {
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
        setTitle("Création de marque");
        setSize(400, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("Veuillez saisir la marque à créer :");
        brandField = new JTextField();
        createButton = new JButton("Créer");
        createButton.addActionListener(e -> {
            String brand = brandField.getText();
            if (brand.isEmpty()) {
                JOptionPane.showMessageDialog(this, "La marque ne peut pas être vide.");
                return;
            }
            int resultCreateBrand = CreateBrand.CreateBrand(brand);
            System.out.println(resultCreateBrand);
        });

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.LINE_END;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.CENTER;
        
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 10, 10);
        mainPanel.add(label, c);

        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(10, 10, 10, 10);
        mainPanel.add(brandField, c);

        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(10, 10, 10, 10);

        mainPanel.add(createButton, c);

        setContentPane(mainPanel);
    }



    public static void main(String[] args) {
        new CreateBrandGUI();
   
    }
}
