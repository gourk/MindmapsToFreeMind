/*
 * MindmapsToFreemind
 * Copyright (C) 2014 Yoann Calamai
 * 
 * See COPYING for Details
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 * 
 * Created on 2014.11.21
 */

package mindmapstofreemind.main;

public class Couple<T> {

	//Variables privées
	private Paire<T,T> paire;
	
	// Constructeur
	public Couple(){}	
	public Couple(T t1, T t2){
		this.paire = new Paire<T,T>(t1,t2);
	}

	// Getter / Setter
	public T getPremier() {
		return this.paire.getCle();
	}

	public void setPremier(T valeur) {
		this.paire.setCle(valeur);
	}
	
	public T getSecond() {
		return this.paire.getValeur();
	}

	public void setSecond(T valeur) {
		this.paire.setValeur(valeur);
	}
}
