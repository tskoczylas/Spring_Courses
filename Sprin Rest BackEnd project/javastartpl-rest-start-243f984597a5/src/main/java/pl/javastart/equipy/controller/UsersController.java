package pl.javastart.equipy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.javastart.equipy.dtos.UsersDto;
import pl.javastart.equipy.entity.Users;
import pl.javastart.equipy.exeptions.DoublePeselExeptions;
import pl.javastart.equipy.service.UsersService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")

public class UsersController {

    UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("")
    List<UsersDto>  getUsers(@RequestParam(name = "lastName",required = false) String searchField){

        if(searchField!=null&&!searchField.isEmpty()) return usersService.findByLastNameFr(searchField);
            else{
                return usersService.getAllUsers();}


    }

    @PostMapping("")
    ResponseEntity<UsersDto> changeUsers(@RequestBody UsersDto usersDto,
                  @RequestParam(value = "lastName",required = false) String lastName){

        Optional<Users> usersByPeselExists = usersService.findByPesel(usersDto.getPesel());
        if(usersByPeselExists.isPresent()) throw new DoublePeselExeptions();


       if(usersDto.getId()!=0) throw  new ResponseStatusException(HttpStatus.BAD_REQUEST,"Ustawiona watość id");
        else {

           UsersDto returnSavedUsersDto = usersService.saveUser(usersDto);
           URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(usersDto.getId())
            .toUri();

           return ResponseEntity.created(location).body(returnSavedUsersDto);


       }
    }

    @GetMapping(path = "/{id}" )
    ResponseEntity<UsersDto> passUserToEdit(@PathVariable int id){
        UsersDto usersDto = usersService.finById(id);
        return new ResponseEntity<>(usersDto, HttpStatus.CREATED);

    }

    @PutMapping(path = "/{id}")
  ResponseEntity<UsersDto> editUsers(@RequestBody UsersDto usersDto, @PathVariable("id") String id){

        if(usersDto.getId()!= Integer.parseInt(id)) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Id nie zgodne z wczytanym");
        UsersDto returnDto = usersService.updateUser(usersDto);

        return new ResponseEntity<>(returnDto,HttpStatus.CREATED);
    }





}
