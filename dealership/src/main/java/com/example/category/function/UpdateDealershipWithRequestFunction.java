package com.example.category.function;

import com.example.category.entity.DealershipCategory;
import com.example.category.DTOs.PatchDealershipRequest;

import java.util.function.BiFunction;

public class UpdateDealershipWithRequestFunction implements BiFunction<DealershipCategory, PatchDealershipRequest, DealershipCategory> {

    @Override
    public DealershipCategory apply(DealershipCategory entity, PatchDealershipRequest request) {
        return DealershipCategory.builder()
                .id(entity.getId())
                .name(request.getName())
                .location(entity.getLocation())
                .build();
    }

}
