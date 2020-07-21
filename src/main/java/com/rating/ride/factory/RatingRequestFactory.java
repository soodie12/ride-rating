package com.rating.ride.factory;

import com.rating.ride.enums.UserType;
import com.rating.ride.service.IUserRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RatingRequestFactory {

    @Autowired
    @Qualifier("customerRatingService")
    private IUserRatingService customerRatingService;


    @Autowired
    @Qualifier("hostRatingService")
    private IUserRatingService hostRatingService;

    public IUserRatingService getUserRatingService(UserType userType) {
        if(userType.equals(UserType.CUSTOMER)) return customerRatingService;
        else if (userType.equals(UserType.HOST)) return hostRatingService;
        else return null;
    }
}
