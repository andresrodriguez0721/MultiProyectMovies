package co.com.poli.servicebookings.client;

import co.com.poli.servicebookings.models.User;
import co.com.poli.servicelibraries.Response;
import co.com.poli.servicelibraries.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserClientFallBack implements UserClient{

    private final ResponseBuilder builder = new ResponseBuilder();

    @Override
    public Response findById(Long id) {
        User user = new User();
        return builder.success(user);
    }
}
