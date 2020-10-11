/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author 710429
 */
public class AccountService {
    
    private ArrayList<User> userList = new ArrayList<>();
    
    public AccountService() {
        userList.add(new User("abe", "password"));
        userList.add(new User("barb", "password"));
        
    }
    public User login(String username, String password) {
        for(User use : userList) {
         if((username.equals("abe") || username.equals("barb")) && password.equals("password")) {
            User returnUser = new User(username, null);
            return returnUser;
         }
        
        }
        return null;
    }
}
