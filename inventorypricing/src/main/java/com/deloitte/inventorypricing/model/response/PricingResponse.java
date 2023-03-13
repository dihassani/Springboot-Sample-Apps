package com.deloitte.inventorypricing.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PricingResponse {

    @JsonProperty(value="productId", required=true)
    private String productId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("barcode")
    private String barcode;

    @JsonProperty("price")
    private Double price;

    @JsonProperty("minquantity")
    private Double minquantity;
}
