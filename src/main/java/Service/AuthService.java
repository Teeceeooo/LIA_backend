package Service;

import Entities.User;
import Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;


    public boolean checkUser(User user) {
        return userRepository.checkUserInDatabase(user);
    }
}