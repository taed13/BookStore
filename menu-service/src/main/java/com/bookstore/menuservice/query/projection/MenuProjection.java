package com.bookstore.menuservice.query.projection;

import com.bookstore.menuservice.command.data.Menu;
import com.bookstore.menuservice.command.data.MenuRepository;
import com.bookstore.menuservice.query.model.MenuResponseModel;
import com.bookstore.menuservice.query.queries.GetAllMenuQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MenuProjection {

    @Autowired
    private MenuRepository repository;

    @QueryHandler
    public List<MenuResponseModel> getAllBook(GetAllMenuQuery getAll) {
        List<MenuResponseModel> list = new ArrayList<>();
        List<Menu> List = repository.findAll();
        List.forEach(book -> {
            MenuResponseModel model = new MenuResponseModel();
            BeanUtils.copyProperties(book, model);
            list.add(model);
        });
        return list;
    }
}
