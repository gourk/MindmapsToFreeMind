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
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Run {
	
	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("\n\nVeuillez saisir le nom de fichier à convertir : ");
		String FileName=input.nextLine();
		
		try{
			JsonToMindMaps mindmaps = new JsonToMindMaps(FileName);
			MindmapsToFreeMindConverter converter = new MindmapsToFreeMindConverter(mindmaps.getMindmaps(), "0.9.0");
			converter.Convert();
			PrintWriter writer = new PrintWriter(FileName+".mm","UTF-8");
			writer.print(converter.getFreemind().toXML());
			writer.close(); 
		}
		catch (FileNotFoundException | UnsupportedEncodingException e1) {
			System.out.println("Exception : " + e1.getCause() + " " + e1.getMessage());
		}
		catch(Exception e){
			System.out.println("Exception : " + e.getCause() + " " + e.getMessage());
		}
		finally{
			input.close();
		}
	}

}
