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

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.UUID;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class JsonToMindMaps {

	// Variable privée
	private MindMaps mindmaps;
	
	// Constructeur
	public JsonToMindMaps(String FileName) throws FileNotFoundException{
		JsonReader Reader = Json.createReader(new FileReader(FileName));
		JsonObject MainObject = Reader.readObject();
		
		UUID id = UUID.fromString(MainObject.getString("id"));
		String title=MainObject.getString("title");
		
		JsonObject dateObject = MainObject.getJsonObject("dates");
		Date created = new Date(dateObject.getJsonNumber("created").longValue());
		Date modified = new Date(dateObject.getJsonNumber("modified").longValue());
		
		JsonObject dimObject = MainObject.getJsonObject("dimensions");
		Couple<Integer> Dimension = new Couple<Integer>(dimObject.getInt("x"),dimObject.getInt("y"));
		boolean autosave = MainObject.getBoolean("autosave");
		
		this.mindmaps = new MindMaps(id, title, created, modified, Dimension, autosave);
		this.BuildRootNode(MainObject.getJsonObject("mindmap"));
	}

	// getter / setter
	public MindMaps getMindmaps() {
		return mindmaps;
	}

	public void setMindmaps(MindMaps mindmaps) {
		this.mindmaps = mindmaps;
	}
	
	// Méthodes privées
	private void BuildRootNode(JsonObject Node){
		JsonObject RootNode = Node.getJsonObject("root");
		UUID Id = UUID.fromString(RootNode.getString("id"));
		JsonObject TextJson = RootNode.getJsonObject("text");
		String Caption = TextJson.getString("caption");
		JsonObject FontJson = TextJson.getJsonObject("font");
		MindMapsNodeFont Font = new MindMapsNodeFont(FontJson.getString("style"),
													FontJson.getString("weight"),
													FontJson.getString("decoration"),
													FontJson.getInt("size"),
													FontJson.getString("color"));
		JsonObject OffsetJson = RootNode.getJsonObject("offset");
		Couple<Integer> Offset = new Couple<Integer>(OffsetJson.getInt("x"),OffsetJson.getInt("y"));
		boolean FoldChildren = RootNode.getBoolean("foldChildren");
		String BranchColor = RootNode.getString("branchColor");
		MindMapsNode Root = new MindMapsNode(Id,null,Caption,Font,Offset,FoldChildren,BranchColor);
		this.mindmaps.getNode().put(Id, Root);
		JsonArray Children = RootNode.getJsonArray("children");
		this.mindmaps.getNode().putAll(this.BuildChildrenNode(Children));
	}
	
	private LinkedHashMap<UUID,MindMapsNode> BuildChildrenNode(JsonArray NodeJson){
		LinkedHashMap<UUID,MindMapsNode> Children = new LinkedHashMap<UUID,MindMapsNode>();
		for (int i=0; i<NodeJson.size(); i++){
			MindMapsNode Child = BuildChildNode(NodeJson.getJsonObject(i));
			Children.put(Child.getId(), Child);
		}
		return Children;
	}
	
	private MindMapsNode BuildChildNode(JsonObject ChildNode){
			UUID Id = UUID.fromString(ChildNode.getString("id"));
			UUID ParentId = UUID.fromString(ChildNode.getString("parentId"));
			JsonObject TextJson = ChildNode.getJsonObject("text");
			String Caption = TextJson.getString("caption");
			JsonObject FontJson = TextJson.getJsonObject("font");
			MindMapsNodeFont Font = new MindMapsNodeFont(FontJson.getString("style"),
														FontJson.getString("weight"),
														FontJson.getString("decoration"),
														FontJson.getInt("size"),
														FontJson.getString("color"));
			JsonObject OffsetJson = ChildNode.getJsonObject("offset");
			Couple<Integer> Offset = new Couple<Integer>(OffsetJson.getInt("x"),OffsetJson.getInt("y"));
			boolean FoldChildren = ChildNode.getBoolean("foldChildren");
			String BranchColor = ChildNode.getString("branchColor");
			MindMapsNode Child = new MindMapsNode(Id,ParentId,Caption,Font,Offset,FoldChildren,BranchColor);
			JsonArray Children = ChildNode.getJsonArray("children");
			if (Children!=null) Child.getNode().putAll(BuildChildrenNode(Children));
			return Child;
	}

}
