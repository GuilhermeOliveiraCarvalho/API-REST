package dio.api.rest.service;

import dio.api.rest.domain.model.User;

public interface UserService {
    User findById(Long id);
    User create(User userToCreate);
    User update(Long id, User userToUpdate);
    void delete(Long id);
}
