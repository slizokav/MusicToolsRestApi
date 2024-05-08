package com.slizokav.MusicToolsRestApi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "brand")
@Data
@NoArgsConstructor
public class Brand {

    @Id
    private String tools_id;

    @Column(name = "brand_name")
    private String brand_name;
}
