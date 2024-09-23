package com.newapi.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {
    private int id;
    private String title;
    private int price;
    private String category;
    private String description;
    private String image;
}
