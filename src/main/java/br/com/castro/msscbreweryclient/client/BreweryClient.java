package br.com.castro.msscbreweryclient.client;

import br.com.castro.msscbreweryclient.web.model.BeerDto;
import br.com.castro.msscbreweryclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

/**
 * @Author Elias Castro em 08/11/2020
 */

@Component
@ConfigurationProperties(value = "castro.brewery", ignoreUnknownFields = false)
public class BreweryClient {

    public final String BEER_PATH_V1 = "/api/v1/beer/";
    public final String CUSTOMER_PATH_V1 = "/api/v1/beer/";

    private String apihost;

    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    //GET
    public BeerDto getBeerById(UUID uuid){
        return restTemplate.getForObject(apihost + BEER_PATH_V1 +  uuid.toString(), BeerDto.class);
    }

    //POST
    public URI saveNewBeer(BeerDto beerDto){
        return restTemplate.postForLocation(apihost + BEER_PATH_V1, beerDto);
    }

    //PUT
    public void updateBeer(UUID uuid, BeerDto beerDto){
        restTemplate.put(apihost + BEER_PATH_V1 + "/" + uuid.toString(), beerDto);
    }

    public void deleteBeer(UUID uuid){
        restTemplate.delete(apihost + BEER_PATH_V1 + "/" + uuid);
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }

    public CustomerDto getCustomerById(UUID customerId) {
        return restTemplate.getForObject(apihost + CUSTOMER_PATH_V1 +  customerId.toString(), CustomerDto.class);
    }

    public URI saveNewCustomer(CustomerDto customerDto) {
        return restTemplate.postForLocation(apihost + CUSTOMER_PATH_V1, customerDto);
    }

    public void updateCustomer(UUID randomUUID, CustomerDto customerDto) {
    }

    public void deleteCustomer(UUID randomUUID) {
    }
}
