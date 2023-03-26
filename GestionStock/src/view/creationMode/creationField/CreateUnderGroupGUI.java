package view.creationMode.creationField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import modele.dao.GetForeignKey;
import modele.dao.creationField.CreateUnderGroup;
import view.creationMode.SelectCreation;
import view.creationMode.SellGUI;
import view.creationMode.StockActionChoice;
import view.creationMode.Retrieve.RetrieveStart;

import java.util.ArrayList;

public class CreateUnderGroupGUI extends JFrame {
    private JLabel label;
    private JTextField subGroupField;
    private JComboBox groupList;
    private JButton createButton;

    public CreateUnderGroupGUI() {
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
        setTitle("Création de sous-groupe");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("Veuillez choisir le nom de votre nouveau sous-groupe ET le groupe auquel il appartient :");
        subGroupField = new JTextField();
        groupList = new JComboBox(GetForeignKey.retrieveGroups().toArray());
        createButton = new JButton("Créer");
        createButton.addActionListener(e -> {
            String subGroup = subGroupField.getText();
            if (subGroup.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Le nom de sous-groupe ne peut pas être vide.");
                return;
            }
            String group = (String) groupList.getSelectedItem();
            int resultCreateUnderGroup = CreateUnderGroup.CreateUnderGroup(subGroup, group);
            System.out.println(resultCreateUnderGroup);
        });

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.CENTER;

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.insets = new Insets(5, 5, 5, 5);
        mainPanel.add(label, c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        c.insets = new Insets(5, 5, 5, 5);
        mainPanel.add(subGroupField, c);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        c.insets = new Insets(5, 5, 5, 5);
        mainPanel.add(groupList, c);

        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 1;
        c.insets = new Insets(5, 5, 5, 5);

        mainPanel.add(createButton, c);

        setContentPane(mainPanel);
    }


    public static void main(String[] args) {
    	new CreateUnderGroupGUI();

    }
}
