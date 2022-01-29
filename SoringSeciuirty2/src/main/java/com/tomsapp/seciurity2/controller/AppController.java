package com.tomsapp.seciurity2.controller;

import com.tomsapp.seciurity2.entity.AppUser;
import com.tomsapp.seciurity2.entity.ImageStore;
import com.tomsapp.seciurity2.repository.AppUserRepository;
import com.tomsapp.seciurity2.repository.ImageStroreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.model.IModel;

import javax.annotation.PostConstruct;

@Controller
public class AppController {

    ImageController imageController;
    ImageStroreRepo imageStroreRepo;
    AppUserRepository appUserRepository;
    PasswordEncoder passwordEncoder;

    public AppController(ImageController imageController, ImageStroreRepo imageStroreRepo,
                         AppUserRepository appUserRepository,PasswordEncoder passwordEncoder) {
        this.imageController = imageController;
        this.passwordEncoder=passwordEncoder;
        this.imageStroreRepo = imageStroreRepo;
        this.appUserRepository=appUserRepository;
    }

    @GetMapping("/image_upload")
    public String getImage(){


        return "image_upload";
    }

    @PostMapping("/image_upload")
    public String addImage(@ModelAttribute("upload") String k,Model model){

        String s = imageController.saveImage(k);

        imageStroreRepo.save(new ImageStore(s));
        if (!s.isEmpty()) {model.addAttribute("done",s);}

        return "image_upload";
    }



    @GetMapping("/image_show")
    public String showImages(Model model){

        model.addAttribute("images",imageStroreRepo.findAll());


        return "show_images";
    }


    @GetMapping("/add_user")
    public String addUser(Model model){

        model.addAttribute("createUser",new AppUser());

        return "adduser";
    }

    @PostMapping("/add_user")
    public String saveUser(@ModelAttribute AppUser user){

        if(user!=null){
            String encode = passwordEncoder.encode(user.getPassword());
            user.setRole("ROLE_USER");
            user.setPassword(encode);
            appUserRepository.save(user);

        }



        return "redirect:/image_show";
    }


}
