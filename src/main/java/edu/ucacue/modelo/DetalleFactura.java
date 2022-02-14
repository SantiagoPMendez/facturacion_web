package edu.ucacue.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

	@Entity
	@Table(name="detalles_facturas")
	public class DetalleFactura implements Serializable {
		
		private static final long serialVersionUID = 1607830177598686701L;
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int idFactura;
		
		@ManyToOne
		@JoinColumn(name = "factura_cabecera_fk")
		private FacturaCabecera facturaCabecera;
		
		@ManyToOne
		@JoinColumn(name = "producto_fk")
		private Producto producto;
		
		private int cantidad;
		
		private double subTotal;
		
		public DetalleFactura() {
			
		}

		public DetalleFactura(int idFactura, FacturaCabecera facturaCabecera, Producto producto, int cantidad,
				double subTotal) {
			super();
			this.idFactura = idFactura;
			this.facturaCabecera = facturaCabecera;
			this.producto = producto;
			this.cantidad = cantidad;
			this.subTotal = subTotal;
		}

		public int getIdFactura() {
			return idFactura;
		}

		public void setIdFactura(int idFactura) {
			this.idFactura = idFactura;
		}

		public FacturaCabecera getFacturaCabecera() {
			return facturaCabecera;
		}

		public void setFacturaCabecera(FacturaCabecera facturaCabecera) {
			this.facturaCabecera = facturaCabecera;
		}

		public Producto getProducto() {
			return producto;
		}

		public void setProducto(Producto producto) {
			this.producto = producto;
		}

		public int getCantidad() {
			return cantidad;
		}

		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}

		public double getSubTotal() {
			return subTotal;
		}

		public void setSubTotal(double subTotal) {
			this.subTotal = subTotal;
		}
	}
