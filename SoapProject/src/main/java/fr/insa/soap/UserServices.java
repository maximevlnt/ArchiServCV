package fr.insa.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface UserServices {

    @WebMethod
    List<User> getUsers();

    @WebMethod
    User getUserById(int id);
    
    @WebMethod
    String addUser(String username, String email);  // New method to add a user
}