package com.cheise_proj.customersvc.event;

import lombok.Data;

@Data
public class Event {
    private Long customerId;
    private Long orderId;
    private Long shippingId;
    private Long productId;
}
