package com.majoapps.reservations.landon.data.respository;

import com.majoapps.reservations.landon.data.entity.Guest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long>, CrudRepository<Guest, Long> {
    //Guest findOne(Long id);
}