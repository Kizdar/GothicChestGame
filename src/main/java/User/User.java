package User;

public class User {

    int liczbaProb;
    int wynik;

    public User(int liczbaProb, int wynik) {
        this.liczbaProb = liczbaProb;
        this.wynik = wynik;
    }

    public User() {
    }

    public int getLiczbaProb() {
        return liczbaProb;
    }

    public void setLiczbaProb(int liczbaProb) {
        this.liczbaProb = liczbaProb;
    }

    public int getWynik() {
        return wynik;
    }

    public void setWynik(int wynik) {
        this.wynik = wynik;
    }
}
