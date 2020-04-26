package rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.domain.interfaces.UserApi;
import rest.domain.requests.UserRequest;
import rest.domain.requests.UserUpdateRequest;
import rest.domain.responses.UserResponse;
import rest.services.UserService;

import java.util.List;

@Controller
@RequestMapping("/api/user")
public class UserController implements UserApi {

    @Autowired
    private UserService userService;

    @Override
    public UserResponse create(UserRequest userRequest) {
        return userService.create(userRequest);
    }

    @Override
    public void update(String userId, UserUpdateRequest userUpdateRequest) {
        userService.update(userId, userUpdateRequest);
    }

    @Override
    public void delete(String userId) {
        userService.delete(userId);
    }

    @Override
    public UserResponse get(String userId) {
        return userService.get(userId);
    }

    @Override
    public List<UserResponse> list() {
        return userService.list();
    }
}
