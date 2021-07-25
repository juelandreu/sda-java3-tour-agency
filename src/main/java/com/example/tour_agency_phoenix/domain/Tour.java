package com.example.tour_agency_phoenix.domain;

import com.example.tour_agency_phoenix.utils.TransportType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ta_tour")
public class Tour {
    @Id
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    protected UUID id;

    protected String name;
    @Enumerated(value = EnumType.STRING)
    protected TransportType transport;

    protected double price;
    protected int duration;
    protected String image;
    protected boolean sale = false;
    protected double salePrice;
    protected LocalDateTime saleStartAt;
    protected LocalDateTime saleEndAt;
    protected Integer reservations;

    protected boolean featured = false;
    protected String featuredImage;

    protected LocalDateTime createdAt;
}
