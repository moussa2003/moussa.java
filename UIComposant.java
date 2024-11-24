import javax.swing.*;

// Classe abstraite pour les composants UI
public abstract class UIComposant {
    protected JFrame frame;           
    protected JTextField ipField;     
    protected JTextField masqueField; 
    protected JTextArea resultArea;   

    public UIComposant() {
        // Initialisation de base pour l'interface graphique
        frame = new JFrame("Calculateur d'Adresse Réseau");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        ipField = new JTextField(15);
        masqueField = new JTextField(15);
        resultArea = new JTextArea(10, 30);
    }

    // Méthode abstraite pour initialiser les éléments de l'interface
    protected abstract void initialiserUI();

    // Méthode abstraite pour mettre à jour les résultats affichés
    protected abstract void mettreAJourResultats(String resultat);

    // Méthode utilitaire pour afficher des messages d'erreur
    protected void afficherErreur(String message) {
        JOptionPane.showMessageDialog(frame, message, "Erreur", JOptionPane.ERROR_MESSAGE);
    }
}
