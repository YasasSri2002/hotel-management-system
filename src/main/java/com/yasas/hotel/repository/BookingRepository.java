package com.yasas.hotel.repository;

import com.yasas.hotel.entity.BookingEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.time.LocalDateTime;
import java.util.UUID;

public interface BookingRepository extends JpaRepository<BookingEntity, UUID> {
    @Query(
            value = """
        SELECT CASE
            WHEN COUNT(*) > 0 THEN 1
            ELSE 0
        END
        FROM booking b
        JOIN booking_rooms br ON b.booking_id = br.booking_id
        WHERE br.room_id = :roomId
          AND (:startDate <= b.ending_date_time AND :endDate >= b.starting_date_time)
        """,
            nativeQuery = true
    )
    Long roomNotAvailable(
            @Param("roomId") Long roomId,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );


}
