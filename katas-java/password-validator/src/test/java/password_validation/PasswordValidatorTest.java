package password_validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.regex.Pattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

public class PasswordValidatorTest {

  @ParameterizedTest
  @DisplayName("Should invalid password when password has less than 8 chars")
  @CsvSource(delimiter ='|', value = {
    "clAI_2020 | true",
    "hola_1R | false"
  })
  void shouldInvalidPasswordWhenPasswordHasLessThan8Chars(String input, boolean expected) {
    // GIVEN

    // WHEN
    boolean actual = validatePassword(input);

    // THEN
    assertEquals(expected, actual);

  }

  @ParameterizedTest
  @DisplayName("Should validate password when password contains at least a capital letter")
  @CsvSource(delimiter ='|', value = {
    "clAI_2020 | true",
    "hola_2020 | false"
  })
  void shouldValidatePasswordWhenPasswordContainsAtLeastACapitalLetter(String input, boolean expected) {
    // GIVEN

    // WHEN
    boolean actual = validatePassword(input);

    // THEN
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @DisplayName("Should validate password when password contains at least a lowercase letter")
  @CsvSource(delimiter ='|', value = {
    "clAI_2020 | true",
    "HOLA_2020 | false"
  })
  void shouldValidatePasswordWhenPasswordContainsAtLeastALowerCaseLetter(String input, boolean expected) {
    // GIVEN

    // WHEN
    boolean actual = validatePassword(input);

    // THEN
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @DisplayName("Should validate password when password contains at least a number")
  @CsvSource(delimiter ='|', value = {
    "clAI_2020 | true",
    "HOLA_jmig | false"
  })
  void shouldValidatePasswordWhenPasswordContainsAtLeastANumber(String input, boolean expected) {
    // GIVEN

    // WHEN
    boolean actual = validatePassword(input);

    // THEN
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @DisplayName("Should validate password when password contains at least an underscore")
  @CsvSource(delimiter ='|', value = {
    "clAI_2020 | true",
    "Hola2021 | false"
  })
  void shouldValidatePasswordWhenPasswordContainsAtLeastAnUnderscore(String input, boolean expected) {
    // GIVEN

    // WHEN
    boolean actual = validatePassword(input);

    // THEN
    assertEquals(expected, actual);
  }

  /*
    Alternativas intersantes:
      * Devolver un objeto/enum con la regla que ha fallado.
      * Lanzar una excepción pq tiene más semántica.
   */
  public boolean validatePassword(String pwd) {

    return pwd.length() > 8 &&
      pwd.matches(".*[A-Z].*") &&
      pwd.matches(".*[a-z].*") &&
      pwd.matches(".*[0-9].*") &&
      pwd.matches(".*[\\_].*");

  }

}
