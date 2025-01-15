package com.abhi.ModernWebApplication.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Student")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    private int id;

    @Column(name = "name", unique = true)
    private String name;

    // Learning - By default the columns are nullable, Here I have used int instead of Integer and got exception that
    // null cannot be mapped to int. Make sure to use Wrapper class for nullable fields.
    @Column(nullable = true)
    private Integer age;

    @Column(name = "subject_stream")
    private String subjectStream;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Book> bookList;

}
