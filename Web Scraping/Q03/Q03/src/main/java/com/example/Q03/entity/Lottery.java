package com.example.Q03.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lottery_navodya" )
public class Lottery {
    @Id
    @GeneratedValue
    private  int id;
    private  String name;
    private  int drawNo;
    private String letter;
    private int no1;
    private int no2;
    private int no3;
    private int no4;


}
