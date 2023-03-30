/*
 * Author : Bhagi Baghel
 * Date :
 * Created with : IntelliJ IDEA Community Edition
 */

package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    int id;
    String name;
    String description;
    Double price;
    int quantity;

}
