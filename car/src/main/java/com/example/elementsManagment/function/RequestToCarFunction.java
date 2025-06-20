package com.example.elementsManagment.function;

import org.springframework.stereotype.Component;
//import pl.edu.pg.eti.kask.rpg.profession.entity.Profession;
import com.example.elementsManagment.DTOs.PutCarRequest;
import com.example.elementsManagment.entity.CarElement;

import java.util.UUID;
import java.util.function.BiFunction;

/**
 * Converts {@link PutCarRequest} to {@link CarElement}. Caution, some fields are not set as they should be updated
 * by business logic.
 */
@Component
public class RequestToCarFunction implements BiFunction<UUID, PutCarRequest, CarElement> {

    @Override
    public CarElement apply(UUID id, PutCarRequest request) {
        return CarElement.builder()
                .id(id)
                .brandName(request.getBrandName())
                .modelName(request.getModelName())
                .country(request.getCountry())
                .productionYear(request.getProductionYear())
                .price(request.getPrice())
                .dealership(request.getDealership())
                .build();
    }

}
