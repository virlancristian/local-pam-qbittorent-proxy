package net.varlikip.local.pam.qbittorent.proxy.service;

import net.sf.jpam.Pam;
import net.sf.jpam.PamReturnValue;
import net.varlikip.local.pam.qbittorent.proxy.exception.auth.AuthenticationException;
import net.varlikip.local.pam.qbittorent.proxy.model.auth.AuthenticationRequest;
import net.varlikip.local.pam.qbittorent.proxy.model.auth.AuthenticationResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public AuthenticationResponse login(AuthenticationRequest credentials) {
        String username = credentials.getUsername();
        String password = credentials.getPassword();

        authenticateAgainstPam(username, password);

        return new AuthenticationResponse("", username, "");
    }

    private void authenticateAgainstPam(String username, String password) {
        Pam pam = new Pam();
        PamReturnValue loginResult = pam.authenticate(username, password);

        if(!loginResult.equals(PamReturnValue.PAM_SUCCESS)) {
            throw new AuthenticationException(loginResult.toString());
        }
    }
}
