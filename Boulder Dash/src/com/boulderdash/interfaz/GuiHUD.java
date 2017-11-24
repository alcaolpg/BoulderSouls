package com.boulderdash.interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.boulderdash.principal.Comportamiento;
import com.boulderdash.principal.Mapa;

import fuentes.MiFuente;

@SuppressWarnings("serial")
public class GuiHUD extends JPanel{

	public GuiHUD()
	{
		this.setLayout(new GridLayout());
		this.setBackground(Color.BLACK);

		Font fuente = MiFuente.getFuente(18);
	    
		JLabel vidas = new JLabel(new ImageIcon("./Texturas/heart.png"));
		vidas.setText("Vidas: ");
		vidas.setFont(fuente);
		vidas.setForeground(Color.WHITE);
		
		JLabel diamantesRestantes = new JLabel(new ImageIcon("./Texturas/diamond.gif"));
		diamantesRestantes.setText("Diamantes: ");
		diamantesRestantes.setFont(fuente);
		diamantesRestantes.setForeground(Color.WHITE);
		
		JLabel tiempoRestante = new JLabel(new ImageIcon("./Texturas/clock.gif"));
		tiempoRestante.setText("Timer: 120");
		tiempoRestante.setFont(fuente);
		tiempoRestante.setForeground(Color.WHITE);
		
		JLabel puntuacion = new JLabel();
		puntuacion.setText("Puntos: 0");
		puntuacion.setFont(fuente);
		puntuacion.setForeground(Color.WHITE);
		
		this.add(vidas);
		this.add(diamantesRestantes);
		this.add(tiempoRestante);
		this.add(puntuacion);
	}
	
	public void actualizarHud ()
	{
		((JLabel)(this.getComponent(0))).setText("Vidas: " + Mapa.getInstancia().getVidas()); //Actualiza Las Vidas
		if (Mapa.getInstancia().getVidas() == 0 && Comportamiento.getMuerteExtra())
			((JLabel)(this.getComponent(0))).setText("Mou shindeiru");
		
		((JLabel)(this.getComponent(1))).setText("Diamantes: " + Mapa.getDiamantesRestantes()); //Actualiza Los diamantes restantes
		
		((JLabel)(this.getComponent(2))).setText(((Integer)(Mapa.getInstancia().getTiempoRestante())).toString());
		
		Integer puntuacionTotal = (Mapa.getInstancia().getPuntuacionNivel() + Mapa.getPuntuacionAcumulada());
		((JLabel)(this.getComponent(3))).setText("Puntos: " + puntuacionTotal.toString());
	}
	
}