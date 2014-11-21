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

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class MindMapsNode {

	// Variables privées
	private UUID id;
	private UUID parentId;
	private String caption;
	private MindMapsNodeFont font;
	private Couple<Integer> offset = new Couple<Integer>(); 
	private boolean foldChildren;
	private String branchColor;
	private LinkedHashMap<UUID,MindMapsNode> node = new LinkedHashMap<UUID,MindMapsNode>();
	
	// Constructeur
	public MindMapsNode(UUID Id, UUID ParentId, String Caption, MindMapsNodeFont Font, Couple<Integer> Offset, boolean FoldChildren, String BranchColor){
		this.setId(Id);
		this.setParentId(ParentId);
		this.setCaption(Caption);
		this.setFont(Font);
		this.setOffset(Offset);
		this.setFoldChildren(FoldChildren);
		this.setBranchColor(BranchColor);
	}

	// Getter / setter
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getParentId() {
		return parentId;
	}

	public void setParentId(UUID parentId) {
		this.parentId = parentId;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public MindMapsNodeFont getFont() {
		return font;
	}

	public void setFont(MindMapsNodeFont font) {
		this.font = font;
	}

	public Couple<Integer> getOffset() {
		return offset;
	}

	public void setOffset(Couple<Integer> offset) {
		this.offset = offset;
	}

	public boolean isFoldChildren() {
		return foldChildren;
	}

	public void setFoldChildren(boolean foldChildren) {
		this.foldChildren = foldChildren;
	}

	public String getBranchColor() {
		return branchColor;
	}

	public void setBranchColor(String branchColor) {
		this.branchColor = branchColor;
	}

	public LinkedHashMap<UUID,MindMapsNode> getNode() {
		return node;
	}

	public void setNode(LinkedHashMap<UUID,MindMapsNode> node) {
		this.node = node;
	}
	
	// Méthodes publiques
	public String toString(){
		StringBuilder retour = new StringBuilder();
		retour.append(this.caption);
		retour.append(" (");
		retour.append(this.id);
		retour.append(")\n");
		for(Map.Entry<UUID, MindMapsNode> entry : this.node.entrySet()){
			retour.append(entry.getValue().toString());
		}
		return retour.toString();
	}
	
}
