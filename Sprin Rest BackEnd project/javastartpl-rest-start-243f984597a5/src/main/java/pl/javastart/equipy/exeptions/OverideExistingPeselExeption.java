package pl.javastart.equipy.exeptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus()
public class OverideExistingPeselExeption extends RuntimeException {
}
