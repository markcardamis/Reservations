package com.majoapps.reservations.landon.data.respository;

import com.majoapps.reservations.landon.data.entity.Guest;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends PagingAndSortingRepository<Guest, Long>, CrudRepository<Guest, Long> {
    //Guest findOne(Long id);
}