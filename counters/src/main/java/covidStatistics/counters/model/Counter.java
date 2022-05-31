package covidStatistics.counters.model;

public class Counter {
    String day;
    Integer nMalati;
    Integer nGuariti;

    public Counter(String day, Integer nMalati, Integer nGuariti) {
        this.day = day;
        this.nMalati = nMalati;
        this.nGuariti = nGuariti;
    }

    public String getDay() {
        return day;
    }

    public void setNMalati(Integer n) {
        this.nMalati = n;
    }

    public Integer getNMalati() {
        return nMalati;
    }

    public void setNGuariti(Integer n) {
        this.nGuariti = n;
    }

    public Integer getNGuariti() {
        return nGuariti;
    }


}
