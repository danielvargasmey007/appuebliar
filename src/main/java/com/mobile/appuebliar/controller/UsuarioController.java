package com.mobile.appuebliar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mobile.appuebliar.domain.Usuario;
import com.mobile.appuebliar.service.impl.UsuarioService;
import com.mobile.appuebliar.util.exception.AppuebliarNotFoundException;
import com.mobile.appuebliar.util.exception.NullAppuebliarException;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,
		RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.PATCH, RequestMethod.TRACE }, allowedHeaders = "*")
public class UsuarioController {

	@Autowired
	private UsuarioService userService;

	@PutMapping
	public ResponseEntity<Object> guardarUsuario(@RequestBody Usuario usuario) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(userService.guardarUsuario(usuario));
		} catch (NullAppuebliarException exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
		} catch (AppuebliarNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.OK).body(exception.getMessage());
		}
	}

	@DeleteMapping("/{cedula}")
	public ResponseEntity<Object> borrarUsuario(@PathVariable String cedula) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(userService.borrarUsuario(cedula));
		} catch (NullAppuebliarException exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
		} catch (AppuebliarNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.OK).body(exception.getMessage());
		}
	}

	@GetMapping
	public ResponseEntity<Object> obtenerUsuarios() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(userService.obtenerUsuarios());
		} catch (NullAppuebliarException exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
		} catch (AppuebliarNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.OK).body(exception.getMessage());
		}
	}

	@GetMapping("/{cedula}")
	public ResponseEntity<Object> obtenerUsuario(@PathVariable String cedula) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(userService.obtenerUsuario(cedula));
		} catch (NullAppuebliarException exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
		} catch (AppuebliarNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.OK).body(exception.getMessage());
		}
	}

}
