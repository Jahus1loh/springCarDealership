package com.example.category.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@Builder
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "dealerships")
@AllArgsConstructor
public class DealershipCategory implements Comparable<DealershipCategory>, Serializable {

    @EqualsAndHashCode.Include
    @Id
    private UUID id;

    @Column(unique = true)
    private String name;
    private String location;


    public DealershipCategory() {
    }

    @Override
    public int compareTo(DealershipCategory other) {
        return this.name.compareTo(other.name);
    }

}
