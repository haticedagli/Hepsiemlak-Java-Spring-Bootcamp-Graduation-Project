package com.hepsiemlak.userservice.service;

import com.hepsiemlak.userservice.model.User;
import com.hepsiemlak.userservice.model.enums.UserType;
import com.hepsiemlak.userservice.repository.UserRepository;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void save_function_should_be_called_when_save_user_is_called() {
        //given
        User user = new User();
        user.setId(1L);
        user.setUserType(UserType.CORPORATE);
        user.setUsername("username");
        user.setPassword("password");
        user.setEmail("email");
        user.setFirstName("firstName");
        user.setLastName("lastName");

        //when
        userService.save(user);

        //then
        Mockito
                .verify(userRepository, times(1))
                .save(user);
    }
    @Test
    public void save_function_should_throw_exception_when_user_exist_with_given_username() {
        //given
        User user = new User();
        user.setId(1L);
        user.setUserType(UserType.CORPORATE);
        user.setUsername("username");
        user.setPassword("password");
        user.setEmail("email");
        user.setFirstName("firstName");
        user.setLastName("lastName");

        BDDMockito
                .given(userRepository.existsByUsername(user.getUsername()))
                .willReturn(true);

        //when
        Throwable throwable = catchThrowable(() -> userService.save(user));

        //then

        assertThat(throwable).isNotNull();

        assertThat(throwable.getMessage()).isEqualTo("User Already Exist");
    }

    @Test
    public void get_function_should_return_user() {
        //given
        User user = new User();
        user.setId(1L);
        user.setUserType(UserType.CORPORATE);
        user.setUsername("username");
        user.setPassword("password");
        user.setEmail("email");
        user.setFirstName("firstName");
        user.setLastName("lastName");

        BDDMockito
                .given(userRepository.findById(user.getId()))
                .willReturn(Optional.of(user));


        //when
        User result = userService.get(user.getId());

        //then
        assertThat(result).isNotNull();

        assertThat(result.getId()).isEqualTo(user.getId());
        assertThat(result.getUserType()).isEqualTo(user.getUserType());
        assertThat(result.getUsername()).isEqualTo(user.getUsername());
        assertThat(result.getPassword()).isEqualTo(user.getPassword());
        assertThat(result.getEmail()).isEqualTo(user.getEmail());
        assertThat(result.getFirstName()).isEqualTo(user.getFirstName());
        assertThat(result.getLastName()).isEqualTo(user.getLastName());
    }

    @Test
    public void get_function_should_throw_exception_when_user_not_found() {
        //given
        User user = new User();
        user.setId(1L);
        user.setUserType(UserType.CORPORATE);
        user.setUsername("username");
        user.setPassword("password");
        user.setEmail("email");
        user.setFirstName("firstName");
        user.setLastName("lastName");

        BDDMockito
                .given(userRepository.findById(user.getId()))
                .willReturn(Optional.empty());

        //when
        Throwable throwable = catchThrowable(() -> userService.get(user.getId()));

        //then

        assertThat(throwable).isNotNull();

        assertThat(throwable.getMessage()).isEqualTo("User not found");
    }

    @Test
    public void save_function_should_be_called_when_update_user_is_called() {
        //given
        User user = new User();
        user.setId(1L);
        user.setUserType(UserType.CORPORATE);
        user.setUsername("username");
        user.setPassword("password");
        user.setEmail("email");
        user.setFirstName("firstName");
        user.setLastName("lastName");

        BDDMockito
                .given(userRepository.existsById(user.getId()))
                .willReturn(true);

        BDDMockito
                .given(userRepository.existsByUsername(user.getUsername()))
                .willReturn(false);

        //when
        userService.update(user);

        //then
        Mockito
                .verify(userRepository, times(1))
                .save(user);
    }

    @Test
    public void update_function_should_throw_exception_when_user_not_found() {
        //given
        User user = new User();
        user.setId(1L);
        user.setUserType(UserType.CORPORATE);
        user.setUsername("username");
        user.setPassword("password");
        user.setEmail("email");
        user.setFirstName("firstName");
        user.setLastName("lastName");

        BDDMockito
                .given(userRepository.existsById(user.getId()))
                .willReturn(false);

        //when
        Throwable throwable = catchThrowable(() -> userService.update(user));

        //then
        assertThat(throwable).isNotNull();
        assertThat(throwable.getMessage()).isEqualTo("User not found");
    }

    @Test
    public void update_function_should_throw_exception_when_username_already_exist() {
        //given
        User user = new User();
        user.setId(1L);
        user.setUserType(UserType.CORPORATE);
        user.setUsername("username");
        user.setPassword("password");
        user.setEmail("email");
        user.setFirstName("firstName");
        user.setLastName("lastName");

        BDDMockito
                .given(userRepository.existsById(user.getId()))
                .willReturn(true);

        BDDMockito
                .given(userRepository.existsByUsername(user.getUsername()))
                .willReturn(true);

        //when
        Throwable throwable = catchThrowable(() -> userService.update(user));

        //then
        assertThat(throwable).isNotNull();
        assertThat(throwable.getMessage()).isEqualTo("User already exist");
    }

    @Test
    public void delete_function_should_be_called_when_delete_user_is_called() {
        //given
        User user = new User();
        user.setId(1L);
        user.setUserType(UserType.CORPORATE);
        user.setUsername("username");
        user.setPassword("password");
        user.setEmail("email");
        user.setFirstName("firstName");
        user.setLastName("lastName");

        BDDMockito
                .given(userRepository.existsById(user.getId()))
                .willReturn(true);

        //when
        userService.delete(user.getId());

        //then
        Mockito
                .verify(userRepository, times(1))
                .deleteById(user.getId());
    }

    @Test
    public void delete_function_should_throw_exception_when_user_not_found() {
        //given
        User user = new User();
        user.setId(1L);
        user.setUserType(UserType.CORPORATE);
        user.setUsername("username");
        user.setPassword("password");
        user.setEmail("email");
        user.setFirstName("firstName");
        user.setLastName("lastName");

        BDDMockito
                .given(userRepository.existsById(user.getId()))
                .willReturn(false);

        //when
        Throwable throwable = catchThrowable(() -> userService.delete(user.getId()));

        //then
        assertThat(throwable).isNotNull();
        assertThat(throwable.getMessage()).isEqualTo("User not found");
    }

    @Test
    public void findByUsername_function_should_be_called_when_get_user_by_username() {
        //given
        User user = new User();
        user.setId(1L);
        user.setUserType(UserType.CORPORATE);
        user.setUsername("username");
        user.setPassword("password");
        user.setEmail("email");
        user.setFirstName("firstName");
        user.setLastName("lastName");

        BDDMockito
                .given(userRepository.findByUsername(user.getUsername()))
                .willReturn(Optional.of(user));

        //when
        User result = userService.findByUsername(user.getUsername());

        //then
        assertThat(result).isNotNull();

        assertThat(result.getId()).isEqualTo(user.getId());
        assertThat(result.getUserType()).isEqualTo(user.getUserType());
        assertThat(result.getUsername()).isEqualTo(user.getUsername());
        assertThat(result.getPassword()).isEqualTo(user.getPassword());
        assertThat(result.getEmail()).isEqualTo(user.getEmail());
        assertThat(result.getFirstName()).isEqualTo(user.getFirstName());
        assertThat(result.getLastName()).isEqualTo(user.getLastName());
    }

    @Test
    public void findByUsername_function_should_throw_exception_when_user_not_found() {
        //given
        User user = new User();
        user.setId(1L);
        user.setUserType(UserType.CORPORATE);
        user.setUsername("username");
        user.setPassword("password");
        user.setEmail("email");
        user.setFirstName("firstName");
        user.setLastName("lastName");

        BDDMockito
                .given(userRepository.findByUsername(user.getUsername()))
                .willReturn(Optional.empty());

        //when
        Throwable throwable = catchThrowable(() -> userService.findByUsername(user.getUsername()));

        //then
        assertThat(throwable).isNotNull();
        assertThat(throwable.getMessage()).isEqualTo("User not found");
    }
}