package sandu.md.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import sandu.md.demo.entity.Produs;
import sandu.md.demo.entity.User;

import java.util.List;

@Repository

public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> findAll(){
        List<User> usersList = jdbcTemplate.query(
                "SELECT * FROM users",
                (response, rowNumber) ->
                        new User(response.getLong("id"),
                                response.getString("login"),
                                response.getString("pasword"),
                                response.getString("email"),
                                response.getInt("phone"),
                                response.getDate("date_created"),
                                response.getDate("date_updated")));
        return usersList;
    }

    public User finfById(Long id) {
        User user = jdbcTemplate.queryForObject("SELECT * FROM users WHERE id = ? ",
                new Object[] {id},
                (response, rowNumber) ->
                        new User(response.getLong("id"),
                                response.getString("login"),
                                response.getString("pasword"),
                                response.getString("email"),
                                response.getInt("phone"),
                                response.getDate("date_created"),
                                response.getDate("date_updated")));
        return user;
    }

    public User finfByIdAndPhone(Long id, Integer phone) {
        User user = jdbcTemplate.queryForObject("SELECT * FROM users WHERE id = ? AND phone = ?",
                new Object[]{id, phone},
                (response, rowNumber) ->
                        new User(response.getLong("id"),
                                response.getString("login"),
                                response.getString("pasword"),
                                response.getString("email"),
                                response.getInt("phone"),
                                response.getDate("date_created"),
                                response.getDate("date_updated")));
        return user;
    }

    public void saveRequestBody(User user) {
        jdbcTemplate.update("INSERT INTO users (login, pasword, email, phone, date_created, date_updated) VALUES (?, ?, ?, ?, ?, ?)", user.getLogin(), user.getPasword(), user.getEmail(), user.getPhone(), user.getDate_created(),user.getDate_updated() );
    }
    public void update(Long id, User user) {
        jdbcTemplate.update("UPDATE  users SET login = ?, pasword = ?, email = ?, phone = ?, date_created = ?, date_updated = ? WHERE id = ?", user.getLogin(), user.getPasword(), user.getEmail(), user.getPhone(), user.getDate_created(),user.getDate_updated(),id);
    }


    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM users WHERE id = ?",id);
    }
}
