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

public class FreeMindNodeFont {

	// variables privées
	private String name;
	private Integer size;
	
	// Constructeur
	public FreeMindNodeFont(String Name, Integer Size){
		this.name = Name;
		this.size = Size;
	}
	
	// getter / setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}
	
	// Méthode publique
		public String toXML(){
			StringBuilder retour = new StringBuilder();
			retour.append("<font ");
			retour.append("Name=\"");
			retour.append(this.name);
			retour.append("\" ");
			retour.append("SIZE=\"");
			retour.append(this.size);
			retour.append("\" ");
			retour.append("/>");
			return retour.toString();
		}
		


	
	
}
