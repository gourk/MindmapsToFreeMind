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

public class MindMapsNodeFont {

	// variables privées
	private String style;
	private String weight;
	private String decoration;
	private Integer size;
	private String color;
	
	// Constructeur
	public MindMapsNodeFont(String Style, String Weight, String Decoration, Integer Size, String Color){
		this.style = Style;
		this.weight = Weight;
		this.decoration = Decoration;
		this.size = Size;
		this.color = Color;
	}
	
	// getter / setter
	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getDecoration() {
		return decoration;
	}

	public void setDecoration(String decoration) {
		this.decoration = decoration;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	// Méthodes publiques
	public String toString(){
		StringBuilder retour = new StringBuilder();
		retour.append("Style=");
		retour.append(this.style);
		retour.append(" Weight=");
		retour.append(this.weight);
		retour.append(" Decoration=");
		retour.append(this.decoration);
		retour.append(" Size=");
		retour.append(this.size);
		retour.append(" Color=");
		retour.append(this.color);
		retour.append(")\n");
		return retour.toString();
	}
	
	
}
