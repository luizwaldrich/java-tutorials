package rest.domain.interfaces;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rest.domain.requests.UserRequest;
import rest.domain.requests.UserUpdateRequest;
import rest.domain.responses.UserResponse;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface UserApi {

    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    @PostMapping(
            consumes = "application/json",
            produces = "application/json"
    )
    public UserResponse create(@RequestBody @Valid @NotNull UserRequest userRequest);

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(
            consumes = "application/json",
            produces = "application/json",
            value = "/{userId}"
    )
    public void update(
            @PathVariable(value = "userId") String userId,
            @RequestBody @Valid @NotNull UserUpdateRequest userUpdateRequest);

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{userId}")
    public void delete(@PathVariable(value = "userId") String userId);

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping(
            produces = "application/json",
            value = "/{userId}"
    )
    public UserResponse get(@PathVariable(value = "userId") String userId);

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping(produces = "application/json")
    public List<UserResponse> list();
}
