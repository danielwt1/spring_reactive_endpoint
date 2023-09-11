package com.example.reactive.reactive_project_1.adapters.driven.r2dbcpersistence.mappers;

import com.example.reactive.reactive_project_1.adapters.driven.r2dbcpersistence.entity.User;
import com.example.reactive.reactive_project_1.domain.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserEntityMapper {
    User toEntity(UserModel userModel);
    UserModel toModel(User user);
    List<UserModel> toModelList(List<User> userList);

}
