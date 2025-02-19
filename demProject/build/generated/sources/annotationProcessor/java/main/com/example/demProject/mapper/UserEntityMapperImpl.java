package com.example.demProject.mapper;

import com.example.demProject.dto.UserEntityDto;
import com.example.demProject.entity.UserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-28T20:36:14+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.11.1.jar, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class UserEntityMapperImpl implements UserEntityMapper {

    @Override
    public UserEntity toEntity(UserEntityDto userEntityDto) {
        if ( userEntityDto == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setUsername( userEntityDto.getUsername() );
        userEntity.setPassword( userEntityDto.getPassword() );

        return userEntity;
    }

    @Override
    public UserEntityDto toDto(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        String username = null;
        String password = null;

        username = userEntity.getUsername();
        password = userEntity.getPassword();

        UserEntityDto userEntityDto = new UserEntityDto( username, password );

        return userEntityDto;
    }

    @Override
    public UserEntity partialUpdate(UserEntityDto userEntityDto, UserEntity userEntity) {
        if ( userEntityDto == null ) {
            return userEntity;
        }

        if ( userEntityDto.getUsername() != null ) {
            userEntity.setUsername( userEntityDto.getUsername() );
        }
        if ( userEntityDto.getPassword() != null ) {
            userEntity.setPassword( userEntityDto.getPassword() );
        }

        return userEntity;
    }
}
