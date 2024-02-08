package hyun.timeTable.services.logic;

import hyun.timeTable.entities.State;
import hyun.timeTable.entities.User;
import hyun.timeTable.repositories.UserRepository;
import hyun.timeTable.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceLogic implements UserService {
    private final UserRepository userRepository;
    @Override
    public String create(String userName) {
        User findUser = userRepository.findByUserName(userName);
        if (findUser == null) {
            User user = User.builder()
                    .userName(userName)
                    .userState(State.STAND_BY)
                    .build();
            userRepository.save(user);
            return "success";
        } else {
            return "fail";
        }
    }

    @Override
    public String delete(Long userId) {
        Optional<User> findUser = userRepository.findById(userId);
        if (findUser.isPresent()) {
            userRepository.deleteById(userId);
            return "success";
        } else {
            return "fail";
        }
    }
}
