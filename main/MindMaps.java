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
import java.util.Map;
import java.util.UUID;

public class MindMaps {
	
	// Variables privées
	private UUID id;
	private String title;
	private LinkedHashMap<UUID,MindMapsNode> node = new LinkedHashMap<UUID,MindMapsNode>();
	private Date created;
	private Date modified;
	private Couple<Integer> dimension = new Couple<Integer>(); 
	private boolean autosave;
	
	// Constructeur
	public MindMaps(UUID Id, String Title, Date Created, Date Modified, Couple<Integer> Dimension, boolean Autosave){
		this.id=Id;
		this.title=Title;
		this.created=Created;
		this.modified=Modified;
		this.dimension = Dimension;
		this.autosave=Autosave;
	}
	
	// getter / setter
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LinkedHashMap<UUID,MindMapsNode> getNode() {
		return node;
	}
	public void setNode(LinkedHashMap<UUID,MindMapsNode> node) {
		this.node = node;
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
	public int getDimensionX() {
		return dimension.getPremier();
	}
	public void setDimensionX(int X) {
		this.dimension.setPremier(X);
	}
	public int getDimensionY() {
		return dimension.getSecond();
	}
	public void setDimensionY(int Y) {
		this.dimension.setSecond(Y);
	}
	public boolean isAutosave() {
		return autosave;
	}
	public void setAutosave(boolean autosave) {
		this.autosave = autosave;
	}
	
	
	// Méthodes publiques
	public String toString(){
		StringBuilder retour = new StringBuilder();
		retour.append(this.title);
		retour.append(" (");
		retour.append(this.id);
		retour.append(")\n");
		for(Map.Entry<UUID, MindMapsNode> entry : this.node.entrySet()){
			retour.append(entry.getValue().toString());
		}
		return retour.toString();
	}
}
