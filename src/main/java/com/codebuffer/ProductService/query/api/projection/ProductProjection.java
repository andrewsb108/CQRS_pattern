package com.codebuffer.ProductService.query.api.projection;

import com.codebuffer.ProductService.command.api.data.Product;
import com.codebuffer.ProductService.command.api.data.ProductRepository;
import com.codebuffer.ProductService.command.api.model.ProductRestModel;
import com.codebuffer.ProductService.query.api.queries.GetProductQuery;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductProjection {

    private final ProductRepository productRepository;

    @QueryHandler
    public List<ProductRestModel> handle(GetProductQuery getProductQuery) {
        List<Product> products = productRepository.findAll();

        List<ProductRestModel> productRestModels = products.stream()
                .map(product -> ProductRestModel.builder()
                        .quantity(product.getQuantity())
                        .price(product.getPrice())
                        .name(product.getName())
                        .build())
                .collect(Collectors.toList());

        return productRestModels;
    }
}
