package com.sjtuse.zcbookstore.web;

import com.sjtuse.zcbookstore.entity.User;
import com.sjtuse.zcbookstore.helper.jaas.SimpleCallbackHandler;
import com.sjtuse.zcbookstore.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.apache.shiro.subject.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by zcoaolas on 3/14/2017.
 */
@Controller
@RequestMapping("/user") // url:/模块/资源/{id}/
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public String userLogin(@RequestParam("username") String username, @RequestParam("password") String password,
                            HttpSession session, Model model) {

        /*User u = userService.getByUsername(username);
        if (u == null){
            //map.put("msg", "no_user");
            return "userLogin";
        }
        else if (u.getPassword().equals(password)){
            session.setAttribute("username", u.getUsername());
            session.setAttribute("userId", u.getUserId());
            session.setAttribute("email", u.getEmail());
            session.setAttribute("auth", u.getAuth());
            //map.put("msg", "ok");
        }
        else{
            //map.put("msg", "wrong_pwd");
            return "userLogin";
        }*/
        /*LoginContext loginContext = null;
        try{
            loginContext = new LoginContext("SimpleLogin",
                    new SimpleCallbackHandler(username, password.toCharArray()));
        }
        catch (LoginException le){
            System.err.println("LoginContext cannot be created. " + le.getMessage());
            return "userLogin";
        }
        catch (SecurityException se){
            System.err.println("LoginContext cannot be created. " + se.getMessage());
            return "userLogin";
        }
        try{
            loginContext.login();
        }
        catch (LoginException le){
            System.err.println("Authentication failed. " + le.getMessage());
            return "userLogin";
        }
        catch (NullPointerException npe){
            System.err.println(npe.getMessage());
            return "userLogin";
        }
        User u = userService.getByUsername(username);
        session.setAttribute("username", u.getUsername());
        session.setAttribute("userId", u.getUserId());
        session.setAttribute("email", u.getEmail());
        session.setAttribute("auth", u.getAuth());*/

        Subject userSubject = SecurityUtils.getSubject();
        if(!userSubject.isAuthenticated()){
            UsernamePasswordToken upToken = new UsernamePasswordToken(username, password);
            upToken.setRememberMe(false);
            try{
                userSubject.login(upToken);
                User u = userService.getByUsername(username);
                session.setAttribute("username", u.getUsername());
                session.setAttribute("userId", u.getUserId());
                session.setAttribute("email", u.getEmail());
                return "redirect:/book/bookList";
            }
            catch (IncorrectCredentialsException ice){
                model.addAttribute("Error_msg", "Username or Password wrong");
            }
            catch (LockedAccountException lae){
                model.addAttribute("Error_msg", "Account Locked");
            }
            catch (AuthenticationException ae){
                model.addAttribute("Error_msg", ae.getMessage());
            }
        }
        userLogout(session);
        return "redirect:/user/userLogin";
        //return "redirect:/book/bookList";// WEB-INF/jsp/"login".jsp
    }

    @RequestMapping(value = "/userLogin", method = RequestMethod.GET)
    public String userLogin(){
        return "userLogin";
    }

    @RequestMapping(value = "/userLogout")
    public String userLogout(HttpSession session){
        SecurityUtils.getSubject().logout();
        try{
            session.invalidate();
        }
        catch (Exception e){
            logger.info(e.getMessage());
        }
        return "index";
    }

    @RequestMapping(value = "/userRefused")
    public String userRefused(HttpSession session){
        return "refused";
    }

    @RequestMapping(value = "/userRegister")
    public String userRegister(){
        return "userRegister";
    }
}
