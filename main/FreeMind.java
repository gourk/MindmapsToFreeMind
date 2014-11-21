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

public class FreeMind {

	// Variables privées
	private String version;
	private FreeMindNode rootNode = new FreeMindNode();
	
	// Constructeur
	public FreeMind(String Version){
		this.version=Version;
	}

	// getter / setter
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public FreeMindNode getRootNode() {
		return rootNode;
	}

	public void setRootNode(FreeMindNode node) {
		this.rootNode = node;
	}
	
	// Méthode publique
		public String toXML(){
			StringBuilder retour = new StringBuilder();
			retour.append("<map ");
			retour.append("version=\"");
			retour.append(this.version);
			retour.append("\" ");
			retour.append(">\n");
			retour.append(this.rootNode.toXML());
			retour.append("</map>");			
			return retour.toString();
		}
}
