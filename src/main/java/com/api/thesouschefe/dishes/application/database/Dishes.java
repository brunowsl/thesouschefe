package com.api.thesouschefe.dishes.application.database;

import com.api.thesouschefe.country.application.database.Country;
import com.api.thesouschefe.ingredients.application.database.Ingredients;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "dishes")
@AllArgsConstructor
@NoArgsConstructor
public class Dishes {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @JsonManagedReference
    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ingredients> ingredients;

}
