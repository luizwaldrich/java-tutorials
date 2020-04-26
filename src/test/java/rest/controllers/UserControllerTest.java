package rest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import rest.domain.requests.UserRequest;
import rest.domain.requests.UserUpdateRequest;
import rest.domain.responses.UserResponse;
import rest.services.UserService;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    private ObjectMapper mapper;

    @Before
    public void setup() {
        this.mapper = new ObjectMapper();
        UserResponse userResponse = getUserResponse();
        BDDMockito.given(this.userService.get(Mockito.anyString())).willReturn(userResponse);
        BDDMockito.given(this.userService.create(Mockito.any(UserRequest.class))).willReturn(userResponse);
        BDDMockito.given(this.userService.list()).willReturn(Arrays.asList(userResponse));
    }

    @Test
    public void shouldGetAUserById() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/user/123")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName", CoreMatchers.is(getUserResponse().getFirstName())));
    }

    @Test
    public void shouldCreateAUser() throws Exception {
        UserRequest userRequest = getValidUserRequest();
        mvc.perform(MockMvcRequestBuilders.post("/api/user")
                .content(mapper.writeValueAsString(userRequest))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isAccepted())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName", CoreMatchers.is(userRequest.getFirstName())));
    }

    @Test
    public void shouldUpdateAUser() throws Exception {
        UserUpdateRequest userUpdateRequest = getValidUserUpdateRequest();
        mvc.perform(MockMvcRequestBuilders.put("/api/user/123")
                .content(mapper.writeValueAsString(userUpdateRequest))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    public void shouldDeleteAUser() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/api/user/123")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    public void shouldListUsers() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/user")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].firstName", CoreMatchers.is(getUserResponse().getFirstName())));
    }

    private UserResponse getUserResponse() {
        UserResponse userResponse = new UserResponse();
        userResponse.setId("123");
        userResponse.setEmail("test@test.com");
        userResponse.setFirstName("Luiz");
        userResponse.setLastName("Waldrich");
        userResponse.setCreatedAt("2020-04-26 16:18");
        return userResponse;
    }

    private UserRequest getValidUserRequest() {
        UserRequest userRequest = new UserRequest();
        userRequest.setEmail("test@test.com");
        userRequest.setFirstName("Luiz");
        userRequest.setLastName("Waldrich");
        return userRequest;
    }

    private UserUpdateRequest getValidUserUpdateRequest() {
        UserUpdateRequest userUpdateRequest = new UserUpdateRequest();
        userUpdateRequest.setEmail("another@test.com");
        userUpdateRequest.setFirstName("Luiz");
        userUpdateRequest.setLastName("Waldrich");
        return userUpdateRequest;
    }
}
