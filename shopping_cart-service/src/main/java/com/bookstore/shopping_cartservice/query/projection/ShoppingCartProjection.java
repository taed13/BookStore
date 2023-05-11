package com.bookstore.shopping_cartservice.query.projection;

import com.bookstore.commonservice.model.ProductResponseCommonModel;
import com.bookstore.commonservice.model.ShoppingCartResponseCommonModel;
import com.bookstore.commonservice.model.UserResponseCommonModel;
import com.bookstore.commonservice.query.GetDetailsProductQuery;
import com.bookstore.commonservice.query.GetDetailsUserQuery;
import com.bookstore.commonservice.query.GetShoppingCartByUserQuery;
import com.bookstore.shopping_cartservice.command.data.ShoppingCart;
import com.bookstore.shopping_cartservice.command.data.ShoppingCartRepository;
import com.bookstore.shopping_cartservice.query.model.ShoppingCartResponseModel;
import com.bookstore.shopping_cartservice.query.queries.GetAllShoppingCartQuery;
import com.bookstore.shopping_cartservice.query.queries.GetListShoppingCartByUserQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShoppingCartProjection {


    @Autowired
    private ShoppingCartRepository repository;

    @Autowired
    private QueryGateway queryGateway;


    @QueryHandler
    public List<ShoppingCartResponseModel> handle(GetListShoppingCartByUserQuery query){
        List<ShoppingCartResponseModel> list  = new ArrayList<>();
        List<ShoppingCart> listEntity = repository.findByUserId(query.getUserId());
        listEntity.forEach(s ->{
            ShoppingCartResponseModel model = new ShoppingCartResponseModel();
            BeanUtils.copyProperties(s, model);
            ProductResponseCommonModel product = queryGateway.query(new GetDetailsProductQuery(model.getProductId()), ResponseTypes.instanceOf(ProductResponseCommonModel.class)).join();
            model.setProductName(product.getName());
            model.setPrice(product.getPrice());
            model.setTotalPrice(product.getPrice() * model.getQuantity());
            UserResponseCommonModel user = queryGateway.query(new GetDetailsUserQuery(model.getUserId()), ResponseTypes.instanceOf(UserResponseCommonModel.class)).join();
            model.setUserName(user.getLastName() + " " + user.getFirstName());
            list.add(model);
        });
        return list;
    }
//
    @QueryHandler
    public List<ShoppingCartResponseModel> handle(GetAllShoppingCartQuery query){
        List<ShoppingCartResponseModel> list  = new ArrayList<>();
        List<ShoppingCart> listEntity = repository.findAll();
        listEntity.forEach(s ->{
            ShoppingCartResponseModel model = new ShoppingCartResponseModel();
            BeanUtils.copyProperties(s, model);
            ProductResponseCommonModel product = queryGateway.query(new GetDetailsProductQuery(model.getProductId()), ResponseTypes.instanceOf(ProductResponseCommonModel.class)).join();
            model.setProductName(product.getName());
            model.setPrice(product.getPrice());
            model.setTotalPrice(product.getPrice() * model.getQuantity());
            UserResponseCommonModel user = queryGateway.query(new GetDetailsUserQuery(model.getUserId()), ResponseTypes.instanceOf(UserResponseCommonModel.class)).join();
            model.setUserName(user.getLastName() + " " + user.getFirstName());
            list.add(model);
        });
        return list;
    }

    @QueryHandler
    public List<ShoppingCartResponseCommonModel> handle(GetShoppingCartByUserQuery query){
        List<ShoppingCartResponseCommonModel> list  = new ArrayList<>();
        List<ShoppingCart> listEntity = repository.findByUserId(query.getUserId());
        listEntity.forEach(s ->{
            ShoppingCartResponseCommonModel model = new ShoppingCartResponseCommonModel();
            BeanUtils.copyProperties(s, model);
            ProductResponseCommonModel product = queryGateway.query(new GetDetailsProductQuery(model.getProductId()), ResponseTypes.instanceOf(ProductResponseCommonModel.class)).join();
            model.setProductName(product.getName());
            model.setPrice(product.getPrice());
            model.setTotalPrice(product.getPrice() * model.getQuantity());
            UserResponseCommonModel user = queryGateway.query(new GetDetailsUserQuery(model.getUserId()), ResponseTypes.instanceOf(UserResponseCommonModel.class)).join();
            model.setUserName(user.getLastName() + " " + user.getFirstName());
            list.add(model);
        });
        return list;
    }
}
