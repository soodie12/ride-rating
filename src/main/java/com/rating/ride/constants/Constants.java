package com.rating.ride.constants;

public final class Constants {

    public static final class Urls {
        public static final String RATING_BASE_URL = "/ratings";
        public static final String CREATE_RATING_REQUEST = "/create";
        public static final String GET_RATING_REQUEST = "/getAchievedRatingForOrder";
        public static final String UPDATE_RATING_REQUEST = "/updateRatingForOrder";
        public static final String AGGREGATE_RATING_REQUEST = "/getRatingForUser";
    }

    public static final class Messages {
        public static final String INVALID_USER_TYPE_ERROR = "User Type Invalid";
        public static final String GET_RATING_FAILURE = "Failed to fetch Ratings";
        public static final String GENERIC_SUCCESS_RESPONSE = "Success";

    }
}
