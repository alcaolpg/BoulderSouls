package com.boulderdash.personajes;

import com.boulderdash.entradasalida.BDTile;
import com.boulderdash.enumerativos.Estado;
import com.boulderdash.enumerativos.ParaDonde;
import com.boulderdash.principal.Mapa;

public abstract class ObjetoNewton extends Personaje{
	
	private Estado stat;
	
	/**
	 * Constructor de la clase ObjetoNewton que tambi�n recibe si est� cayendo o no.
	 * @param cae Estado de movimiento del objeto.
	 * @param x Coordenada en X del nuevo objeto.
	 * @param y Coordenada en Y del nuevo objeto.
	 */
	public ObjetoNewton(boolean cae,int x, int y){
		super(x,y);
		if(cae){
			this.stat = Estado.CAYENDO;
		}
		else{
			this.stat = Estado.ESTACIONARIO;
		}
	}
	
	public void moverPersonajes(){
		if(stat == Estado.CAYENDO){
			Mapa.getInstancia().getPersonaje(super.getPos(ParaDonde.ABAJO)).meCaeAlgoEncima();//Le informo al de abajo mio que voy a caer encima de el, enviandole mi posicion
		}
	}
	
	private boolean chequearSiResbalo(ParaDonde donde, int x, int y)
	{
		if (donde == ParaDonde.IZQUIERDA)
			{
			return (((Mapa.getInstancia().getMapa()[x-1][y].chequearSiSoy(BDTile.EMPTY)) && (Mapa.getInstancia().getMapa()[x-1][y+1].chequearSiSoy(BDTile.EMPTY))) && 
		 	 		   (((( Mapa.getInstancia().getMapa()[x][y+1].chequearSiSoy(BDTile.DIAMOND) || (Mapa.getInstancia().getMapa()[x][y+1].chequearSiSoy(BDTile.WALL))||
		 		 	 		   ((Mapa.getInstancia().getMapa()[x][y+1].chequearSiSoy(BDTile.ROCK))))))));
			}
		else
		{
			return ((((Mapa.getInstancia().getMapa()[x+1][y].chequearSiSoy(BDTile.EMPTY)) && (Mapa.getInstancia().getMapa()[x+1][y+1].chequearSiSoy(BDTile.EMPTY))) && 
	 		 		   (((( Mapa.getInstancia().getMapa()[x][y+1].chequearSiSoy(BDTile.DIAMOND) || (Mapa.getInstancia().getMapa()[x][y+1].chequearSiSoy(BDTile.WALL))||
	 		 		   ((Mapa.getInstancia().getMapa()[x][y+1].chequearSiSoy(BDTile.ROCK)))))))));
		}
	}

	public void actualizarEstadoObjeto(){

		int x = this.getPos().getX();
		int y = this.getPos().getY();
			//
		if((Mapa.getInstancia().getMapa()[x][y+1].chequearSiSoy(BDTile.EMPTY))){/*Podriamos reemplazarlo por el chequear objeto debajo y actualizar dependiendo de eso*/
	 		this.stat = Estado.CAYENDO;
 		}
	 	else{
	 		if (chequearSiResbalo(ParaDonde.IZQUIERDA,x,y))
	 	 		{
	 	 			super.mover(ParaDonde.IZQUIERDA);
	 	 			this.stat = Estado.CAYENDO;
	 	 		}
	 		else
	 			if (chequearSiResbalo(ParaDonde.DERECHA,x,y))
	 		 		{
	 		 			super.mover(ParaDonde.DERECHA);
	 		 			this.stat = Estado.CAYENDO;
	 		 			
	 		 		}
		 		else
			 		{
			 			this.stat = Estado.ESTACIONARIO;
			 		}
	 	}
	}

}
