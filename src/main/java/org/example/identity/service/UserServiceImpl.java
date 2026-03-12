package org.example.identity.service;

import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.example.identity.entity.User;
import org.example.identity.repository.UserRepo;
import org.springframework.stereotype.Service;

/**
 * option 1.return code representate the result of operation, eg: 0--succ, 1-- specific failure
 * option 2.exception code representate the result of operation, eg: XXException -- failure1
 * option 3.rarely used(Result passed in as argument
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepo userRepo;

    /**
     * return code desc:
     * 0: succ;
     * -1: input error;
     * -2: user exists;
     * -3: password not valid;
     * ...
     * <p>
     * 1. validate input, 1.1 if valid password, 1.2...
     * 2. check user exists
     * 3. persistence
     *
     * @param identityParameters 封装成一个对象
     * @return
     */
    @Override
    public int signup(IdentityParameters identityParameters) {
        // Step 1: 首先实现 1. validate input
        String username = identityParameters.getName();
        String password = identityParameters.getPasswd();
        String email = identityParameters.getEmail();
        String phone = identityParameters.getPhone();

        // return -6
        boolean isPhoneValid = StringUtils.isNumeric(phone);
        // return -5
        boolean isEmailValid = StringUtils.containsAny(email, "@");
        // return -4
        boolean isUserNameValid = StringUtils.isNotEmpty(username);
        // return -3
        boolean isPasswdValid = StringUtils.length(password) > 5;

        if (!isPhoneValid) {
            return -6;
        }

        if (!isEmailValid) {
            return -5;
        }

        if (!isUserNameValid) {
            return -4;
        }

        if (!isPasswdValid) {
            return -3;
        }

        // Step 2: 接着实现 2. check user exists
        boolean isSameEmailFound = userRepo.findUserByEmail(email) != null;
        boolean isSamePhoneFound = userRepo.findUserByPhone(phone) != null;

        if (isSameEmailFound || isSamePhoneFound) {
            return -2;
        }

        // Step 3: 最后实现 3. persistence 把数据保存到数据库（持久化）= 把对象存进数据库
        User newUser = new User();
        newUser.setName(username);
        newUser.setPasswd(password);
        newUser.setPhone(phone);
        newUser.setEmail(email);

        userRepo.save(newUser);
        return 0;
    }

//    /**
//     * @param identityParameters 封装成一个对象
//     * @throws UserException
//     */
//    @Override
//    public void login(IdentityParameters identityParameters) throws UserException {
//
//    }
}
