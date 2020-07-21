package com.rating.ride.service.impl;

import com.rating.ride.constants.Constants;
import com.rating.ride.dao.IRatingsDao;
import com.rating.ride.dto.RatingsResponse;
import com.rating.ride.entity.Rating;
import com.rating.ride.enums.UserType;
import com.rating.ride.request.*;
import com.rating.ride.response.GenericApiResponse;
import com.rating.ride.service.IUserRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service("customerRatingService")
public class CustomerRatingServiceImpl implements IUserRatingService {

    @Autowired
    private IRatingsDao ratingsDao;

    @Override
    public GenericApiResponse<String> createRatingForOrder(CreateOrUpdateRatingRequest request) {
        Rating existingRating = ratingsDao.getRatingByOrderId(request.getOrderId());
        if(Objects.nonNull(existingRating)) return updateExistingRatings(request, existingRating);
        Rating newRating = Rating.builder()
                .orderId(request.getOrderId())
                .customerId(request.getUser().getId())
                .customerRating(request.getRating())
                .build();
        ratingsDao.saveRatings(newRating);
        return new GenericApiResponse<>(null, true, Constants.Messages.GENERIC_SUCCESS_RESPONSE);
    }

    @Override
    public GenericApiResponse<RatingsResponse> getAchievedRatingForOrder(GetRatingRequest request) {
        Rating presentRatingForOrder = ratingsDao.getRatingByOrderId(request.getOrderId());
        RatingsResponse ratingsResponse = RatingsResponse.builder()
                .rating(presentRatingForOrder.getHostRating())
                .userType(UserType.CUSTOMER)
                .userId(presentRatingForOrder.getCustomerId())
                .build();
        return Objects.nonNull(ratingsResponse) ? new GenericApiResponse<>(ratingsResponse, true, Constants.Messages.GENERIC_SUCCESS_RESPONSE) : new GenericApiResponse<>(null, false, Constants.Messages.GET_RATING_FAILURE);
    }

    @Override
    public GenericApiResponse<String> updateRatingForOrder(CreateOrUpdateRatingRequest request) {
        Rating existingRating = ratingsDao.getRatingByOrderId(request.getOrderId());
        return updateExistingRatings(request, existingRating);
    }

    @Override
    public GenericApiResponse<RatingsResponse> getAggregateRatingForUser(GetAggregatedRatingRequest request) {
        List<Rating> ratingsPresentForUser = ratingsDao.getAllRatingsByCustomerId(request.getUserId());
        Integer averageRatingByHost = ratingsPresentForUser.stream().mapToInt(Rating::getHostRating).sum()/ratingsPresentForUser.size();
        RatingsResponse ratingsResponse = RatingsResponse.builder()
                .rating(averageRatingByHost)
                .userType(UserType.CUSTOMER)
                .userId(request.getUserId())
                .build();
        return Objects.nonNull(ratingsResponse) ? new GenericApiResponse<>(ratingsResponse, true, Constants.Messages.GENERIC_SUCCESS_RESPONSE) : new GenericApiResponse<>(null, false, Constants.Messages.GET_RATING_FAILURE);
    }

    private GenericApiResponse<String> updateExistingRatings(CreateOrUpdateRatingRequest request, Rating rating) {
        rating.setCustomerRating(request.getRating());
        rating.setCustomerId(request.getUser().getId());
        ratingsDao.saveRatings(rating);
        return new GenericApiResponse<>(null, true, Constants.Messages.GENERIC_SUCCESS_RESPONSE);
    }
}
