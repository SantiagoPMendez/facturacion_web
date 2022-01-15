package edu.ucacue.infraestructura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ucacue.modelo.DetalleFactura;
import edu.ucacue.modelo.FacturaCabecera;


public interface FacturaCabeceraRepositorio extends JpaRepository<FacturaCabecera, Integer> {
	
	//@Query("select f from FacturaCabecera f where f.numeroFactura :numeroFactura")
	//FacturaCabecera buscarByNumeroFactura(@Param("numeroFactura") int numeroFactura);

}

