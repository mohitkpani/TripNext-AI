package com.tripnext.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;

@RestController
@CrossOrigin("*")
public class RazorpayController {

    @Value("${razorpay.key.id}")
    private String razorpayKey;

    @Value("${razorpay.key.secret}")
    private String razorpaySecret;

    @PostMapping("/create-order")
    public String createOrder(
            @RequestParam int amount
    ) throws Exception {

        RazorpayClient client =
        new RazorpayClient(
                razorpayKey,
                razorpaySecret
        );

        JSONObject orderRequest =
        new JSONObject();

        orderRequest.put(
                "amount",
                amount * 100
        );

        orderRequest.put(
                "currency",
                "INR"
        );

        orderRequest.put(
                "receipt",
                "tripnext_order"
        );

        Order order =
        client.orders.create(orderRequest);

        return order.toString();
    }
}