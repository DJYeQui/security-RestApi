package com.example.demProject.mapper;

import com.example.demProject.dto.UserEntityDto;
import com.example.demProject.entity.UserEntity;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserEntityMapper {
    UserEntity toEntity(UserEntityDto userEntityDto);

    UserEntityDto toDto(UserEntity userEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UserEntity partialUpdate(UserEntityDto userEntityDto, @MappingTarget UserEntity userEntity);
}