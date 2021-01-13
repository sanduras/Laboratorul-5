package sandu.md.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@ToString
@Setter
@Getter
@AllArgsConstructor



public class Comanda {
    private Long id_comanda;
    private Date data_cumpararii;
    private int cantitate;
    private double suma;
    private Long id_users;
    private Long  id_produse;

    public Comanda(Long id_comanda, Date data_cumpararii, int cantitate, double suma, Long id_users, Long  id_produse) {
        this.id_comanda = id_comanda;
        this.data_cumpararii = data_cumpararii;
        this.cantitate = cantitate;
        this.suma = suma;
        this.id_users = id_users;
        this.id_produse = id_produse;
    }


    public Long getId_comanda() {
        return id_comanda;
    }

    public Date getData() {
        return data_cumpararii;
    }

    public int getCantitate() {
        return cantitate;
    }

    public double getSuma() {
        return suma;
    }

    public Long getId_users() {
        return id_users;
    }

    public Long getId_produse() {
        return id_produse;
    }

    public void setId_comanda(Long id_comanda) {
        this.id_comanda = id_comanda;
    }

    public void setData(Date data) {
        this.data_cumpararii = data;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    public void setId_users(Long id_users) {
        this.id_users = id_users;
    }

    public void setId_produse(Long id_produse) {
        this.id_produse = id_produse;
    }
}

