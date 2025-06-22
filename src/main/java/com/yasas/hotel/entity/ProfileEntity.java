package com.yasas.hotel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name="profile")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileEntity {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @Column(name="profile_Id")
    private UUID id;

    private String profilePicUrl;

}
