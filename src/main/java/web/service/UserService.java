package web.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import web.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    boolean addUser(User user);
    void editUser(User user);
    void deleteUser(long id);
    List<User> listUsers();
    User getUserById(long id);
    User getUserByEmail(String email);
}
