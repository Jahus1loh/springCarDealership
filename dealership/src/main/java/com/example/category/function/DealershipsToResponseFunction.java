package com.example.category.function;

import org.springframework.stereotype.Component;
import com.example.category.entity.DealershipCategory;
import com.example.category.DTOs.GetDealershipsResponse;

import java.util.List;
import java.util.function.Function;

/**
 * Converts {@link List< DealershipCategory >} to {@link GetDealershipsResponse}.
 */
@Component
public class DealershipsToResponseFunction implements Function<List<DealershipCategory>, GetDealershipsResponse> {

    @Override
    public GetDealershipsResponse apply(List<DealershipCategory> entities) {
        return GetDealershipsResponse.builder()
                .dealerships(entities.stream()
                        .map(dealership -> GetDealershipsResponse.Dealership.builder()
                                .id(dealership.getId())
                                .name(dealership.getName())
                                .location(dealership.getLocation())
                                .build())
                        .toList())
                .build();
    }

}
