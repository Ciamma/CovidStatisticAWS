package covidStatistics.counters.exception;

public class UserException extends Exception {

    public UserException() {
        super("Utente non trovato");
    }
}
