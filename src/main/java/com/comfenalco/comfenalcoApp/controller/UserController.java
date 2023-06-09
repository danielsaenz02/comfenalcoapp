package com.comfenalco.comfenalcoApp.controller;


import com.comfenalco.comfenalcoApp.entity.Afiliado;
import com.comfenalco.comfenalcoApp.entity.User;
import com.comfenalco.comfenalcoApp.exception.BadRequestCustom;
import com.comfenalco.comfenalcoApp.exception.ConflictException;
import com.comfenalco.comfenalcoApp.service.AfiliadoService;
import com.comfenalco.comfenalcoApp.service.UserService;
import com.comfenalco.comfenalcoApp.validator.Control;
import com.comfenalco.comfenalcoApp.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/user")
@CrossOrigin({"*"})
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private AfiliadoService afiliadoService;

    @GetMapping("/listar")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAll();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> saveUser(@RequestBody User user) throws Exception{
        try {
            UserValidator.validateEntity(user);
            UserValidator.validateStringSize(user);
            UserValidator.validateEmptyField(user);
            User newUser = UserValidator.trimAttributes(user);
            Control.validateEmail(newUser.getEmail());
            if(userService.findByEmail(newUser.getEmail()).isPresent()){
                throw new ConflictException("Ya existe un usuario con este correo");
            }
            userService.save(newUser);
            return new ResponseEntity<>(newUser, HttpStatus.OK);
        }catch (BadRequestCustom badMessage){
            return new ResponseEntity<>(badMessage.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch (ConflictException badConflictMessage){
            return new ResponseEntity<>(badConflictMessage.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> logIn(@RequestBody User user) throws Exception {
        try {
            Control.validateEmail(user.getEmail());
            User userLogin = userService.findByEmail(user.getEmail()).orElseThrow(() ->  new BadRequestCustom("El correo no se encuentra registrado. Por favor intente de nuevo y verifique el correo."));
            if (userLogin.getIdentificationNumber().equals(user.getIdentificationNumber())) {
                return new ResponseEntity<>(userLogin, HttpStatus.OK);
            } else {
                throw new BadRequestCustom("La contraseña es incorrecta. Por favor intente de nuevo y verifique la contraseña.");
            }
        } catch (BadRequestCustom badMessage) {
            return new ResponseEntity<>(badMessage.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listar/{idDocumento}")
    public ResponseEntity<?> buscarUsuario(@PathVariable String idDocumento) throws Exception {
        try {
            User user = userService.findByNumeroDocumento(idDocumento).orElseThrow(() ->  new BadRequestCustom("No se pudo encontrar el usuario"));
            return new ResponseEntity<>(user, HttpStatus.OK);

        } catch (BadRequestCustom badMessage) {
            return new ResponseEntity<>(badMessage.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("/listara/{idDocumento}")
    public ResponseEntity<?> buscarAfiliado(@PathVariable String idDocumento) throws Exception {
        try {
            Afiliado afiliado = afiliadoService.findByNumeroDocumento(idDocumento).orElseThrow(() ->  new BadRequestCustom("No se pudo encontrar el afiliado"));
            return new ResponseEntity<>(afiliado, HttpStatus.OK);

        } catch (BadRequestCustom badMessage) {
            return new ResponseEntity<>(badMessage.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }





}
