package com.deloitte.inventorypricing.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PricingRequest {
    @NotNull
    @Valid
    @JsonProperty(value="productId", required=true)
    private int productId;

    @JsonProperty
    private String productName;

}
