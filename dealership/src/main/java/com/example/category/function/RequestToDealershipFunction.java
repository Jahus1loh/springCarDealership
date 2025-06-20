package com.example.category.function;

import com.example.category.entity.DealershipCategory;
import org.springframework.stereotype.Component;
import com.example.category.DTOs.PutDealershipRequest;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToDealershipFunction implements BiFunction<UUID, PutDealershipRequest, DealershipCategory> {

    @Override
    public DealershipCategory apply(UUID id, PutDealershipRequest request) {
        return DealershipCategory.builder()
                .id(id)
                .name(request.getName())
                .location(request.getLocation())
                .build();
    }

}
