package by.avp.security.service;

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
