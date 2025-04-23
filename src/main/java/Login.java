/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



public class Login {
    //Attributes (fields)
     private String username;
     private String password;
     private String cellNumber;
     
     //Constructor
     public Login(String username, String password, String cellNumber){
         this.username = username;
         this.password = password;
         this.cellNumber = cellNumber;
     }
    
     public boolean checkUserName() {
         return username.contains("_")&&username.length()<=5;
     }
     public boolean checkPasswordComplex(String password) {
         return password.length() >= 8&&
                password.matches(".*[A-Z].*") &&
                password.matches(".*[a-z].*") &&
                password.matches(".*[0-9].*") &&
                password.matches(".*[!@#$%^&*()].*");
     
                 }
     public boolean checkCellPhoneNumber(){
           return cellNumber.length() == 10 && cellNumber.startsWith("+27");
       }
}

