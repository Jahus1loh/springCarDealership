package com.example.elementsManagment.entity;

import com.example.category.entity.DealershipCategory;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@Builder
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "cars")
public class CarElement implements Comparable<CarElement>, Serializable {

    public CarElement() {
    }

    public CarElement(UUID id, String brandName, String modelName, String country, int year, int price, DealershipCategory dealershipID) {
        this.id = id;
        this.brandName = brandName;
        this.modelName = modelName;
        this.country = country;
        this.productionYear = year;
        this.price = price;
        this.dealership = dealershipID;
    }

    @EqualsAndHashCode.Include
    @Id
    private UUID id;

    @Column(name = "brand_name", nullable = false)
    private String brandName;

    @Column(name = "model_name", nullable = false)
    private String modelName;
    private String country;

    @Column(name = "production_year", nullable = false)
    private int productionYear;
    private int price;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dealership")
    private DealershipCategory dealership;

    public int compareTo(CarElement o) {
        return this.modelName.compareTo(o.modelName);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brandName + '\'' +
                ", model='" + modelName + '\'' +
                ", country='" + country + '\'' +
                ", productionYear=" + productionYear +
                ", price=" + price +
                ", dealershipId=" + (dealership) +
                '}';
    }

}
