package sandu.md.demo.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sandu.md.demo.entity.Produs;
import sandu.md.demo.entity.User;
import sandu.md.demo.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserControler {

    @Autowired
    private UserRepository userRepository;


    @GetMapping
    public List<User> findAll() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        User user = userRepository.finfById(id);
        return user;
    }
    @GetMapping("/{id}/{phone}")
    public User findByIdAndPhone (@PathVariable Long id, @PathVariable Integer phone) {
        User user = userRepository.finfByIdAndPhone(id, phone);
        return user;
    }

    @PostMapping
    public void saveRequestBody(@RequestBody User user) {
        userRepository.saveRequestBody(user);
    }

    @PutMapping("/{id}")
    public void updater(@PathVariable Long id, @RequestBody User user) {
        userRepository.update(id,user);
    }

    @DeleteMapping("/{id}")
    public void deleter(@PathVariable Long id) {
        userRepository.delete(id);
    }

}
