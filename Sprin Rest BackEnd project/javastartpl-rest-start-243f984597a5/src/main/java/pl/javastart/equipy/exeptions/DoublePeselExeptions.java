package pl.javastart.equipy.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT,reason = "Uzytkownik o takim peselu istnieje")
public class DoublePeselExeptions extends RuntimeException {
}
