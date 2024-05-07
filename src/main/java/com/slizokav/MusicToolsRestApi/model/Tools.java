package com.slizokav.MusicToolsRestApi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tools")
@Data
@NoArgsConstructor
public class Tools {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "tool_name")
    @NotEmpty(message = "tool_name may not be empty")
    private String tool_name;

    @Column(name = "cost")
    @NotEmpty(message = "cost may not be empty")
    private int cost;
}
