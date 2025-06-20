package com.example.elementsManagment.controller.impl;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import com.example.elementsManagment.service.CarService;
import com.example.elementsManagment.function.CarToResponseFunction;
import com.example.elementsManagment.function.CarsToResponseFunction;
import com.example.elementsManagment.DTOs.GetCarsResponse;
import com.example.elementsManagment.DTOs.GetCarResponse;
import com.example.elementsManagment.DTOs.PutCarRequest;
import com.example.elementsManagment.entity.CarElement;
import com.example.elementsManagment.controller.api.CarController;
import com.example.elementsManagment.function.RequestToCarFunction;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;

/**
 * Controller for character resource. It does not return or receive entity objects but dto objects which present only
 * those fields which are used in communication with client.
 */
@RestController
@Log
public class CarDefaultController implements CarController {

    /**
     * Service for managing characters.
     */
    private final CarService service;

    /**
     * Converts {@link CarElement} to {@link GetCarResponse}.
     */
    private final CarToResponseFunction characterToResponse;

    /**
     * Coverts {@link List <Car>} to {@link GetCarsResponse}.
     */
    private final CarsToResponseFunction charactersToResponse;

    /**
     * Converts {@link PutCarRequest} to {@link CarElement}.
     */
    private final RequestToCarFunction requestToCar;

    /**
     * @param service              service for managing characters
     * @param characterToResponse  converts {@link CarElement} to {@link GetCarResponse}
     * @param charactersToResponse coverts {@link List <Car>} to {@link GetCarsResponse}
     * @param requestToCar   converts {@link PutCarRequest} to {@link CarElement}
     */
    @Autowired
    public CarDefaultController(
            CarService service,
            CarToResponseFunction characterToResponse,
            CarsToResponseFunction charactersToResponse,
            RequestToCarFunction requestToCar
    ) {
        this.service = service;
        this.characterToResponse = characterToResponse;
        this.charactersToResponse = charactersToResponse;
        this.requestToCar = requestToCar;
    }

    @Override
    public GetCarsResponse getCars() {
        return charactersToResponse.apply(service.findAll());
    }

    @Override
    public GetCarsResponse getDealershipCars(UUID dealershipId) {
        return service.findAllByDealership(dealershipId)
                .map(charactersToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetCarResponse getCar(UUID id) {
        return service.find(id)
                .map(characterToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetCarResponse getDealershipCar(UUID userId, UUID characterId) {
        return null;
    }

    @Override
    public void putCar(UUID id, PutCarRequest request) {
        service.create(requestToCar.apply(id, request));
    }

    @Override
    public void deleteCar(UUID id) {
        service.find(id)
                .ifPresentOrElse(
                        character -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

    @Override
    public void putDealershipCar(UUID dealershipId, UUID carId, PutCarRequest request) {
        service.findDealership(dealershipId)
                .ifPresentOrElse(
                        dealership -> {
                            CarElement carElement = new CarElement(
                                    carId,
                                    request.getBrandName(),
                                    request.getModelName(),
                                    request.getCountry(),
                                    request.getProductionYear(),
                                    request.getPrice(),
                                    dealership
                            );
                            service.create(carElement);
                        },
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Dealership not found");
                        }
                );
    }

    @Override
    public void deleteDealershipCar(UUID dealershipId, UUID carId) {
        service.findAllByDealership(dealershipId)
                .flatMap(cars -> cars.stream()
                        .filter(car -> car.getId().equals(carId))
                        .findFirst()
                )
                .ifPresentOrElse(
                        car -> service.delete(carId),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Car not found in dealership");
                        }
                );
    }


}
