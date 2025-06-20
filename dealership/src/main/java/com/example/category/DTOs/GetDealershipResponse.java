package com.example.category.DTOs;

import com.example.category.entity.DealershipCategory;
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
 * GET profession response. Described details about selected profession. Can be used to present description while
 * character creation or on character's stat page. How profession is described is defined in
 * {@link DealershipCategory}.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetDealershipResponse {

    /**
     * Unique id identifying dealership.
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
