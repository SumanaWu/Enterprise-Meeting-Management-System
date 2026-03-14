package org.example.identity.controller;


import jakarta.annotation.Resource;
import org.example.identity.service.IdentityParameters;
import org.example.identity.service.UserException;
import org.example.identity.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    // controller层的主要目的是暴露出URL
    @RequestMapping(path = "/user/signup")
    public String signup(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         @RequestParam("phone") String phone,
                         @RequestParam("email") String email) {
        String result = null;
        IdentityParameters identityParameters = new IdentityParameters();
        identityParameters.setName(username);
        identityParameters.setPasswd(password);
        identityParameters.setPhone(phone);
        identityParameters.setEmail(email);

        int signupCode = userService.signup(identityParameters);
        switch (signupCode) {
            case 0:
                result = "succ";
                break;
            case -1:
                result = "param error";
                break;
            case -2:
                result = "user exists";
                break;
            case -3:
                result = "password not valid";
                break;
            case -4:
                result = "username not valid";
                break;
            case -5:
                result = "email not valid";
                break;
            case -6:
                result = "phone not valid";
                break;
        }
        return result;
    }

    @RequestMapping(path = "/user/login")
    public Resp login(@RequestParam("phone") String phone,
                      @RequestParam("email") String email,
                      @RequestParam("password") String password) {

        IdentityParameters identityParameters = new IdentityParameters();
        identityParameters.setPasswd(password);
        identityParameters.setPhone(phone);
        identityParameters.setEmail(email);
        String result = null;

        try {
            userService.login(identityParameters);
            result = "success";
        } catch (UserException.InvalidParameterException paramException) {
            result = "paraError";
        } catch (UserException.UserNotFoundException userNotFoundException) {
            result = "userNotFound";
        } catch (UserException.InvalidPasswdException invalidPasswdException) {
            result = "invalidPasswdException";
        } catch (UserException userException) {
            userException.printStackTrace();
            result = "failure";
        }
        return Resp.newInstance(0, result);
    }
}
