package Repository;

import Entities.User;

public interface UserRepository {
    boolean checkUserInDatabase(User user);
}
