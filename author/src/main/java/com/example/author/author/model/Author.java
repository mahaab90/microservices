package com.example.author.author.model;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Author {
	@Id
    @Column(updatable = false, nullable = false)
    String name;
    
	@Column
    String mail;
    @Column
    String adress;
    
 
}
