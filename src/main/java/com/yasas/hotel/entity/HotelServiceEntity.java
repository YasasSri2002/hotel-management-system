package com.yasas.hotel.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="Services")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class HotelServiceEntity {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    @Column(name = "services_id")
    private UUID id;

    private String name;

    private String description;

    private Double price;

    @ManyToMany(mappedBy = "services", cascade = CascadeType.PERSIST , fetch = FetchType.LAZY)
    private Set<BookingEntity> bookings;

}
