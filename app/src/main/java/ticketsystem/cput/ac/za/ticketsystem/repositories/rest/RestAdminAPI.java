package ticketsystem.cput.ac.za.ticketsystem.repositories.rest;

import android.util.Log;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import ticketsystem.cput.ac.za.ticketsystem.model.Admin;
import ticketsystem.cput.ac.za.ticketsystem.repositories.RestAPI;
import ticketsystem.cput.ac.za.ticketsystem.repositories.RestAPIAdmin;

/**
 * Created by Enthused Dragon on 2015/09/23.
 */
public class RestAdminAPI implements RestAPIAdmin {

    final String BASE_URL="http://ticketsystem2-ticketsys.rhcloud.com/api";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public String add(Admin entity){
        final String url = BASE_URL+"/admin/signup";
        HttpEntity<Admin> requestEntity = new HttpEntity<>(entity, requestHeaders);
        // result = "";
        //try {
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        //}catch(Exception e)
        //{
            //Log.d("DEBUG", e.getMessage() +" "+ result);
        //}
        return result;
    }
}
