package net.apirest.microservices.users.repository;

import net.apirest.microservices.users.model.User;

import java.util.List;
import java.util.Optional;

/**
 * Crud repository interface
 * @author Victor Camacho
 * @since 1.0.0
 */
public interface UserRepository{

       
   /**
    * Find a users list     
    * @return
    */
  Optional<List<User>> findAll();

    /**
     * Find a user
     * @param userId
     * @return
     */
    public Optional<User> findOne(String userId);

    /**
     *
     * @param email
     * @return
     */
    public Optional<User> findOneByEmail(String email);
    /**
     * save a new user
     * @param user
     * @return
     */
    public User saveUser(User user);

    /**
     * Update a user
     * @param user
     */
    public void updateUser(User user);

    /**
     * Delete a user by id
     * @param userId
     */
    public void deleteUser(String userId);

}
