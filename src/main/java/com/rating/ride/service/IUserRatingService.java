package com.rating.ride.service;

import com.rating.ride.dto.RatingsResponse;
import com.rating.ride.request.CreateOrUpdateRatingRequest;
import com.rating.ride.request.GetAggregatedRatingRequest;
import com.rating.ride.request.GetRatingRequest;
import com.rating.ride.response.GenericApiResponse;

public interface IUserRatingService {

    GenericApiResponse<String> createRatingForOrder(CreateOrUpdateRatingRequest request);

    GenericApiResponse<RatingsResponse> getAchievedRatingForOrder(GetRatingRequest request);

    GenericApiResponse<String> updateRatingForOrder(CreateOrUpdateRatingRequest request);

    GenericApiResponse<RatingsResponse> getAggregateRatingForUser(GetAggregatedRatingRequest request);
}
