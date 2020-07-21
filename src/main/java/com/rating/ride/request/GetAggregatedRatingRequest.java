package com.rating.ride.request;

import com.rating.ride.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAggregatedRatingRequest {
    private Integer userId;
    private UserType userType;
}
