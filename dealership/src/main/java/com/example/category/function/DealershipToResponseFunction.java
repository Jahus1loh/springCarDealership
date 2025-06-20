package com.example.category.function;

import org.springframework.stereotype.Component;
import com.example.category.DTOs.GetDealershipResponse;
import com.example.category.entity.DealershipCategory;

import java.util.function.Function;

/**
 * Converts {@link DealershipCategory} to {@link GetDealershipResponse}.
 */
@Component
public class DealershipToResponseFunction implements Function<DealershipCategory, GetDealershipResponse> {

    @Override
    public GetDealershipResponse apply(DealershipCategory entity) {
        return GetDealershipResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .location(entity.getLocation())
                .build();
    }

}
