package com.example.OnTapLab5678.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "may_tinh")
public class MayTInh {
    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @JoinColumn(name = "ma", columnDefinition = "uniqueidentifier")
    private String ma;
    private String ten;
    private double gia;
    private String bo_nho;
    private String mau_sac;
    private String hang;
    private String mieu_ta;
}
