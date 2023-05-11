package com.bookstore.productservice.query.controller;

import com.bookstore.productservice.query.model.ProductResponseModel;
import com.bookstore.productservice.query.queries.*;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<ProductResponseModel> getAll() {
        GetAllProductQuery getAllBookQuery = new GetAllProductQuery();
        List<ProductResponseModel> list = queryGateway.query(getAllBookQuery,
                ResponseTypes.multipleInstancesOf(ProductResponseModel.class)).join();
        return list;
    }

    @GetMapping("/productName")
    public List<ProductResponseModel> getProduct(@RequestParam(required = false) String productName) {
        GetAllProductByNameQuery getAllProductByNameQuery = new GetAllProductByNameQuery(productName);
        List<ProductResponseModel> list = queryGateway.query(getAllProductByNameQuery,
                ResponseTypes.multipleInstancesOf(ProductResponseModel.class)).join();

        return list;
    }

    @GetMapping("/publishedDate")
    public List<ProductResponseModel> getProductsByPublishedDate(@RequestParam(required = false) String startDate,
                                                                 @RequestParam(required = false) String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate startDateObj = startDate != null ? LocalDate.parse(startDate, formatter) : null;
        LocalDate endDateObj = endDate != null ? LocalDate.parse(endDate, formatter) : null;

        GetAllProductByPublishedDateQuery getAllProductByPublishedDateQuery = new GetAllProductByPublishedDateQuery(
                startDateObj, endDateObj
        );
        List<ProductResponseModel> list = queryGateway.query(getAllProductByPublishedDateQuery,
                ResponseTypes.multipleInstancesOf(ProductResponseModel.class)).join();
        return list;
    }

    @GetMapping("/price")
    public List<ProductResponseModel> getProductsByPrice(@RequestParam(required = false) Double minPrice,
                                                                 @RequestParam(required = false) Double maxPrice) {
        GetAllProductByPriceQuery getAllProductByPriceQuery = new GetAllProductByPriceQuery(minPrice, maxPrice);
        List<ProductResponseModel> list = queryGateway.query(getAllProductByPriceQuery,
                ResponseTypes.multipleInstancesOf(ProductResponseModel.class)).join();
        return list;
    }

    @GetMapping("/condition")
    public List<ProductResponseModel> getProductByCondition(@RequestParam(required = false) String condition) {
        GetAllProductByConditionQuery getAllProductByConditionQuery = new GetAllProductByConditionQuery(condition);
        List<ProductResponseModel> list = queryGateway.query(getAllProductByConditionQuery,
                ResponseTypes.multipleInstancesOf(ProductResponseModel.class)).join();
        return list;
    }

    @GetMapping("/binding")
    public List<ProductResponseModel> getProductByBinding(@RequestParam(required = false) String binding) {
        GetAllProductByBindingQuery getAllProductByBindingQuery = new GetAllProductByBindingQuery(binding);
        List<ProductResponseModel> list = queryGateway.query(getAllProductByBindingQuery,
                ResponseTypes.multipleInstancesOf(ProductResponseModel.class)).join();
        return list;
    }
}
