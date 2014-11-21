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

public class Paire<T, U> {

	//Variables privées
	private T cle;
	private U valeur;
	
	// Constructeur
	public Paire(T t, U u){
		this.cle= t;
		this.valeur=u;
	}

	// Propriétés
	public T getCle() {
		return this.cle;
	}

	public void setCle(T t) {
		this.cle = t;
	}

	public U getValeur() {
		return this.valeur;
	}

	public void setValeur(U u) {
		this.valeur = u;
	}
}
