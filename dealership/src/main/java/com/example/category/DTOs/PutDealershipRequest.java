package com.example.category.DTOs;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

/**
 * PUT character request. Contains only fields that can be set up byt the user while creating a new character.How
 * character is described is defined in {@link GetCharactersResponse.Character} and
 * {@link pl.edu.pg.eti.kask.rpg.creature.entity.Creature} classes.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PutDealershipRequest {

    /**
     * ID of the dealership.
     */
    private UUID id;

    /**
     * Name of the dealership.
     */
    private String name;

    /**
     * Location of the dealership.
     */
    private String location;




}
