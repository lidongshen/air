package entity;


public class Piao {
    private int piao;

    public int getPiao() {
        return piao;
    }

    public void setPiao(int piao) {
        this.piao = piao;
    }

    public Piao() {
    }

    public Piao(int piao) {
        this.piao = piao;
    }

    @Override
    public String toString() {
        return "Piao{" +
                "piao=" + piao +
                '}';
    }
}
