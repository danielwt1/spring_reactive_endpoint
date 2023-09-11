package com.example.reactive.reactive_project_1.adapters.driving.http.api.rest.mapper;

import com.example.reactive.reactive_project_1.adapters.driving.http.api.rest.dto.request.UserDTORequest;
import com.example.reactive.reactive_project_1.domain.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserModelMapper {
    UserModel toModel(UserDTORequest userDTORequest);

}
