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
import java.util.Map.Entry;
import java.util.UUID;

public class MindmapsToFreeMindConverter {

	// Variable privées
	private FreeMind freemind;
	private MindMaps mindmaps;
	
	// Constructeur
	public MindmapsToFreeMindConverter(MindMaps Mindmaps, String FreeMindVersion){
		this.mindmaps=Mindmaps;
		this.freemind=new FreeMind(FreeMindVersion);
	}

	// getter / setter
	public FreeMind getFreemind() {
		return freemind;
	}

	public void setFreemind(FreeMind freemind) {
		this.freemind = freemind;
	}

	public MindMaps getMindmaps() {
		return mindmaps;
	}

	public void setMindmaps(MindMaps mindmaps) {
		this.mindmaps = mindmaps;
	}
	
	// Méthodes privées
	private LinkedHashMap<String,FreeMindNode> ConvertManyNode(LinkedHashMap<UUID,MindMapsNode> ListNode){
		LinkedHashMap<String,FreeMindNode> Node = new LinkedHashMap<String,FreeMindNode>();
		for(Entry<UUID,MindMapsNode> entry : ListNode.entrySet()){
			FreeMindNode Child = ConvertOneNode(entry.getValue());
			Node.put(Child.getId().toString(), Child);
		}
		return Node;
	}
	
	private FreeMindNode ConvertOneNode(MindMapsNode SourceNode){
		String Id = SourceNode.getId().toString(); 
		String Text = SourceNode.getCaption().replace("<", "&lt;").replace(">", "&gt;").replace("&", "&amp;").replace("\"", "&quot;").replace("'", "&apos;");
		String Link = "";
		String BackgroundColor = "#ffff66"; 
		String Color = "#000000";
		Date Created = new Date();
		Date Modified = new Date(); 
		FreeMindNodeFont Font = new FreeMindNodeFont("SansSerif",SourceNode.getFont().getSize());
		FreeMindNode Node = new FreeMindNode(Id,Text, Link, BackgroundColor, Color, Created, Modified, Font);
		Node.getNode().putAll(ConvertManyNode(SourceNode.getNode()));
		return Node;
	}
	
	// Méthodes publiques
	public void Convert(){
		LinkedHashMap<UUID,MindMapsNode> Children = this.mindmaps.getNode();
		MindMapsNode RootNodeSource = Children.values().iterator().next();
		Children.values().remove(RootNodeSource);
		FreeMindNode RootNode = ConvertOneNode(RootNodeSource);
		RootNode.getNode().putAll(ConvertManyNode(Children));
		this.freemind.setRootNode(RootNode);
	}
}
