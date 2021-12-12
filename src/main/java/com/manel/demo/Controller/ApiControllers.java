package com.manel.demo.Controller;

import com.manel.demo.Models.User;
import com.manel.demo.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//This tells the ide that this class is a restController ,and we're going to have some endpoints here.
public class ApiControllers {

    @Autowired
    //handles all dependency injection for us
    private UserRepo  userRepo;

    @GetMapping(value = "/users")
    //endpoint to list all users
    public List<User> getUsers(){
        try {
            ResponseEntity.status(HttpStatus.OK);
            return userRepo.findAll() ;
        } catch (Exception e){
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
            return null;
        }

    }

    @GetMapping(value = "/user/{id}")
    //endpoint to list a specific user
    public Optional<User> getUser(@PathVariable long id){
        try {
            ResponseEntity.status(HttpStatus.CREATED);
            return userRepo.findById(id);
        }
        catch (Exception e){
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
            return null;
        }
    }

    @PostMapping(value = "/save")
    //endpoint to add a new user
    public String saveUser(@RequestBody User user){
        //requestBody used to retrieve the request's body
        userRepo.save(user);
        ResponseEntity.status(HttpStatus.CREATED);
        return "Saved!";
    }


    @PutMapping(value = "/update/{id}")
    //update an existing user
    public String updateUser(@PathVariable long id,@RequestBody User user){
        //call the findById on the user repo and pass in the id
        try {
            User updateUser = userRepo.findById(id).get();
            updateUser.setFirstName(user.getFirstName());
            updateUser.setLastName(user.getLastName());
            updateUser.setClasse(user.getClasse());
            updateUser.setDomaineSujet(user.getDomaineSujet());
            updateUser.setEncadrantFaculte(user.getEncadrantFaculte());
            updateUser.setEncadrantSociete(user.getEncadrantSociete());
            updateUser.setSpecialite(user.getSpecialite());
            updateUser.setRapport_signe(user.isRapport_signe());
            updateUser.setRapport_valide(user.isRapport_valide());
            updateUser.setStage_valide(user.isStage_valide());
            //save changes to the db
            userRepo.save(updateUser);
            ResponseEntity.status(HttpStatus.OK);
            return "Updated!";
        } catch (Exception e){
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
            return "Error";
        }

    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id, User user){
        try {
            User deleteUser = userRepo.findById(id).get();
            if (deleteUser == null) {
//                return "User doesn't exist";
                return new ResponseEntity<>(
                        "User doesn't exist",
                        HttpStatus.BAD_REQUEST);
            } else {
                userRepo.delete(deleteUser);
//                return "Deleted user with the id: " + id;
                return new ResponseEntity<>(
                        "Deleted user with the id: " + id,
                        HttpStatus.OK);
            }
        } catch (Exception e){
//            return "Error: User doesn't exist";
            return new ResponseEntity<>(
                    "Error",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
