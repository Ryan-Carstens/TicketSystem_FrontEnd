package ticketsystem.cput.ac.za.ticketsystem.services.Impl;

import ticketsystem.cput.ac.za.ticketsystem.model.Admin;
import ticketsystem.cput.ac.za.ticketsystem.repositories.RestAPI;
import ticketsystem.cput.ac.za.ticketsystem.repositories.RestAPIAdmin;
import ticketsystem.cput.ac.za.ticketsystem.repositories.rest.RestAdminAPI;
import ticketsystem.cput.ac.za.ticketsystem.services.AdminServices;

/**
 * Created by sanXion on 2015/09/27.
 */
public class AdminServicesImpl implements AdminServices {

    final RestAPIAdmin rest = new RestAdminAPI();

    @Override
    public String addAdmin(Admin entity){
        return rest.add(entity);
    }
}
