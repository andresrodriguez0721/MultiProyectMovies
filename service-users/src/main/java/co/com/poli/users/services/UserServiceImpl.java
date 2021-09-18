package co.com.poli.users.services;

import co.com.poli.servicelibraries.Response;
import co.com.poli.users.clients.BookingClient;
import co.com.poli.users.entities.User;
import co.com.poli.users.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BookingClient bookingClient;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public String findByUSERID(Long userid) {
        String message = "";
        System.out.println("entro por acA");
        try {
            System.out.println("entro por acA V2");
            ModelMapper modelMapper = new ModelMapper();
            System.out.println("voy a hacer llamado aca: "+ bookingClient.findByUSERID(userid).getData());
            User user = modelMapper.map(bookingClient.findByUSERID(userid).getData(), User.class );

            System.out.println("responseUser v1->" + user);
            System.out.println("responseUser v1.1->" + user.getId());

            if(user != null) {
                message = "no se puede eliminar el usuario";
            }
        }catch (Exception ex){
            System.out.println("error -> " + ex.getMessage());
            ex.getCause();
        }

        return message;
    }
}
