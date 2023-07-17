package org.travieso.com.repositories;

import java.util.List;

public interface UserRepository<T> {

    // Get Users
    List<T> getUsers();

    T getUser(Long id);

    void createUser(T user);

    void deleteUser(Long id);

}
