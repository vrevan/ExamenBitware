package net.apirest.microservices.users.controller;

import net.apirest.microservices.users.exception.UserNotFoundException;
import net.apirest.microservices.users.model.User;
import net.apirest.microservices.users.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;



/**
 * This  is the controller class with the endpoints of a CRUD for users.
 * @author Victor Camacho
 * @since 1.0.0
 */

@RestController
@RequestMapping("NutriNet/Cliente")
public class UsersController {

		
    private static final Log log = LogFactory.getLog(UsersController.class);

    private final UserService usersService;
    private User user;
   
    @Autowired
    public UsersController(UserService usersService) {
        this.usersService = usersService;
    }

    /**
     * Get a User by userId
     * @param userId
     * @return a controller
     */
    @RequestMapping(value="/{userId}",method = RequestMethod.GET)
    public ResponseEntity<User> userById(@PathVariable String userId)  throws  UserNotFoundException{
        log.info("Get userById");
        try{
        	user = usersService.findByUserId(userId);
        }catch(UserNotFoundException e){
        	user = null;              			
        }     
        return ResponseEntity.ok(user);
        
    }
    
    /**
     * Get all Users
     * @return a controller
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> userById(){
        log.info("Get allUsers");
        return ResponseEntity.ok(usersService.findAll());
    }


    /**
     * Delete an user by Id
     * @param userId
     * @return empty response
     */
    @RequestMapping(value="/{userId}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable String userId){
    	log.info("Delete user " + userId);
        usersService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    /**
     * Save a new user
     * @param user
     * @return
     */
    @RequestMapping(method=RequestMethod.POST)
    public  ResponseEntity<User> saveUser(@RequestBody @Valid User user){
    	log.info("Save new user");
        this.user = usersService.findByEmail(user.getCorreo_Electronico());
         if(Objects.isNull(this.user)){
         log.info("si se registra");
            return ResponseEntity.ok(usersService.saveUser(user));
         
        }
        else {
            log.info("Ya se encuentra registrado");
            return null;
         }
       
    }

    /**
     * Update an user
     * @param userId
     * @param user
     * @return empty response
     */
    @RequestMapping(value="/{userId}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateUser(@PathVariable String userId, @RequestBody @Valid User user){
    	log.info("update user " + userId);
        this.user = usersService.findByUserId(userId);
        this.user.setEdad(user.getEdad());
        this.user.setEstatura(user.getEstatura());
        this.user.setPeso(user.getPeso());
        this.user.setGEB(user.getGEB());
        usersService.updateUser(this.user);
        return ResponseEntity.noContent().build();
    }   

}
