package org.example.password_validator_programs;

/*
요구사항
1. 비밀번호는 최소 8자 이상 12자 이하여야 한다.
2. 비밀번호가 8자 미만 또는 12자 초과인 경우 IllegalArgumentException 예외를 발생 시킨다.
3. 경계조건에 대해 테스트 코드를 작성해야 한다
 */

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class PasswordValidatorTest {

    @DisplayName("PasswordValidator Create Test")
    @Test
    void createTest() {
        assertThatCode(()-> new PasswordValidator()).doesNotThrowAnyException();
    }

    @DisplayName("비밀번호는 최소 8자 이상 12자 이하여야 한다. 조건이 맞을때 통과시키는 기능 테스트")
    @Test
    void pass_validate_test() {

        PasswordValidator passwordValidator = new PasswordValidator();
        String passPassword = "12345678";
        assertThatCode(() ->passwordValidator.validate(passPassword)).doesNotThrowAnyException();

    }

    @DisplayName("비밀번호가 8자 미만 또는 12자 초과인 경우 IllegalArgumentException 예외를 발생 시킨다. 기능테스트")
    @Test
    void wrong_validate_test() {

        PasswordValidator passwordValidator = new PasswordValidator();
        String wrongPassword = "1234567";
        assertThatCode(() ->passwordValidator.validate(wrongPassword))
                .isInstanceOf( IllegalArgumentException.class)
                .hasMessage("올바른 패스워드가 아닙니다");
    }



    /*
        1. 경계 조건에 대한 테스트를 반드시 작성 필요 => 대부분 오류가 여기서 남
        2. https://www.petrikainulainen.net/programming/testing/junit-5-tutorial-writingparameterized-tests
     */

    // 경계 조건에 대한 테스트를 반드시 작성 필요 => 대부분 오류가 여기서 남
    @DisplayName("경계값테스트")
    @ParameterizedTest
    @ValueSource(strings = {"aabbcce", "aabbccddeeffg"})
    void boundary_validate_test(String password ) {

        PasswordValidator passwordValidator =new PasswordValidator();
        assertThatCode(()->passwordValidator.validate(password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 패스워드가 아닙니다");
    }
}
