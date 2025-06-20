package com.example.category.DTOs;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

/**
 * GET professions response. Returns list of all available professions names.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetDealershipsResponse {

    /**
     * Represents single profession in list.
     */
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Dealership {

        /**
         * Unique id identifying profession.
         */
        private UUID id;

        /**
         * Name of the profession.
         */
        private String name;

        /**
         * Location of the dealership.
         */
        private String location;

    }

    /**
     * List of all professions.
     */
    private List<Dealership> dealerships;

}
