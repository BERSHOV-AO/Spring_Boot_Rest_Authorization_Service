package ru.netology.authorizationservice.repository;

import org.springframework.stereotype.Repository;
import ru.netology.authorizationservice.Authorities;
import ru.netology.authorizationservice.exception.InvalidCredentials;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class UserRepository {

    private Map<String, String> mapUsers;

    public UserRepository() {
        mapUsers = new HashMap<>();
        mapUsers.put("Alex", "qwerty");
        mapUsers.put("Alena", "2323");
        mapUsers.put("Svetlana", "7777");
    }


    public List<Authorities> getUserAuthorities(String user, String password) {


        if (mapUsers.containsKey(user) && mapUsers.get(user).equals(password)) {

            List<Authorities> enumList = new ArrayList<>();
            enumList.add(Authorities.WRITE);
            enumList.add(Authorities.DELETE);
            enumList.add(Authorities.READ);
            return enumList;
        } else {
            return new ArrayList<>();
            //throw new InvalidCredentials("Username or password invalid");
        }
    }

}

