package com.boulderdash.principal;

import com.boulderdash.audio.Audio;

public class Juego{
	/**
	 * Programa principal con los movimientos que Rockford
	 * realizar� en los niveles 1 y 2.
	 * @param args .
	 */
	public static void main(String args[]){
		Gui.getInstancia();
		Audio.titulo();
		Audio.musicaMenu();
	}	
}