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

import java.util.Date;
import java.util.LinkedHashMap;

public class FreeMindNode {

	// Variables privées
	private String id;
	private String text;
	private String link;
	private String backgroundColor;
	private String color;
	private Date created;
	private Date modified;
	private FreeMindNodeFont font;
	private LinkedHashMap<String,FreeMindNode> node = new LinkedHashMap<String,FreeMindNode>();
	
	// Constructeur
	public FreeMindNode(String Id, String Text, String Link, String BackgroundColor, String Color, Date Created, Date Modified, FreeMindNodeFont Font){
		this.id=Id;
		this.text=Text;
		this.link=Link;
		this.backgroundColor=BackgroundColor;
		this.color=Color;
		this.created=Created;
		this.modified=Modified;
		this.font=Font;
	}

	public FreeMindNode() {
	}

	// getter / setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public FreeMindNodeFont getFont() {
		return font;
	}

	public void setFont(FreeMindNodeFont font) {
		this.font = font;
	}

	public LinkedHashMap<String,FreeMindNode> getNode() {
		return node;
	}

	public void setNode(LinkedHashMap<String,FreeMindNode> node) {
		this.node = node;
	}
	
	// Méthode publique
	public String toXML(){
		StringBuilder retour = new StringBuilder();
		retour.append("<node ");
		retour.append("ID=\"");
		retour.append(this.id);
		retour.append("\" ");
		retour.append("TEXT=\"");
		retour.append(this.text);
		retour.append("\" ");
		retour.append(">\n");
		retour.append(this.font.toXML());
		retour.append("\n");
		for(FreeMindNode Child : this.node.values()){
			retour.append(Child.toXML());
		}
		retour.append("</node>\n");
		return retour.toString();
	}
	
}
