package com.bookstore.productservice.query.projection;

import com.bookstore.commonservice.model.ProductResponseCommonModel;
import com.bookstore.commonservice.query.GetDetailsProductQuery;
import com.bookstore.commonservice.query.GetProductByAuthorQuery;
import com.bookstore.commonservice.query.GetProductByProductTypeQuery;
import com.bookstore.commonservice.query.GetProductByPublisherQuery;
import com.bookstore.productservice.command.data.Product;
import com.bookstore.productservice.command.data.ProductRepository;
import com.bookstore.productservice.query.model.ProductResponseModel;
import com.bookstore.productservice.query.queries.*;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductProjection {

    @Autowired
    private ProductRepository repository;

    @QueryHandler
    public List<ProductResponseModel> getAllBook(GetAllProductQuery getAll) {
        List<ProductResponseModel> list = new ArrayList<>();
        List<Product> List = repository.findAll();
        List.forEach(book -> {
            ProductResponseModel model = new ProductResponseModel();
            BeanUtils.copyProperties(book, model);
            list.add(model);
        });
        return list;
    }


    @QueryHandler
    public ProductResponseCommonModel handle(GetDetailsProductQuery getDetailsProductQuery) {
        ProductResponseCommonModel model = new ProductResponseCommonModel();
        Product product = repository.getReferenceById(getDetailsProductQuery.getId());
        BeanUtils.copyProperties(product, model);
        return model;
    }

    @QueryHandler
    public List<ProductResponseModel> getAllBookByName(GetAllProductByNameQuery getAll) {
        List<ProductResponseModel> list = new ArrayList<>();
        List<Product> List = repository.findByNameContainingIgnoreCase(getAll.getName());
        List.forEach(book -> {
            ProductResponseModel model = new ProductResponseModel();
            BeanUtils.copyProperties(book, model);
            list.add(model);
        });
        return list;
    }

    @QueryHandler
    public List<ProductResponseCommonModel> getAllBookByAuthor(GetProductByAuthorQuery getProductByAuthorQuery) {
        List<ProductResponseCommonModel> list = new ArrayList<>();
        List<Product> products = repository.findByAuthorId(getProductByAuthorQuery.getAuthorId());
        if (products.size() > 0) {
            products.forEach(book -> {
                ProductResponseCommonModel productResponseCommonModel = new ProductResponseCommonModel();
                BeanUtils.copyProperties(book, productResponseCommonModel);
                list.add(productResponseCommonModel);
            });
        }
        return list;
    }

    @QueryHandler
    public List<ProductResponseCommonModel> getAllBookByPublisher(GetProductByPublisherQuery getProductByPublisherQuery) {
        List<ProductResponseCommonModel> list = new ArrayList<>();
        List<Product> products = repository.findByPublisherId(getProductByPublisherQuery.getPublisherId());
        if (products.size() > 0) {
            products.forEach(book -> {
                ProductResponseCommonModel productResponseCommonModel = new ProductResponseCommonModel();
                BeanUtils.copyProperties(book, productResponseCommonModel);
                list.add(productResponseCommonModel);
            });
        }
        return list;
    }

    @QueryHandler
    public List<ProductResponseModel> getAllBookByPublishedDate(GetAllProductByPublishedDateQuery publishedDateQuery) {
        List<ProductResponseModel> list = new ArrayList<>();
        if (publishedDateQuery.getStartDate() != null) {
            List<Product> products = repository.findByPublishedDateAfter(publishedDateQuery.getStartDate());
            if (products.size() > 0) {
                products.forEach(book -> {
                    ProductResponseModel productResponseCommonModel = new ProductResponseModel();
                    BeanUtils.copyProperties(book, productResponseCommonModel);
                    list.add(productResponseCommonModel);
                });
            }
        }
        if (publishedDateQuery.getEndDate() != null) {
            List<Product> products = repository.findByPublishedDateBefore(publishedDateQuery.getEndDate());
            if (products.size() > 0) {
                products.forEach(book -> {
                    ProductResponseModel productResponseCommonModel = new ProductResponseModel();
                    BeanUtils.copyProperties(book, productResponseCommonModel);
                    list.add(productResponseCommonModel);
                });
            }
        }

        if (publishedDateQuery.getStartDate() != null && publishedDateQuery.getEndDate() != null) {
            List<Product> products = repository.findByPublishedDateBetween(publishedDateQuery.getStartDate(),
                    publishedDateQuery.getEndDate());
            if (products.size() > 0) {
                products.forEach(book -> {
                    ProductResponseModel productResponseCommonModel = new ProductResponseModel();
                    BeanUtils.copyProperties(book, productResponseCommonModel);
                    list.add(productResponseCommonModel);
                });
            }
        }
        return list;
    }

    @QueryHandler
    public List<ProductResponseModel> getAllBookByPrice(GetAllProductByPriceQuery priceQuery) {
        List<ProductResponseModel> list = new ArrayList<>();
        if (priceQuery.getMaxPrice() != null) {
            List<Product> products = repository.findByPriceBefore(priceQuery.getMaxPrice());
            if (products.size() > 0) {
                products.forEach(book -> {
                    ProductResponseModel productResponseCommonModel = new ProductResponseModel();
                    BeanUtils.copyProperties(book, productResponseCommonModel);
                    list.add(productResponseCommonModel);
                });
            }
        }
        if (priceQuery.getMinPrice() != null) {
            List<Product> products = repository.findByPriceAfter(priceQuery.getMinPrice());
            if (products.size() > 0) {
                products.forEach(book -> {
                    ProductResponseModel productResponseCommonModel = new ProductResponseModel();
                    BeanUtils.copyProperties(book, productResponseCommonModel);
                    list.add(productResponseCommonModel);
                });
            }
        }

        if (priceQuery.getMinPrice() != null && priceQuery.getMaxPrice() != null) {
            List<Product> products = repository.findByPriceBetween(priceQuery.getMinPrice(),
                    priceQuery.getMaxPrice());
            if (products.size() > 0) {
                products.forEach(book -> {
                    ProductResponseModel productResponseCommonModel = new ProductResponseModel();
                    BeanUtils.copyProperties(book, productResponseCommonModel);
                    list.add(productResponseCommonModel);
                });
            }
        }
        return list;

    }

    @QueryHandler
    public List<ProductResponseModel> getAllBookByCondition(GetAllProductByConditionQuery conditionQuery) {
        List<ProductResponseModel> list = new ArrayList<>();
        List<Product> products = repository.findByConditionContainingIgnoreCase(conditionQuery.getCondition());
        if (products.size() > 0) {
            products.forEach(book -> {
                ProductResponseModel productResponseCommonModel = new ProductResponseModel();
                BeanUtils.copyProperties(book, productResponseCommonModel);
                list.add(productResponseCommonModel);
            });
        }
        return list;
    }

    @QueryHandler
    public List<ProductResponseModel> getAllBookByBinding(GetAllProductByBindingQuery byBindingQuery) {
        List<ProductResponseModel> list = new ArrayList<>();
        List<Product> products = repository.findByBindingContainingIgnoreCase(byBindingQuery.getBinding());
        if (products.size() > 0) {
            products.forEach(book -> {
                ProductResponseModel productResponseCommonModel = new ProductResponseModel();
                BeanUtils.copyProperties(book, productResponseCommonModel);
                list.add(productResponseCommonModel);
            });
        }
        return list;
    }

    @QueryHandler
    public List<ProductResponseCommonModel> getAllBookByProductType(GetProductByProductTypeQuery getProductByProductTypeQuery) {
        List<ProductResponseCommonModel> list = new ArrayList<>();
        List<Product> products = repository.findByAuthorId(getProductByProductTypeQuery.getProductTypeId());
        if (products.size() > 0) {
            products.forEach(book -> {
                ProductResponseCommonModel productResponseCommonModel = new ProductResponseCommonModel();
                BeanUtils.copyProperties(book, productResponseCommonModel);
                list.add(productResponseCommonModel);
            });
        }
        return list;
    }
}
