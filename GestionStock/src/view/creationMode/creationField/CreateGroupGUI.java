package view.creationMode.creationField;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import modele.dao.creationField.CreateGroup;
import view.creationMode.SelectCreation;
import view.creationMode.SellGUI;
import view.creationMode.StockActionChoice;
import view.creationMode.Retrieve.RetrieveStart;

public class CreateGroupGUI extends JFrame {

    private JLabel groupLabel;
    private JTextField groupField;
    private JButton createButton;

    public CreateGroupGUI() {
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
        setTitle("Création de groupes");
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(5, 5, 5, 5);
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.CENTER;

        gc.gridx = 0;
        gc.gridy = 0;
        groupLabel = new JLabel("Ecrivez le nom du nouveau groupe que vous souhaitez créer : ");
        add(groupLabel, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        groupField = new JTextField(20);
        add(groupField, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        createButton = new JButton("Créer");
        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String group = groupField.getText();
                int resultCreationGroup = 0;
                if (group.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Veuillez saisir un nom de groupe.");
                } else {
                	resultCreationGroup = CreateGroup.CreateGroup(group);
                	System.out.println(resultCreationGroup);
                }
            }
        });
        add(createButton, gc);

        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }


    public static void main(String[] args) {
        new CreateGroupGUI();
    }
}
