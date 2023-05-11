package com.bookservice.password_resetsservice.query.projection;

import com.bookservice.password_resetsservice.command.data.PasswordResets;
import com.bookservice.password_resetsservice.command.data.PasswordResetsRepository;
import com.bookservice.password_resetsservice.query.model.PasswordResetsResponseModel;
import com.bookservice.password_resetsservice.query.queries.GetAllPasswordResetsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PasswordResetsProjection {

    @Autowired
    private PasswordResetsRepository repository;

    @QueryHandler
    public List<PasswordResetsResponseModel> getAllBook(GetAllPasswordResetsQuery getAll) {
        List<PasswordResetsResponseModel> list = new ArrayList<>();
        List<PasswordResets> List = repository.findAll();
        List.forEach(book -> {
            PasswordResetsResponseModel model = new PasswordResetsResponseModel();
            BeanUtils.copyProperties(book, model);
            list.add(model);
        });
        return list;
    }
}
