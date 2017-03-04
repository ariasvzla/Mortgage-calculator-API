/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dominic.mortgage;

/**
 *
 * @author Arias.E
 */
public class Users {
    
    String username;
    String password;
    
    public Users(String username, String password){
      
        this.password=password;
        this.username=username;
      
    }
    public String changeusername (String username){
        String newname;
        if (username.equals("hello")){
            newname="bye";
        }else{
          newname=username;
        }
        return newname;
        
        }
    
}
    

