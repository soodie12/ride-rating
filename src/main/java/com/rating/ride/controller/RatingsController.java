package com.rating.ride.controller;

import com.rating.ride.constants.Constants;
import com.rating.ride.factory.RatingRequestFactory;
import com.rating.ride.request.*;
import com.rating.ride.response.GenericApiResponse;
import com.rating.ride.dto.RatingsResponse;
import com.rating.ride.service.IUserRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping(value = Constants.Urls.RATING_BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RatingsController {

    @Autowired
    private RatingRequestFactory ratingRequestFactory;

    @RequestMapping(value = Constants.Urls.CREATE_RATING_REQUEST, method = RequestMethod.POST)
    public GenericApiResponse<String> createRatingForOrder(CreateOrUpdateRatingRequest request) {
        IUserRatingService userRatingService = ratingRequestFactory.getUserRatingService(request.getUserType());
        return Objects.nonNull(userRatingService) ? userRatingService.createRatingForOrder(request) : new GenericApiResponse(null, false, Constants.Messages.INVALID_USER_TYPE_ERROR);
    }

    @RequestMapping(value = Constants.Urls.GET_RATING_REQUEST, method = RequestMethod.POST)
    public GenericApiResponse<RatingsResponse> getAchievedRatingForOrder(GetRatingRequest request) {
        IUserRatingService userRatingService = ratingRequestFactory.getUserRatingService(request.getUserType());
        return Objects.nonNull(userRatingService) ? userRatingService.getAchievedRatingForOrder(request) : new GenericApiResponse(null, false, Constants.Messages.INVALID_USER_TYPE_ERROR);
    }

    @RequestMapping(value = Constants.Urls.UPDATE_RATING_REQUEST, method = RequestMethod.POST)
    public GenericApiResponse<String> updateRatingForOrder(CreateOrUpdateRatingRequest request) {
        IUserRatingService userRatingService = ratingRequestFactory.getUserRatingService(request.getUserType());
        return Objects.nonNull(userRatingService) ? userRatingService.updateRatingForOrder(request) : new GenericApiResponse(null, false, Constants.Messages.INVALID_USER_TYPE_ERROR);
    }

    @RequestMapping(value = Constants.Urls.AGGREGATE_RATING_REQUEST, method = RequestMethod.POST)
    public GenericApiResponse<RatingsResponse> getAggregateRatingForUser(GetAggregatedRatingRequest request) {
        IUserRatingService userRatingService = ratingRequestFactory.getUserRatingService(request.getUserType());
        return Objects.nonNull(userRatingService) ? userRatingService.getAggregateRatingForUser(request) : new GenericApiResponse(null, false, Constants.Messages.INVALID_USER_TYPE_ERROR);
    }
}
