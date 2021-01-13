package sandu.md.demo.entity;




import lombok.Setter;
import lombok.ToString;


@Setter

@ToString

public class Produs {

    private Long id_produse;
    private String nume_produse;
    private double pret;
    private String brand;
    private int cantitatea;

    public Produs(Long id_produse, String nume_produse, double pret, String brand, int cantitatea) {
        this.id_produse = id_produse;
        this.nume_produse = nume_produse;
        this.pret = pret;
        this.brand = brand;
        this.cantitatea = cantitatea;
    }

    public Produs(double pret) {
        this.pret = pret;
    }

    public Long getId_produse() {
        return id_produse;
    }

    public String getNume_produse() {
        return nume_produse;
    }

    public double getPret() {
        return pret;
    }

    public String getBrand() {
        return brand;
    }

    public int getCantitatea() {
        return cantitatea;
    }
}
