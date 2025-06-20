package com.example.elementsManagment.function;

import com.example.elementsManagment.entity.CarElement;
import org.springframework.stereotype.Component;
import com.example.elementsManagment.DTOs.GetCarsResponse;

import java.util.List;
import java.util.function.Function;

/**
 * Converts {@link List< CarElement >} to {@link GetCarsResponse}.
 */
@Component
public class CarsToResponseFunction implements Function<List<CarElement>, GetCarsResponse> {

    @Override
    public GetCarsResponse apply(List<CarElement> entities) {
        return GetCarsResponse.builder()
                .cars(entities.stream()
                        .map(car -> GetCarsResponse.Car.builder()
                                .id(car.getId())
                                .brandName(car.getBrandName())
                                .modelName(car.getModelName())
                                .country(car.getCountry())
                                .productionYear(car.getProductionYear())
                                .price(car.getPrice())
                                .dealership(car.getDealership())
                                .build())
                        .toList())
                .build();
    }

}
