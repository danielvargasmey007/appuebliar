package com.mobile.appuebliar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mobile.appuebliar.domain.Sesion;
import com.mobile.appuebliar.service.impl.SesionService;
import com.mobile.appuebliar.util.exception.AppuebliarNotFoundException;
import com.mobile.appuebliar.util.exception.NullAppuebliarException;

@RestController
@RequestMapping("/sesion")
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,
		RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.PATCH, RequestMethod.TRACE }, allowedHeaders = "*")
public class SesionController {

	@Autowired
	private SesionService SesionService;

	@PutMapping
	public ResponseEntity<Object> guardarSesion(@RequestBody Sesion Sesion) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(SesionService.guardarSesion(Sesion));
		} catch (NullAppuebliarException exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
		} catch (AppuebliarNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.OK).body(exception.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> borrarSesion(@PathVariable Long id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(SesionService.borrarSesion(id));
		} catch (NullAppuebliarException exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
		} catch (AppuebliarNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.OK).body(exception.getMessage());
		}
	}

	@GetMapping
	public ResponseEntity<Object> obtenerSesiones() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(SesionService.obtenerSesions());
		} catch (NullAppuebliarException exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
		} catch (AppuebliarNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.OK).body(exception.getMessage());
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> obtenerSesion(@PathVariable Long id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(SesionService.obtenerSesion(id));
		} catch (NullAppuebliarException exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
		} catch (AppuebliarNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.OK).body(exception.getMessage());
		}
	}
	
	
	@GetMapping("/user/{id}")
	public ResponseEntity<Object> obtenerSesionesPorUsuario(@PathVariable String id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(SesionService.obtenerSesionPorUsuario(id));
		} catch (NullAppuebliarException exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
		} catch (AppuebliarNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.OK).body(exception.getMessage());
		}
	}

}
