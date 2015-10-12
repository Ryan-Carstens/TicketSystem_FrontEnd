package ticketsystem.cput.ac.za.ticketsystem.repositories.rest;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import ticketsystem.cput.ac.za.ticketsystem.model.Admin;
import ticketsystem.cput.ac.za.ticketsystem.repositories.RestAPILogin;

/**
 * Created by Enthused Dragon on 2015/09/22.
 */
public class RestLoginAPI implements RestAPILogin {
    final String BASE_URL="http://collectorsitems-enthuseddragon.rhcloud.com/api";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public boolean loginAdmin(String Customername, String password) {
        final String url = BASE_URL+"admin/"+"login/";
        HttpEntity<Admin> requestEntity = new HttpEntity<Admin>(requestHeaders);
        try {
            ResponseEntity<Admin> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Admin.class);
            Admin admin = responseEntity.getBody();

            if (admin != null)
                return false;
            else
                return true;
        }catch (Exception e)
        {
            return false;
        }
    }


}
