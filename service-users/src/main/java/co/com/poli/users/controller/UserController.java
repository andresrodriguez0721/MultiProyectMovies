package co.com.poli.users.controller;

import co.com.poli.servicelibraries.FormatMessage;
import co.com.poli.servicelibraries.ResponseBuilder;
import co.com.poli.servicelibraries.Response;
import co.com.poli.users.entities.User;
import co.com.poli.users.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ResponseBuilder builder = new ResponseBuilder();
    private final FormatMessage formatMessage = new FormatMessage();

    @PostMapping
    public Response save(@Valid @RequestBody User user, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(formatMessage.formatMessage((result)));
        }
        userService.save(user);
        return builder.success(user);
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id){
        User user = userService.findById(id);
        if(user == null){
            return builder.success(null);
        }
        return builder.success(user);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id){
        User user = userService.findById(id);
        if(user == null){
            return builder.success(null);
        }
        System.out.println("entro por aca");
        String message = userService.findByUSERID(user.getId());
        System.out.println("entro por aca v2 ->" + message);
        if(message.equals("no se puede eliminar el usuario")) {
            System.out.println("entro por aca impor");

            return builder.success("No se puede eliminar el usuario dado que tiene reservas");
        }
        userService.delete(user);
        return builder.success(user);
    }

    @GetMapping()
    public Response findAll(){
        List<User> users = userService.findAll();
        if(users.isEmpty()){
            return builder.success(null);
        }
        return builder.success(users);
    }
}
