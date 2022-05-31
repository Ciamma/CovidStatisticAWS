package covidStatistics.counters.model;

public class User {
    String id;
    boolean status;
    String timestamp;

    public User(String id, boolean status, String timestamp) {
        this.id = id;
        this.status = status;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setStatus(boolean s) {
        this.status = s;
    }

    public boolean getStatus() {
        return status;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
