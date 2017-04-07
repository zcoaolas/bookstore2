package com.sjtuse.zcbookstore.helper.jaas;

import com.sjtuse.zcbookstore.dao.UserDao;
import com.sjtuse.zcbookstore.entity.User;
import com.sjtuse.zcbookstore.service.UserService;
import com.sjtuse.zcbookstore.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.io.IOException;
import java.security.Principal;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * Created by zcoaolas on 3/16/2017.
 */
public class SimpleLoginModule implements LoginModule{
    private Subject subject;
    private CallbackHandler callbackHandler;
    private Map<String, ?> options;

    @Autowired
    private UserService userService;

    public void initialize(Subject subject, CallbackHandler callbackHandler,
                           Map<String, ?> sharedState, Map<String, ?> options){
        this.subject = subject;
        this.callbackHandler = callbackHandler;
        this.options = options;
    }

    public boolean login() throws LoginException{
        if (callbackHandler == null)
            throw new LoginException("No handler");

        NameCallback nameCall = new NameCallback("username: ");
        PasswordCallback passCall = new PasswordCallback("password: ", false);
        try{
            callbackHandler.handle(new Callback[] {nameCall, passCall});
        }
        catch (UnsupportedCallbackException e){
            LoginException e2 = new LoginException("Unsupported callback");
            e2.initCause(e);
            throw e2;
        }
        catch (IOException e){
            LoginException e2 = new LoginException("IO exception in callback");
            e2.initCause(e);
            throw e2;
        }
        return checkLogin(nameCall.getName(), passCall.getPassword());
    }

    private boolean checkLogin(String username, char [] password){
        User u = userService.getByUsername(username);
        if(Arrays.equals(u.getPassword().toCharArray(), password)){
            Set<Principal> principals = subject.getPrincipals();
            principals.add(new SimplePrincipal("username", username));
            principals.add(new SimplePrincipal("email", u.getEmail()));
            principals.add(new SimplePrincipal("auth", u.getAuth().toString()));
            return true;
        }
        return false;
    }

    public boolean logout(){
        return true;
    }
    public boolean abort(){
        return true;
    }
    public boolean commit(){
        return true;
    }
}
