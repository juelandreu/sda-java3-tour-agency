package com.example.tour_agency_phoenix.domain;

import com.example.tour_agency_phoenix.utils.BookStatus;
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
@Table(name = "ta_book")
public class Book {
    @Id
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    protected UUID id;

    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(name = "user_id")
    protected UUID userId;

    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(name = "tour_id")
    protected UUID tourId;

    protected int people;
    protected String comment;
    protected LocalDateTime startAt;

    @Enumerated(value = EnumType.STRING)
    protected BookStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(insertable = false, updatable = false, name = "user_id")
    protected User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(insertable = false, updatable = false, name = "tour_id")
    protected Tour tour;
}
