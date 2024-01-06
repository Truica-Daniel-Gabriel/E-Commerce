package ro.devdepot.services.implementation;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ro.devdepot.exception.BusinessException;
import ro.devdepot.model.User;
import ro.devdepot.model.UserRole;
import ro.devdepot.model.dto.CreateUserRequest;
import ro.devdepot.model.dto.LoginRequest;
import ro.devdepot.model.dto.LoginResponse;
import ro.devdepot.model.dto.UpdateUserRequest;
import ro.devdepot.model.dto.mapper.UserMapper;
import ro.devdepot.model.dto.response.GetUserResponse;
import ro.devdepot.repositories.UserRepository;
import ro.devdepot.services.UserService;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper createUserRequestMapper) {
        this.userRepository = userRepository;
        this.userMapper = createUserRequestMapper;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        // User user = repository.getUserByUsername(loginRequest.getUsername);
        // encodedPassword =.... loginRequest.getPass
        // iff user.getPassword.equals(encodedPassword)
        // tokenService.getJWT(user)
        // build new LoginResponse -> username, jwt
        // if user.getRole.euals(UserRole.ADMIN)

        return null;
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
    public String updateUser(UpdateUserRequest updateUserRequest, Long id) {

        User user = userRepository.findById(id).orElseThrow(() -> new BusinessException("User with id: " + id + " was not found", HttpStatus.NOT_FOUND));
        user.setEmail(updateUserRequest.getEmail());
        user.setFirstName(updateUserRequest.getFirstName());
        user.setLastName(updateUserRequest.getLastName());
        userRepository.save(user);

        return "User " + user.getUsername() + " has been saved successfully";
    }

    @Override
    public String updateUserRole(String userrole, Long id) {

        User user = userRepository.findById(id).orElseThrow(() -> new BusinessException("User with id: " + id + " was not found", HttpStatus.NOT_FOUND));
        try {
            UserRole role = UserRole.valueOf(userrole.toUpperCase());

            if(role == user.getUserRole()){
                throw new BusinessException("Your user role does not have to be the same as your current user role", HttpStatus.BAD_REQUEST);
            }

            user.setUserRole(role);
            userRepository.save(user);

            return user.getUsername() + " user role has been successfully updated";

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
    public String deleteUserById(Long id) {

        userRepository.findById(id).orElseThrow(() -> new BusinessException("This user does not exist", HttpStatus.BAD_REQUEST));
        userRepository.deleteById(id);

        return "User deleted successfully";
    }

    private void validateUserDto(CreateUserRequest createUserRequest) {

        if(userRepository.existsByUsername(createUserRequest.getUsername())) {
            throw new BusinessException("This username already exist!", HttpStatus.CONFLICT);
        }
    }
}
