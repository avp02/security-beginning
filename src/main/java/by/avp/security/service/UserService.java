package by.avp.security.service;

import by.avp.security.model.User;

public interface UserService {

    void saveUser(User user);

    User findByUserName(String userName);
}
