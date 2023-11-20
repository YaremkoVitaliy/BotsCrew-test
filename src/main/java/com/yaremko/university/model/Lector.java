package com.yaremko.university.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Lector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(unique = true)
    private String name;

    @NonNull
    private Degree degree;

    private Double salary;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "lectors")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Department> departments;

}
