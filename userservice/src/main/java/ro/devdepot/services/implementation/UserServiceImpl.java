package ro.devdepot.services.implementation;

import lombok.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ro.devdepot.model.User;
import ro.devdepot.model.UserRole;
import ro.devdepot.model.dto.response.AuthenticationResponse;
import ro.devdepot.core.exception.BusinessException;
import ro.devdepot.model.dto.request.CreateUserRequest;
import ro.devdepot.model.dto.request.LoginRequest;
import ro.devdepot.model.dto.request.UpdateUserRequest;
import ro.devdepot.model.dto.mapper.UserMapper;
import ro.devdepot.model.dto.response.GetUserResponse;
import ro.devdepot.repositories.UserRepository;
import ro.devdepot.services.JwtService;
import ro.devdepot.services.UserService;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserMapper userMapper;

    @Override
    public AuthenticationResponse login(LoginRequest loginRequest) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        String jwtToken = jwtService.generateToken(loginRequest.getUsername());

        return AuthenticationResponse.builder()
                .jsonToken(jwtToken)
                .username(loginRequest.getUsername())
                .build();
    }

    @Override
    public void createUser(CreateUserRequest createUserRequest) {

        validateUserDto(createUserRequest);

        User userCreated = userRepository.save(userMapper.getUserFrom(createUserRequest));

        if(userCreated.getId() == null) {
            throw new BusinessException("Something goes wrong", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Long updateUser(UpdateUserRequest updateUserRequest, Long id) {

        User user = userRepository.findById(id).orElseThrow(() -> new BusinessException("User with id: " + id + " was not found", HttpStatus.NOT_FOUND));
        user.setEmail(updateUserRequest.getEmail());
        user.setFirstName(updateUserRequest.getFirstName());
        user.setLastName(updateUserRequest.getLastName());
        User updatedUser = userRepository.save(user);

        if(updatedUser.getId() == null) {
            throw new BusinessException("Something goes wrong", HttpStatus.BAD_REQUEST);
        }

        return user.getId();
    }

    @Override
    public Long updateUserRole(String userRole, Long id) {

        User user = userRepository.findById(id).orElseThrow(() -> new BusinessException("User with id: " + id + " was not found", HttpStatus.NOT_FOUND));
        try {
            UserRole role = UserRole.valueOf(userRole.toUpperCase());

            if(role == user.getUserRole()){
                return user.getId();
            }

            user.setUserRole(role);
            userRepository.save(user);
            return user.getId();

        }catch (IllegalArgumentException e) {
            throw new BusinessException("This user role does not exist", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public GetUserResponse getUserById(Long id) {

        User user = userRepository.findById(id).orElseThrow(() -> new BusinessException("User with id:" + id + "was not found", HttpStatus.NOT_FOUND));
        GetUserResponse userResponse =
                GetUserResponse
                        .builder()
                        .id(id)
                        .username(user.getUsername())
                        .email(user.getEmail())
                        .userRole(user.getUserRole().getName())
                        .lastName(user.getLastName())
                        .firstName(user.getFirstName())
                        .build();

        return userResponse;
    }

    @Override
    public List<GetUserResponse> getAllUsers() {

        return userRepository
                .findAll()
                .stream()
                .map(user -> GetUserResponse
                        .builder()
                        .id(user.getId())
                        .username(user.getUsername())
                        .email(user.getEmail())
                        .userRole(user.getUserRole().getName())
                        .lastName(user.getLastName())
                        .firstName(user.getFirstName())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUserById(Long id) {
        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
            SecurityContextHolder.clearContext();
        } else {
            throw  new BusinessException("This user does not exist", HttpStatus.BAD_REQUEST);
        }
    }

    private void validateUserDto(CreateUserRequest createUserRequest) {

        if(userRepository.existsByUsername(createUserRequest.getUsername())) {
            throw new BusinessException("This username already exist!", HttpStatus.CONFLICT);
        }
    }
}
