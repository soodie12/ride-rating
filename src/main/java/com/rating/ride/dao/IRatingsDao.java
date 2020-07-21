package com.rating.ride.dao;

import com.rating.ride.entity.Rating;

import java.util.List;

public interface IRatingsDao {

    Rating getRatingByOrderId(Integer orderId);

    Rating saveRatings(Rating rating);

    List<Rating> getAllRatingsByCustomerId(Integer customerId);

    List<Rating> getAllRatingsByHostId(Integer hostId);
}
