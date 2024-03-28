package com.laydowncoding.tickitecking.domain.auditorium.entity;

import com.laydowncoding.tickitecking.global.entity.Timestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Getter
@Table(name = "auditoriums")
@NoArgsConstructor
@SQLRestriction(value = "deleted_at is NULL")
public class Auditorium extends Timestamp {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String name;

  @Column
  private String address;

  @Column(name = "max_column")
  private String maxColumn;

  @Column(name = "max_row")
  private String maxRow;

  @Column(nullable = false)
  private Long companyUserId;

  public Auditorium(String name, String address, String maxColumn, String maxRow, Long companyUserId) {
    this.name = name;
    this.address = address;
    this.maxColumn = maxColumn;
    this.maxRow = maxRow;
    this.companyUserId = companyUserId;
  }
}