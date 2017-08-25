package ie.citadel.pupils.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import ie.citadel.pupils.model.Address;

@Component
public class AddressRestTemplateClient {
    @Autowired
    RestTemplate restTemplate;

    public Address getAddressFromEircode(String eircode){
        ResponseEntity<Address> restExchange =
                restTemplate.exchange(
                        "http://addressservice/v1/addresses/{eircode}",
                        HttpMethod.GET,
                        null, Address.class, eircode);

        return restExchange.getBody();
    }
}
