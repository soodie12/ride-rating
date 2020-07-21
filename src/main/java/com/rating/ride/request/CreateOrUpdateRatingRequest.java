package com.rating.ride.request;

import com.rating.ride.entity.User;
import com.rating.ride.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrUpdateRatingRequest {
    private Integer orderId;
    private User user;
    private UserType userType;
    private Integer rating;
}
