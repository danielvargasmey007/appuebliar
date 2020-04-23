package com.mobile.appuebliar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mobile.appuebliar.domain.Proveedor;
import com.mobile.appuebliar.service.impl.ProvedorService;
import com.mobile.appuebliar.util.exception.AppuebliarNotFoundException;
import com.mobile.appuebliar.util.exception.NullAppuebliarException;

@RestController
@RequestMapping("/proveedor")
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,
		RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.PATCH, RequestMethod.TRACE }, allowedHeaders = "*")
public class ProvedorController {

	@Autowired
	private ProvedorService provedorService;

	@PutMapping
	public ResponseEntity<Object> guardarProvedor(@RequestBody Proveedor Provedor) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(provedorService.guardarProvedor(Provedor));
		} catch (NullAppuebliarException exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
		} catch (AppuebliarNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.OK).body(exception.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> borrarProvedor(@PathVariable Long id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(provedorService.borrarProvedor(id));
		} catch (NullAppuebliarException exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
		} catch (AppuebliarNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.OK).body(exception.getMessage());
		}
	}

	@GetMapping
	public ResponseEntity<Object> obtenerProvedores() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(provedorService.obtenerProvedores());
		} catch (NullAppuebliarException exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
		} catch (AppuebliarNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.OK).body(exception.getMessage());
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> obtenerProvedor(@PathVariable Long id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(provedorService.obtenerProvedor(id));
		} catch (NullAppuebliarException exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
		} catch (AppuebliarNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.OK).body(exception.getMessage());
		}
	}

}
