package hyun.timeTable.services;

public interface UserService {
    String create(String userName);

    String delete(Long userId);
}
