import java.io.*; 
import java.util.ArrayList;
import java.util.List; 

//Classe pour gérer l'historique des calculs réseau.
public class HistoriqueCalculs {
    private List<String> historique; 
    private static final String FICHIER_HISTORIQUE = "historique.txt"; 
   
    public HistoriqueCalculs() {
        historique = new ArrayList<>();
    }

    //Méthode pour ajouter un calcul à l'historique.
    public void ajouterCalcul(Reseau reseau) {
        String calcul = String.format(
                "IP : %s, Masque : %s, Classe : %c, Plage : %s - %s",
                reseau.getAdresseIP(),      
                reseau.getMasque(),         
                reseau.getClasse(),         
                reseau.getAdresseDebut(),   
                reseau.getAdresseFin()      
        );
        historique.add(calcul); 
    }

    //Méthode pour sauvegarder l'historique dans un fichier texte.
    public void sauvegarderHistorique() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FICHIER_HISTORIQUE, true))) {
            for (String calcul : historique) {
                writer.write(calcul);     
                writer.newLine();        
            }
            historique.clear(); 
        }
    }

   
     // Méthode pour lire l'historique depuis le fichier texte.
   
    public String lireHistorique() throws IOException {
        StringBuilder contenu = new StringBuilder(); // 
        try (BufferedReader reader = new BufferedReader(new FileReader(FICHIER_HISTORIQUE))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) { 
                contenu.append(ligne).append("\n"); 
            }
        }
        return contenu.toString();
    }
}
