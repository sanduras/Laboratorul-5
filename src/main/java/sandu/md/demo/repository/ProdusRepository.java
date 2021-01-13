package sandu.md.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import sandu.md.demo.entity.Produs;


import java.util.List;
import java.util.Objects;
@Repository
public class ProdusRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Produs> findAll(){
       List<Produs> produsList = jdbcTemplate.query(
               "SELECT * FROM produs",
               (response, rowNumber) ->
                new Produs(response.getLong("id_produse"),
                        response.getString("nume_produse"),
                        response.getDouble("pret"),
                        response.getString("brand"),
                        response.getInt("cantitatea")));
      return produsList;
    }

    public Produs finfById(Long id_produse) {
        Produs produs = jdbcTemplate.queryForObject("SELECT * FROM produs WHERE id_produse = ? ",
                new Object[] {id_produse},
                (response, rowNumber) ->
                        new Produs(response.getLong("id_produse"),
                                response.getString("nume_produse"),
                                response.getDouble("pret"),
                                response.getString("brand"),
                                response.getInt("cantitatea")));
        return produs;
    }

    public Produs finfByIdAndName(Long id_produse,String nume_produse) {
        Produs produs = jdbcTemplate.queryForObject("SELECT * FROM produs WHERE id_produse = ? AND nume_produse = ?",
                new Object[] {id_produse, nume_produse},
                (response, rowNumber) ->
                        new Produs(response.getLong("id_produse"),
                                response.getString("nume_produse"),
                                response.getDouble("pret"),
                                response.getString("brand"),
                                response.getInt("cantitatea")));
        return produs;
    }
   /* public Produs finfByIdAndPrice(Long id_produse,Double pret) {
        Produs products = jdbcTemplate.queryForObject("SELECT pret FROM produs WHERE id_produse = ? AND pret = ?",
                new Object[] {id_produse, pret},
                (response, rowNumber) ->
                        new Produs(response.getDouble("pret")));
        return products;
    }*/

    public void saveRequestParam(String nume_produse, Double pret, String brand, Integer cantitatea) {
        jdbcTemplate.update("INSERT INTO produs (nume_produse, pret, brand, cantitatea) VALUES (?, ?, ?, ?)", nume_produse, pret, brand, cantitatea);
    }

    public void savePathVariable(String nume_produse, Double pret, String brand, Integer cantitatea) {
        jdbcTemplate.update("INSERT INTO produs (nume_produse, pret, brand, cantitatea) VALUES (?, ?, ?, ?)", nume_produse, pret, brand, cantitatea);
    }

    public void saveRequestBody(Produs produs) {
        jdbcTemplate.update("INSERT INTO produs (nume_produse, pret, brand, cantitatea) VALUES (?, ?, ?, ?)", produs.getNume_produse(), produs.getPret(), produs.getBrand(), produs.getCantitatea());
    }

    public void update(Long id_produse, Produs produs) {
        jdbcTemplate.update("UPDATE  produs SET nume_produse = ?, pret = ?, brand = ?, cantitatea = ? WHERE id_produse = ?", produs.getNume_produse(), produs.getPret(), produs.getBrand(), produs.getCantitatea(), id_produse );
    }

    public void delete(Long id_produse) {
        jdbcTemplate.update("DELETE FROM produs WHERE id_produse = ?",id_produse);

    }


}