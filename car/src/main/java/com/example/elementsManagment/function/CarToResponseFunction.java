package com.example.elementsManagment.function;

import com.example.elementsManagment.entity.CarElement;
import org.springframework.stereotype.Component;
import com.example.elementsManagment.DTOs.GetCarResponse;

import java.util.function.Function;

/**
 * Converts {@link CarElement} to {@link GetCarResponse}.
 */
@Component
public class CarToResponseFunction implements Function<CarElement, GetCarResponse> {

    @Override
    public GetCarResponse apply(CarElement entity) {
        return GetCarResponse.builder()
                .id(entity.getId())
                .brandName(entity.getBrandName())
                .modelName(entity.getModelName())
                .country(entity.getCountry())
                .productionYear(entity.getProductionYear())
                .price(entity.getPrice())
                .dealership(entity.getDealership())
                .build();
    }

}
