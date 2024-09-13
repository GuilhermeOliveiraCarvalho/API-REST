package dio.api.rest.service.impl;

import dio.api.rest.domain.model.User;
import dio.api.rest.domain.repository.UserRepository;
import dio.api.rest.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if(userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
            throw new IllegalArgumentException("This Account number already exists");
        }
        return userRepository.save(userToCreate);
    }
    @Override
    public User update(Long id, User userToUpdate) {

        User existingUser = userRepository.findById(id).orElseThrow(NoSuchElementException::new);


        existingUser.setName(userToUpdate.getName());
        existingUser.setAccount(userToUpdate.getAccount());
        existingUser.setCard(userToUpdate.getCard());
        existingUser.setFeatures(userToUpdate.getFeatures());
        existingUser.setNews(userToUpdate.getNews());

        return userRepository.save(existingUser);
    }

    @Override
    public void delete(Long id) {

        User existingUser = userRepository.findById(id).orElseThrow(NoSuchElementException::new);
        userRepository.delete(existingUser);
    }
}
