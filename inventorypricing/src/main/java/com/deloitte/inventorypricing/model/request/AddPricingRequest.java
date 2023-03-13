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
public class AddPricingRequest {
    @NotNull
    @Valid
    @JsonProperty(value="productId", required=true)
    private String productId;

    @JsonProperty
    private String productName;

    @JsonProperty
    private String description;

    @JsonProperty
    private String barcode;

    @JsonProperty
    private Double price;

    @JsonProperty
    private Double minquantity;
}
