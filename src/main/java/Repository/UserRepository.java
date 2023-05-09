package Repository;

import Entities.Trait;
import Entities.User;

public interface UserRepository {
    boolean checkUserInDatabase(User user);
}
