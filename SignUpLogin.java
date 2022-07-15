package summerClasses.BusTicketSystem;

import java.util.ArrayList;
import java.util.List;

public class SignUpLogin {
    List<User> userList=new ArrayList<>();
    public String signup(String name,int phone,String email,String street,String city,String state,String password){
        for(User user:userList){
            if(user.getContact().getEmail().equals(email)){
                return "Signup unsuccesfull Email already exist.";
            }
        }
        Contact contact=new Contact(name,phone,email);
        Address address=new Address(street,city,state);
        User user=new User(contact,address,password);
        userList.add(user);
        return "Signup succesfull";
    }
    public String login(String email,String password){
        for(User user:userList){
        if(!email.equals(user.getContact().getEmail()) ){
            return "User email id incorrect";
        }
        if(!password.equals(user.getPassword())){
                return "password incorrect";
        }
            return "Login succesfull";
        }
        return " ";
        }
        public String changePass(String ema,String pass){
        for(User user: userList){
            if(ema.equals(user.getContact().getEmail())){
                user.setPassword(pass);
                return "Password changed sucessfully";
            }
        }
        return "";
        }

    }

