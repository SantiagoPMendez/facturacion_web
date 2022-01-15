package edu.ucacue.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ucacue.infraestructura.repository.DetalleFacturaRepositorio;
import edu.ucacue.infraestructura.repository.FacturaCabeceraRepositorio;
import edu.ucacue.modelo.DetalleFactura;

@RestController
@RequestMapping("/api")
public class FacturaRestController {


	@Autowired
	private DetalleFacturaRepositorio dfr;
	
	@Autowired
	private FacturaCabeceraRepositorio fcr;
	

	@GetMapping("/facturas")
	public List<DetalleFactura> index() {
		return dfr.findAll();
	}
	
	@GetMapping("facturas/ventasDiarias")
	public List<DetalleFactura> index1() {
		return dfr.findAll();
	}
	
	@GetMapping("inventario")
	public List<DetalleFactura> index2() {
		return dfr.findAll();
	}

	@GetMapping("/facturas/{id}")
	public DetalleFactura getById(@PathVariable int id) {

		DetalleFactura detalleFactura = dfr.findById(id).get();
		return detalleFactura;
	}
	
	@PostMapping("/factura")
	public ResponseEntity<?> saveFactura(@RequestBody DetalleFactura dF, BindingResult result) {
		DetalleFactura facturaGrabar;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {
			List<String> errores = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			response.put("Los errores son", errores);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			facturaGrabar = dfr.save(dF);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el inserción en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "La factura se ha insertado con éxito en la BD");
		response.put("Factura", facturaGrabar);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
}