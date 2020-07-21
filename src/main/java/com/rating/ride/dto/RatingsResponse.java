package com.rating.ride.dto;

import com.rating.ride.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RatingsResponse {
    private UserType userType;
    private Integer userId;
    private Integer rating;
}
