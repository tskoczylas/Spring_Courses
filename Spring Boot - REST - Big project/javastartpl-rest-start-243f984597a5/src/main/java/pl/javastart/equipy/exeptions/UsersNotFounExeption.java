package pl.javastart.equipy.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Uzytkownik o podanym id nie istnieje")
public class UsersNotFounExeption extends RuntimeException {
}
