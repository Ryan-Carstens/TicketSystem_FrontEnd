package ticketsystem.cput.ac.za.ticketsystem.services.Impl;


import ticketsystem.cput.ac.za.ticketsystem.repositories.RestAPILogin;
import ticketsystem.cput.ac.za.ticketsystem.repositories.rest.RestLoginAPI;
import ticketsystem.cput.ac.za.ticketsystem.services.LoginServices;

/**
 * Created by Enthused Dragon on 2015/09/22.
 */
public class LoginServiceImpl implements LoginServices {
    final RestAPILogin rest = new RestLoginAPI();

    @Override
    public boolean loginAdmin(String username, String password)
    {
        return rest.loginAdmin(username,password);
    }

//    @Override
//    public boolean loginUser(String username, String password)
//    {
//        return rest.loginUser(username,password);
//    }
}
