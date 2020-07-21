package com.rating.ride.dao.impl;

import com.rating.ride.dao.IRatingsDao;
import com.rating.ride.entity.Rating;
import com.rating.ride.repository.RatingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingsDao implements IRatingsDao {

    @Autowired
    private RatingsRepository ratingsRepository;

    public Rating getRatingByOrderId(Integer orderId) {
        return ratingsRepository.findByOrOrderId(orderId);
    }

    @Override
    public Rating saveRatings(Rating rating) {
        return ratingsRepository.save(rating);
    }

    public List<Rating> getAllRatingsByCustomerId(Integer customerId) {
        return ratingsRepository.findAllByCustomerId(customerId);
    }

    public List<Rating> getAllRatingsByHostId(Integer hostId) {
        return ratingsRepository.findAllByHostId(hostId);
    }
}
