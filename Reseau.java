public class Reseau extends AdresseIP {
    private String masque;       
    private String adresseDebut; 
    private String adresseFin;  
    
    //initialise un objet de type Reseau
    public Reseau(String adresseIP, String masque) throws InvalidIPException {
        super(adresseIP);
        this.masque = masque;
        calculerPlageAdresse();
    }

    // Calcule la plage d'adresses disponibles pour le sous-réseau
    public void calculerPlageAdresse() {
        String[] ipOctets = adresseIP.split("\\.");
        String[] masqueOctets = masque.split("\\.");

        int[] adresseDebutOctets = new int[4];
        int[] adresseFinOctets = new int[4];

        for (int i = 0; i < 4; i++) {
            int ipPart = Integer.parseInt(ipOctets[i]);
            int masquePart = Integer.parseInt(masqueOctets[i]);

            adresseDebutOctets[i] = ipPart & masquePart;
            adresseFinOctets[i] = adresseDebutOctets[i] | (~masquePart & 0xFF);
        }

        adresseDebut = String.format("%d.%d.%d.%d", adresseDebutOctets[0], adresseDebutOctets[1], adresseDebutOctets[2], adresseDebutOctets[3]);
        adresseFin = String.format("%d.%d.%d.%d", adresseFinOctets[0], adresseFinOctets[1], adresseFinOctets[2], adresseFinOctets[3]);
    }

    public String getMasque() {
        return masque;
    }

    public String getAdresseIP() {
        return adresseIP;
    }

    public String getAdresseDebut() {
        return adresseDebut;
    }

    public String getAdresseFin() {
        return adresseFin;
    }
}
