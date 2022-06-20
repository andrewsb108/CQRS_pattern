package com.codebuffer.ProductService.query.api.controller;

import com.codebuffer.ProductService.command.api.model.ProductRestModel;
import com.codebuffer.ProductService.query.api.queries.GetProductQuery;
import lombok.RequiredArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductQueryController {

    private final QueryGateway queryGateway;

    @GetMapping
    public List<ProductRestModel> getAllProducts() {
        GetProductQuery getProductQuery = new GetProductQuery();

        List<ProductRestModel> productRestModels =
        queryGateway.query(getProductQuery, ResponseTypes.multipleInstancesOf(ProductRestModel.class)).join();

        return productRestModels;
    }
}
