package com.example.task.crud.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
	@Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    Long id;
    
	@Column
    String title;
    @Column
    String description;
    @Column
    String author;
}
