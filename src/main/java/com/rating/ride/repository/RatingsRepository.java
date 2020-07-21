package com.rating.ride.repository;

import com.rating.ride.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingsRepository extends JpaRepository<Rating, Integer> {

    Rating save(Rating rating);

    Rating findByOrOrderId(Integer orderId);

    List<Rating> findAllByCustomerId(Integer customerId);

    List<Rating> findAllByHostId(Integer hostId);

}
