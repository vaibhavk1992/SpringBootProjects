package com.javasample.UrlShortner.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "UrlMapping_TBL")
public class UrlMapping {
    @Id
    @GeneratedValue
    private int id;
    private String shortenurl;
    private String originalurl;
    private Date  currentdata;
}
