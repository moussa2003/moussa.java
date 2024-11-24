import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculateurReseauSwingApp extends UIComposant {
    private HistoriqueCalculs historique;

    // Constructeur de l'application
    public CalculateurReseauSwingApp() {
        super(); 
        historique = new HistoriqueCalculs(); 
        initialiserUI(); 
    }

    @Override
    protected void initialiserUI() {
        // Création des boutons pour le calcul et l'historique
        JButton calculerButton = new JButton("Calculer");
        JButton historiqueButton = new JButton("Voir Historique");
        calculerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    
                    String ip = ipField.getText();
                    String masque = masqueField.getText();
                   
                    Reseau reseau = new Reseau(ip, masque);
                   
                    String resultat = String.format(
                            "Classe : %c\nPlage : %s - %s",
                            reseau.getClasse(),
                            reseau.getAdresseDebut(),
                            reseau.getAdresseFin()
                    );
                    
                    mettreAJourResultats(resultat);
                    historique.ajouterCalcul(reseau); 
                    historique.sauvegarderHistorique(); 
                } catch (Exception ex) {
                    afficherErreur(ex.getMessage()); 
                }
            }
        });
        
        historiqueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String contenu = historique.lireHistorique();
                    mettreAJourResultats("Historique des calculs :\n" + contenu);
                } catch (Exception ex) {
                    afficherErreur("Erreur : " + ex.getMessage()); 
                }
            }
        });

        // Création du panneau d'interface utilisateur et ajout des composants
        JPanel panel = new JPanel();
        panel.add(new JLabel("Adresse IP :"));
        panel.add(ipField);
        panel.add(new JLabel("Masque :"));
        panel.add(masqueField);
        panel.add(calculerButton); 
        panel.add(historiqueButton);
        panel.add(new JScrollPane(resultArea)); 

        frame.add(panel); 
        frame.setVisible(true); 
    }

    @Override
    protected void mettreAJourResultats(String resultat) {
        resultArea.setText(resultat);
    }
    
    public static void main(String[] args) {
        new CalculateurReseauSwingApp(); 
    }
}
