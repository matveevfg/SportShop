package dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderDTO {

    private Long id;
    @NotBlank
    private LocalDateTime dateTime;
    private String status;
    private BigDecimal totalCost;
}