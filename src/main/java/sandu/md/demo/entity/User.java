package sandu.md.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor

public class User {
    private Long id;
    private String login;
    private String pasword;
    private String email;
    private Integer phone;
    private Date date_created;
    private Date date_updated;

}

