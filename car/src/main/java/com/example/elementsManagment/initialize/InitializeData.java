package com.example.elementsManagment.initialize;

import com.example.category.entity.DealershipCategory;
import com.example.category.service.DealershipService;
import com.example.elementsManagment.entity.CarElement;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.elementsManagment.service.CarDefaultService;

import java.util.UUID;

/**
 * Listener started automatically on Spring application context initialized. When using persistence storage application
 * instance should be initialized only during first run in order to init database with starting data. Good place to
 * create first default admin user.
 */
@Component("elementInitializeData")
public class InitializeData implements InitializingBean {

    /**
     * Service for professions operations.
     */
    private final CarDefaultService carService;
    private final DealershipService dealershipService;

    /**
     * @param carService service for managing professions
     */
    @Autowired
    public InitializeData(CarDefaultService carService, DealershipService dealershipService) {
        this.carService = carService;
        this.dealershipService = dealershipService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (carService.findAll().isEmpty()) {

            DealershipCategory dealershipCategory1 = DealershipCategory.builder()
                    .id(UUID.fromString("2d9b1e8c-67c5-4188-a911-5f064a63d8cd"))
                    .name("AutoHub")
                    .location("Gdansk")
                    .build();

            DealershipCategory dealershipCategory2 = DealershipCategory.builder()
                    .id(UUID.fromString("5d1da2ae-6a14-4b6d-8b4f-d117867118d4"))
                    .name("CarZone")
                    .location("Gdynia")
                    .build();

            DealershipCategory dealershipCategory3 = DealershipCategory.builder()
                    .id(UUID.fromString("f5875513-bf7b-4ae1-b8a5-5b70a1b90e76"))
                    .name("Auto Top")
                    .location("Gdansk")
                    .build();

            DealershipCategory dealershipCategory4 = DealershipCategory.builder()
                    .id(UUID.fromString("f8c3de3d-1fea-4d7c-a8b0-29f63c4c3454"))
                    .name("Skup Aut")
                    .location("Sopot")
                    .build();

            dealershipService.create(dealershipCategory1);
            dealershipService.create(dealershipCategory2);
            dealershipService.create(dealershipCategory3);
            dealershipService.create(dealershipCategory4);


            CarElement audi = CarElement.builder()
                    .id(UUID.fromString("a2b3c4d5-e6f7-4890-9123-456789abcdef"))
                    .brandName("Audi")
                    .modelName("A3")
                    .country("Germany")
                    .productionYear(2022)
                    .price(100000)
                    .dealership(dealershipCategory1)
                    .build();

            CarElement tesla = CarElement.builder()
                    .id(UUID.fromString("b0445570-b8a8-4b10-8331-3ac0dee798b5"))
                    .brandName("Tesla")
                    .modelName("Model 3")
                    .country("USA")
                    .productionYear(2020)
                    .price(95000)
                    .dealership(dealershipCategory2)
                    .build();

            CarElement bmw = CarElement.builder()
                    .id(UUID.fromString("b5459e15-a617-4bce-8e11-73ee27d256ea"))
                    .brandName("BMW")
                    .modelName("M5")
                    .country("Germany")
                    .productionYear(2019)
                    .price(80000)
                    .dealership(dealershipCategory3)
                    .build();

            CarElement mercedes = CarElement.builder()
                    .id(UUID.fromString("78710e25-4f56-4290-8e60-0c5a3d0e9f0e"))
                    .brandName("Mercedes")
                    .modelName("GLC")
                    .country("Germany")
                    .productionYear(2024)
                    .price(150000)
                    .dealership(dealershipCategory4)
                    .build();

            CarElement fiat = CarElement.builder()
                    .id(UUID.randomUUID())
                    .brandName("Fiat")
                    .modelName("Panda")
                    .country("Italy")
                    .productionYear(2015)
                    .price(30000)
                    .dealership(dealershipCategory4)
                    .build();

            carService.create(audi);
            carService.create(tesla);
            carService.create(bmw);
            carService.create(mercedes);
            carService.create(fiat);
        }
    }

}
