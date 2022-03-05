package com.firmys.gameservice.api;

import com.firmys.gameservice.api.config.GameServicesConfig;
import com.firmys.gameservice.api.impl.InventoryClient;
import com.firmys.gameservice.inventory.impl.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest(classes = {
        GameServices.class,
        GameServicesConfig.class
},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("game-services")
public class ServicesApiIT {

    @Autowired
    InventoryClient inventoryClient;

    @Test
    void checkApi() {
        List<Item> items = inventoryClient.getAll();
        items.forEach(i -> {
            System.out.println(i.getName());
            System.out.println(i.getDescription());
            System.out.println(i.getSizeHeight());
            System.out.println(i.getSizeLength());
            System.out.println(i.getWeight());
            System.out.println(i.getId());

        });
    }

}
