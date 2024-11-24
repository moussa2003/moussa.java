public class AdresseIP {
    protected String adresseIP; 
    private char classe;        

    public AdresseIP(String adresseIP) throws InvalidIPException {
        this.adresseIP = adresseIP;
        if (!validerAdresse()) {
            throw new InvalidIPException("Adresse IP invalide : " + adresseIP);
        }
        this.classe = calculerClasse();
    }

    // Valide si l'adresse IP est correcte
    private boolean validerAdresse() {
        String[] octets = adresseIP.split("\\.");
        if (octets.length != 4) {
            return false;
        }
        try {
            for (String octet : octets) {
                int valeur = Integer.parseInt(octet);
                if (valeur < 0 || valeur > 255) {
                    return false;
                }
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    // Calcule la classe de l'adresse IP
    private char calculerClasse() {
        int premierOctet = Integer.parseInt(adresseIP.split("\\.")[0]);
        if (premierOctet >= 1 && premierOctet <= 126) {
            return 'A';
        } else if (premierOctet >= 128 && premierOctet <= 191) {
            return 'B';
        } else if (premierOctet >= 192 && premierOctet <= 223) {
            return 'C';
        } else if (premierOctet >= 224 && premierOctet <= 239) {
            return 'D';
        } else {
            return 'E';
        }
    }

    // Retourne la classe de l'adresse IP
    public char getClasse() {
        return classe;
    }
}
