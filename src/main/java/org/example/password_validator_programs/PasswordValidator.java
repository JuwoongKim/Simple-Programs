package org.example.password_validator_programs;

public class PasswordValidator {

    public void validate(String password) {

        int length = password.length();

        if(length<8 || length >12){
            throw new IllegalArgumentException("올바른 패스워드가 아닙니다");
        }
    }
}
