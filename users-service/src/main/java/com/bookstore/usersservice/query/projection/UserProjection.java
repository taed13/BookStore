package com.bookstore.usersservice.query.projection;

import com.bookstore.commonservice.model.UserResponseCommonModel;
import com.bookstore.commonservice.query.GetDetailsUserQuery;
import com.bookstore.usersservice.repository.User;
import com.bookstore.usersservice.repository.UserRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserProjection {

    @Autowired
    private UserRepository userRepository;

    @QueryHandler
    public UserResponseCommonModel handle(GetDetailsUserQuery getDetailsUserQuery) {
        UserResponseCommonModel model = new UserResponseCommonModel();
        User user = userRepository.getReferenceById(getDetailsUserQuery.getId());
        BeanUtils.copyProperties(user, model);
        return model;
    }
}
