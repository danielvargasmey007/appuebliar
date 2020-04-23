package com.mobile.appuebliar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mobile.appuebliar.domain.Excursionista;
import com.mobile.appuebliar.service.impl.ExcursionistaService;
import com.mobile.appuebliar.util.exception.AppuebliarNotFoundException;
import com.mobile.appuebliar.util.exception.NullAppuebliarException;

@RestController
@RequestMapping("/excursionista")
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,
		RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.PATCH, RequestMethod.TRACE }, allowedHeaders = "*")
public class ExcursionistaController {

	@Autowired
	private ExcursionistaService ExcursionistaService;

	@PutMapping
	public ResponseEntity<Object> guardarExcursionista(@RequestBody Excursionista Excursionista) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(ExcursionistaService.guardarExcursionista(Excursionista));
		} catch (NullAppuebliarException exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
		} catch (AppuebliarNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.OK).body(exception.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> borrarExcursionista(@PathVariable String id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(ExcursionistaService.borrarExcursionista(id));
		} catch (NullAppuebliarException exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
		} catch (AppuebliarNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.OK).body(exception.getMessage());
		}
	}

	@GetMapping
	public ResponseEntity<Object> obtenerExcursionistaes() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(ExcursionistaService.obtenerExcursionistas());
		} catch (NullAppuebliarException exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
		} catch (AppuebliarNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.OK).body(exception.getMessage());
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> obtenerExcursionista(@PathVariable String id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(ExcursionistaService.obtenerExcursionista(id));
		} catch (NullAppuebliarException exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
		} catch (AppuebliarNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.OK).body(exception.getMessage());
		}
	}

}
