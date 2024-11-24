// Gère les erreurs pour des adresses IP invalides
public class InvalidIPException extends Exception {
    public InvalidIPException(String message) {
        super(message);
    }
}
