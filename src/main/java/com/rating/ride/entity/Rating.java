package com.rating.ride.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "ratings")
@Data
@Builder
public class Rating {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "host_id")
    private Integer hostId;

    @Column(name = "customer_rating")
    private Integer customerRating;

    @Column(name = "host_rating")
    private Integer hostRating;
}
