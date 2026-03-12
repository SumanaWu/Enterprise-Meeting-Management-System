package org.example.identity.service;

/**
 * option 1.return code representate the result of operation, eg: 0--succ, 1-- specific failure
 * option 2.exception code representate the result of operation, eg: XXException -- failure1
 * option 3.rarely used(Result passed in as argument
 */

public interface UserService {

//    /**
//     * honor option1
//     * return code desc:
//     * 0: succ;
//     * -1: input error;
//     * -2: user exists;
//     * -3: password not valid;
//     *
//     * @param username
//     * @param password
//     */
//    int signup(String username, String password);






    /**
     * honor option1
     * return code desc:
     * 0: succ;
     * -1: input error;
     * -2: user exists;
     * -3: password not valid;
     *
     * @param identityParameters 封装成一个对象
     */
    int signup(IdentityParameters identityParameters);

//    /**
//     * honor option2
//     * it's better frontend ensure that the parameters are not empty
//     *
//     * @param identityParameters 封装成一个对象
//     */
//    void login(IdentityParameters identityParameters) throws UserException;
//
//    /**
//          * honor option2
//          * it's better frontend ensure that the parameters are not empty
//          *
//          * @param username
//          * @param password
//          */
//    void login(String username, String password) throws UserException;

    /**
     * option 3: result encapsulate the result of operation
     * @param result
     */
    // void mock(String result);

}
