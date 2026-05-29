package com.logistics.services.login;

import com.logistics.models.LoginResponse;

public class LoginService {

    public static LoginResponse login(
            String email,
            String password
    ) {

        if(
                email.equals("operario@logistica.com")
                        &&
                        password.equals("1234")
        ) {

            return new LoginResponse(
                    true,
                    "operario"
            );
        }

        return new LoginResponse(
                false,
                null
        );
    }
}