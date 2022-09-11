package pl.sdacademy.unit.test.advance.exercises.mockito.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    private static final User USER = new User(1L, "Jan", "Kowalski");
    @Mock
    private UserRepository userRepository;

    @Mock
    private UserValidator userValidator;

    @InjectMocks
    private UserService userService;

    @Test
    void shouldReturnUserById() {
        //given
        when(userRepository.findById(any())).thenReturn(Optional.of(USER));
        //when
        User result = userService.getUserById(1L);
        //then
        assertEquals(USER, result);
    }

    @Test
    void shouldThrowExceptionWhenUserDoesNotExist() {
        //given
        when(userRepository.findById(any())).thenReturn(Optional.empty());
        //when & then
        assertThrows(NoSuchElementException.class, () -> userService.getUserById(1L));
    }

    @Test
    void shouldCreateNewUser() {
        //given
        when(userValidator.isUserValid(any())).thenReturn(true);
        when(userRepository.addUser(any())).thenReturn(USER);
        User expectedResult = new User(1L, "Jan", "KOWALSKI");
        //when
        User result = userService.createUser("Jan", "Kowalski");
        //then
        assertEquals(expectedResult, result);
    }


    @Test
    void shouldThrowExceptionWhenUserIsInvalid() {
        //given
        when(userValidator.isUserValid(any())).thenReturn(false);
        //when & then
        assertThrows(IllegalArgumentException.class,
                () -> userService.createUser("Jan", "Kowalski"));
    }
}