package com.mobile.appuebliar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mobile.appuebliar.domain.ItemViajero;
import com.mobile.appuebliar.service.impl.ItemViajeroService;
import com.mobile.appuebliar.util.exception.AppuebliarNotFoundException;
import com.mobile.appuebliar.util.exception.NullAppuebliarException;

@RestController
@RequestMapping("/itemviajero")
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,
		RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.PATCH, RequestMethod.TRACE }, allowedHeaders = "*")
public class ItemViajeroController {

	@Autowired
	private ItemViajeroService ItemViajeroService;

	@PutMapping
	public ResponseEntity<Object> guardarItemViajero(@RequestBody ItemViajero ItemViajero) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(ItemViajeroService.guardarItemViajero(ItemViajero));
		} catch (NullAppuebliarException exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
		} catch (AppuebliarNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.OK).body(exception.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> borrarItemViajero(@PathVariable Long id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(ItemViajeroService.borrarItemViajero(id));
		} catch (NullAppuebliarException exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
		} catch (AppuebliarNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.OK).body(exception.getMessage());
		}
	}

	@GetMapping
	public ResponseEntity<Object> obtenerItemViajeroes() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(ItemViajeroService.obtenerItemViajeros());
		} catch (NullAppuebliarException exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
		} catch (AppuebliarNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.OK).body(exception.getMessage());
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> obtenerItemViajero(@PathVariable Long id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(ItemViajeroService.obtenerItemViajero(id));
		} catch (NullAppuebliarException exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
		} catch (AppuebliarNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.OK).body(exception.getMessage());
		}
	}

}
