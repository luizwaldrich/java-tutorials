package rest.infrastructure;

import rest.domain.requests.UserRequest;
import rest.domain.requests.UserUpdateRequest;
import rest.domain.responses.UserResponse;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Mapper {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public UserEntity toUserEntity(UserRequest userRequest) {
        UserEntity entity = new UserEntity();
        entity.setEmail(userRequest.getEmail());
        entity.setFirstName(userRequest.getFirstName());
        entity.setLastName(userRequest.getLastName());
        return entity;
    }

    public UserResponse toUserResponse(UserEntity userEntity) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(userEntity.getId());
        userResponse.setEmail(userEntity.getEmail());
        userResponse.setFirstName(userEntity.getFirstName());
        userResponse.setLastName(userEntity.getLastName());
        userResponse.setCreatedAt(dateFormat.format(userEntity.getCreatedAt()));
        return userResponse;
    }

    public UserEntity toUserEntity(UserEntity userEntity, UserUpdateRequest userUpdateRequest) {
        if (userUpdateRequest.getFirstName() != null)
            userEntity.setFirstName(userUpdateRequest.getFirstName());
        if (userUpdateRequest.getLastName() != null)
            userEntity.setLastName(userUpdateRequest.getLastName());
        if (userUpdateRequest.getEmail() != null)
            userEntity.setEmail(userUpdateRequest.getEmail());
        return userEntity;
    }

    public List<UserResponse> toUserResponse(List<UserEntity> userEntities) {
        List<UserResponse> userResponses = new ArrayList<UserResponse>();
        for (UserEntity userEntity : userEntities) {
            userResponses.add(this.toUserResponse(userEntity));
        }
        return userResponses;
    }
}
