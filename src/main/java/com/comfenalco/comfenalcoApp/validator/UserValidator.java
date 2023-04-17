package com.comfenalco.comfenalcoApp.validator;


import com.comfenalco.comfenalcoApp.entity.User;
import com.comfenalco.comfenalcoApp.exception.BadRequestCustom;

public class UserValidator {

    public static void validateEntity(User user) throws BadRequestCustom {
        Control.validateAttributePresent(user.getPhone(),"El número del usuario es requerido");
        Control.validateAttributePresent(user.getEmail(),"El correo del usuario es requerida");

    }
    public static void validateStringSize(User user) throws BadRequestCustom{
        Control.validateStringSize(user.getPhone(),60,"El número del usuario supera la longitud establecida");
        Control.validateStringSize(user.getEmail(),255,"El correo del usuario supera la longitud establecida");
    }
    public static void validateEmptyField(User user) throws BadRequestCustom{
        Control.validateEmptyField(user.getPhone(),"El campo número del usuario no puede ser vacio");
        Control.validateEmptyField(user.getEmail(),"El campo correo del usuario no puede ser vacio");
    }

    public static User trimAttributes(User user){
        user.setPhone(user.getPhone().trim());
        user.setEmail(user.getEmail().trim());
        return user;
    }
}
