package com.alura.challenge.model;

import jakarta.persistence.Entity;


public record authro(String name,
                     Integer birth_year,
                     Integer death_year) {
}
