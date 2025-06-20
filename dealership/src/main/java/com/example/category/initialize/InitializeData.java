package com.example.category.initialize;

import com.example.category.entity.DealershipCategory;
import com.example.category.service.DealershipService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component("categoryInitializeData")
public class InitializeData implements InitializingBean {

    /**
     * Service for dealership operations.
     */
    private final DealershipService dealershipService;

    /**
     * @param dealershipService service for managing professions
     */
    @Autowired
    public InitializeData(DealershipService dealershipService) {
        this.dealershipService = dealershipService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (dealershipService.findAll().isEmpty()) {
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
        }
    }

}
