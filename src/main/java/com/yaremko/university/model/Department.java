package com.yaremko.university.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(unique = true)
    private String name;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "head", referencedColumnName = "name")
    private Lector head;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "department_lector",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "lector_id")
    )
    @JsonIgnore
    private List<Lector> lectors;
}
