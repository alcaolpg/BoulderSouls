package com.boulderdash.personajes;

import com.boulderdash.entradasalida.BDTile;
import com.boulderdash.enumerativos.ParaDonde;
import com.boulderdash.principal.Mapa;
import javax.swing.*;

public class Luciernaga extends EnemigoMovil{
	
	private static ImageIcon icono = new ImageIcon("Texturas/firefly.gif");
	
	public Luciernaga(int x,int y){
		super(x,y);
	}
	
	public boolean esTransitable(ParaDonde donde){
		return false;
	}
	/**
	 * Comportamiento m�vil de la luci�rnaga. Permite elegir la direcci�n a la cual se debe desplazar
	 * y que comportamiento tomar en caso de no poder moverse en dicha direcci�n.
	 */
	public void actualizarEstadoObjeto(){	
		
		switch (super.getDireccionActual()){
		
		case ABAJO:
			if (!Mapa.getInstancia().getPersonaje(this.getPos(ParaDonde.ABAJO)).chequearSiSoy(BDTile.EMPTY)) {
				this.setDireccionActual(ParaDonde.IZQUIERDA);
			}
			break;
			
		case ARRIBA:
			if (!Mapa.getInstancia().getPersonaje(this.getPos(ParaDonde.ARRIBA)).chequearSiSoy(BDTile.EMPTY)) {
				this.setDireccionActual(ParaDonde.DERECHA);
			}
			break;
			
			
		case DERECHA:
			if (!Mapa.getInstancia().getPersonaje(this.getPos(ParaDonde.DERECHA)).chequearSiSoy(BDTile.EMPTY)) {
				this.setDireccionActual(ParaDonde.ABAJO);
			}
			break;
			
			
		case IZQUIERDA:
			if (!Mapa.getInstancia().getPersonaje(this.getPos(ParaDonde.IZQUIERDA)).chequearSiSoy(BDTile.EMPTY)) {
				this.setDireccionActual(ParaDonde.ARRIBA);
			}
			break;
		
		}
		
		this.chequearSiExploto();
		this.YaMeMoviEsteTurno = false;
	}
	
	
	public boolean chequearSiSoy (BDTile tile){

		return (tile == BDTile.FIREFLY);
	}

	@Override
	public ImageIcon getIcono() {
		// TODO Auto-generated method stub
		return icono;
	}
	
			
}
