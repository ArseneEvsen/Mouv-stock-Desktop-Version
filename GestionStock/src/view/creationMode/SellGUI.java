package view.creationMode;

import javax.swing.*;
import modele.dao.SellArticle;
import view.creationMode.Retrieve.RetrieveStart;

import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class SellGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField inputField;
    private Timer timer;

    public SellGUI() {
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
        
        setTitle("Input Window");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        inputField = new JTextField();
        inputField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (timer != null) {
                    timer.cancel();
                }
                timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        String codebarre = inputField.getText();
                        // traitement de l'entrée
                        SellArticle.SellArticle(codebarre);
                        inputField.setText("");
                    }
                }, 1500);
            }
        });
        add(inputField);
        setVisible(true);
        inputField.requestFocus();
    }

    public static void main(String[] args) {
        new SellGUI();
    }
}
