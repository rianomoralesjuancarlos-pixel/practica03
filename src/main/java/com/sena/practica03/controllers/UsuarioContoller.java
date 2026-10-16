package com.sena.practica03.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.sena.practica03.models.Usuario;
import com.sena.practica03.repositoryes.UsuarioRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController 
public class UsuarioContoller {

    @Autowired 
    private UsuarioRepository usuarioRepository;



    @GetMapping("")
    public String Inicio() {
        return "Saludo desde el controlador del Usuario controller";
    }
    

    @GetMapping("/todos")
    public List<Usuario> AllUsers() {
        return usuarioRepository.findAll();
    }
    
    
    @GetMapping("/{numdoc}")
    public ResponseEntity<Usuario> usuarioId(@PathVariable Integer numdoc){
        return usuarioRepository.findById(numdoc)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    
    }
    

    @PostMapping("/user")
    public ResponseEntity<Usuario> UsuarioporId(@RequestBody Usuario usuario) {
        return usuarioRepository.findById(usuario.getNumDoc())
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }
    

    @PostMapping("/crear")
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    
    //actualizacion de datos

    @PutMapping("/{numDoc}")
    public ResponseEntity<Usuario> actualizar (@PathVariable Integer numDoc, @RequestBody Usuario updateUser) {
        //TODO: process PUT request
        
        return usuarioRepository.findById(numDoc)
        .map(usuario -> {
            usuario.setNom(updateUser.getNom());
            usuario.setApe(updateUser.getApe());
            usuario.setFecNac(updateUser.getFecNac());
            return ResponseEntity.ok(usuarioRepository.save(usuario));
        })
        .orElse(ResponseEntity.notFound().build());

    }

    //Actualizar por post sin exponer numero de documento

    @PostMapping("/actualizar")
    public ResponseEntity<Usuario> actualizarPost(@RequestBody Usuario usuario2) {

        //obtenemos numero de documento desde el json recibido
        Integer numDoc = usuario2.getNumDoc();
        return usuarioRepository.findById(numDoc)
        .map(usuario -> {
            usuario.setNom(usuario2.getNom());
            usuario.setApe(usuario2.getApe());
            usuario.setFecNac(usuario2.getFecNac());
            return ResponseEntity.ok(usuarioRepository.save(usuario));
        })
        .orElse(ResponseEntity.notFound().build());
    }
    

    //eliminacion mediante delete 
    //public ResponseEntity<String> eliminar(@PathVariable Integer numDoc) {
    //resouesta especifica

    @DeleteMapping ("/{numDoc}")
    //para respuesta sin cuerpo
    public ResponseEntity <String> eliminar(@PathVariable Integer numDoc){
        if (usuarioRepository.existsById(numDoc)){
            usuarioRepository.deleteById(numDoc);
            //devolvemos texto expecifico
            return ResponseEntity.ok("Usuario con documento" + numDoc + " eliminado");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario con documento" + numDoc + " no existe");
    }

    //eliminacion mediante post
    @PostMapping("/eliminar")
    public ResponseEntity <String> eliminarPost(@RequestBody Usuario usuario) {
        Integer numDoc = usuario.getNumDoc();
        if (usuarioRepository.existsById(numDoc)){
            usuarioRepository.deleteById(numDoc);
            //devolvemos texto expecifico
            return ResponseEntity.ok("Usuario con documento" + numDoc + " eliminado");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario con documento" + numDoc + " no existe");
    }

}