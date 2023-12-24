package dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProductDTO {

    private Long id;
    @NotBlank
    private String name;
    private String description;
    private double price;
    private boolean available;
    private String brand;
}