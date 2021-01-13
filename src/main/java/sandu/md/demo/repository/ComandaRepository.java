package sandu.md.demo.repository;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import sandu.md.demo.entity.Comanda;
import sandu.md.demo.entity.Produs;

import java.util.Date;
import java.util.List;

@Repository
public class ComandaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Comanda> findAll(){
        List<Comanda> comandaList = jdbcTemplate.query(
                "SELECT * FROM comanda",
                (response, rowNumber) ->
                        new Comanda(response.getLong("id_comanda"),
                                response.getDate("data_cumpararii"),
                                response.getInt("cantitate"),
                                response.getDouble("suma"),
                                response.getLong("id_users"),
                                response.getLong("id_produse")));
        return comandaList;
    }

    public Comanda finfByIdAndSum(Long id_comanda, Double suma) {
        Comanda comanda = jdbcTemplate.queryForObject("SELECT * FROM comanda WHERE id_comanda = ? AND suma = ?;",
                new Object[] {id_comanda, suma},
                (response, rowNumber) ->
                        new Comanda(response.getLong("id_comanda"),
                                response.getDate("data_cumpararii"),
                                response.getInt("cantitate"),
                                response.getDouble("suma"),
                                response.getLong("id_users"),
                                response.getLong("id_produse")));
        return comanda;
    }

    public void saveRequestParam(Date data_cumpararii, Integer cantitate, Double suma, Long id_users, Long id_produse) {
        jdbcTemplate.update("INSERT INTO comanda (data_cumpararii, cantitate, suma, id_users, id_produse) VALUES (?, ?, ?, ?, ?)", data_cumpararii, cantitate, suma ,id_users, id_produse );

    }


    public void saveRequestBody(Comanda comanda) {
        jdbcTemplate.update("INSERT INTO comanda (data_cumpararii, cantitate, suma, id_users, id_produse) VALUES (?, ?, ?, ?, ?)", comanda.getData(), comanda.getCantitate(), comanda.getSuma(), comanda.getId_users(), comanda.getId_produse());
    }

    public void update(Long id_comanda, Comanda comanda) {
        jdbcTemplate.update("UPDATE  comanda SET data_cumpararii = ?, cantitate = ?, suma = ?, id_users = ?,id_produse = ? WHERE id_comanda = ?", comanda.getData(), comanda.getCantitate(), comanda.getSuma(), comanda.getId_users(), comanda.getId_produse(), id_comanda );
    }

    public void delete(Long id_comanda) {
        jdbcTemplate.update("DELETE FROM comanda WHERE id_comanda = ?",id_comanda);

    }
}
