package br.com.castro.msscbreweryclient.client;

import br.com.castro.msscbreweryclient.web.model.BeerDto;
import br.com.castro.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author Elias Castro em 08/11/2020
 */
@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {
        BeerDto dto = client.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void testSaveNewBeer(){
        //given
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();

        URI uri = client.saveNewBeer(beerDto);

        assertNotNull(uri);
        System.out.println("uri = " + uri.toString());
    }

    @Test
    void testUpdateBeer(){
        //given
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
        client.updateBeer(UUID.randomUUID(), beerDto);
    }

    @Test
    void testDeleteBeer() {
        client.deleteBeer(UUID.randomUUID());
    }

    @Test
    void testCustomerById(){
        CustomerDto customerDto = client.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDto);
    }

    @Test
    void testSaveNewCustomer(){
        //given
        CustomerDto customerDto = CustomerDto.builder().name("New Customer").build();
        URI uri = client.saveNewCustomer(customerDto);
        assertNotNull(uri);
    }

    @Test
    void testUpdateCustomer(){
        //given
        CustomerDto customerDto = CustomerDto.builder().name("New Customer").build();
        client.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void testDeleteCustomer(){
        client.deleteCustomer(UUID.randomUUID());
    }

}