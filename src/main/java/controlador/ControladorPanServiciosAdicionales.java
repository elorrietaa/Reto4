package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modelo.*;
import vista.*;

public class ControladorPanServiciosAdicionales implements ActionListener {
	
	private JframePrincipal vista;
	private PrincipalModelo modelo;
	
	private ServiciosAdicionales servicios;

	public ControladorPanServiciosAdicionales(JframePrincipal vista, PrincipalModelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
	}
	
	public void addListeners() {
		vista.buscarAlojamiento.btnContratar.addActionListener(this);
		vista.buscarAlojamiento.btnCancelarSer.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		Object sourceObject = e.getSource();
		
		if (sourceObject instanceof JButton) {
			
			String botonPulsado = ((JButton) sourceObject).getActionCommand();
			
			switch(botonPulsado) {
			case "Contratar":
				
				break;
			case " Cancelar ":
				break;
			}
		}
	}
}