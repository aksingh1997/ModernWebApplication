package com.abhi.ModernWebApplication.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Book")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    int price;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId")
    Student student;
}
