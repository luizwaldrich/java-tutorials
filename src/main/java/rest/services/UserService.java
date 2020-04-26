package rest.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import rest.controllers.UserController;
import rest.domain.requests.UserRequest;
import rest.domain.requests.UserUpdateRequest;
import rest.domain.responses.UserResponse;
import rest.infrastructure.Mapper;
import rest.infrastructure.UserEntity;
import rest.infrastructure.UserException;
import rest.infrastructure.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private Mapper mapper = new Mapper();

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    public UserResponse create(UserRequest userRequest) {
        // email cannot repeat
        this.validateUserEmail(userRequest.getEmail());
        UserEntity userEntity = mapper.toUserEntity(userRequest);
        userRepository.save(userEntity);
        return mapper.toUserResponse(userEntity);
    }

    public void update(String userId, UserUpdateRequest userUpdateRequest) {
        UserEntity userEntity = this.getAndExists(userId);
        // if changed email, it cannot be duplicated
        if (!userEntity.getEmail().equals(userUpdateRequest.getEmail()) &&
                userRepository.findByEmail(userUpdateRequest.getEmail()).isPresent()) {
            String[] msgParameters = {userUpdateRequest.getEmail()};
            throw new UserException.UserBusinessException("user.already.exists", msgParameters);
        }
        userEntity = mapper.toUserEntity(userEntity, userUpdateRequest);
        userRepository.save(userEntity);
    }

    public void delete(String userId) {
        UserEntity userEntity = this.getAndExists(userId);
        userRepository.delete(userEntity);
    }

    public UserResponse get(String userId) {
        UserEntity userEntity = this.getAndExists(userId);
        return mapper.toUserResponse(userEntity);
    }

    public List<UserResponse> list() {
        List<UserEntity> userEntities = userRepository.findAll();
        return mapper.toUserResponse(userEntities);
    }

    private UserEntity getAndExists(String userId) {
        UserEntity userEntity = this.getAndExists(userId);
        return userEntity;
    }

    private void validateUserEmail(String email) {
        if (userRepository.findByEmail(email).isPresent()) {
            String[] msgParameters = {email};
            throw new UserException.UserBusinessException("user.already.exists", msgParameters);
        }
    }
}
