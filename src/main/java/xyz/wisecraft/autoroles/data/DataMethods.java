package xyz.wisecraft.autoroles.data;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.Material;

import xyz.wisecraft.autoroles.Main;

public class DataMethods {

	private static final Main plugin = Main.getPlugin(Main.class);
	
	
	public static void  infopPut (UUID UUID, Object[] data) {
		
		plugin.infom.put(UUID, reconvert(data)); 
		
	}
	
	public static void moreBroken(UUID UUID, Material m) { 
		
			Infop data = plugin.infom.get(UUID);
			// Check if the block is diamond ore, if true, increase number
			if (m == Material.DIAMOND_ORE) {
				int DiaBroke = 1 + data.getDiaBroke();
				 
					data.setDiaBroke(DiaBroke);
				
			}

		int BlocksBroke = 1 + data.getBlocksBroke();
			
			data.setBlocksBroke(BlocksBroke);
			
		}
	
	public static void morePlaced (UUID UUID) {
		Infop data = plugin.infom.get(UUID);
		
		int BlocksPlace = 1 + data.getBlocksPlace();
		
			data.setBlocksPlace(BlocksPlace);
		
		
	}
	
	 public static boolean writeCheck(File file)
	 {
		 //Checks if the file exists
		 
	     boolean f = true;
	     try {
	     if(!file.exists()) try
	     {
	    	 
	       if(!file.getParentFile().exists() && !file.getParentFile().mkdirs())
	       {
	         System.err.println(
	             "writeCheck error: Cannot create parent file " + file.getParentFile().getAbsolutePath());
	         f = false;
	       }
	       if(!file.createNewFile())
	       {
	         System.err.println("writeCheck error: Cannot create file " + file.getAbsolutePath());
	         f = false;
	       }
	     }
	     catch(IOException e)
	     {
	       e.printStackTrace();
	       f = false;
	     }
	     if(!file.canWrite())
	       f = false;

	     return f;
	 }
	     catch (NullPointerException e) {
	    	 
	    	 return f;
	     }
	     
	 }
			//Converstion Methods
		public static Object[] convert(Infop data) {
		//Take individuel data and assemble an array
		String name = data.getName();
		int BlocksBroke = data.getBlocksBroke();
		int BlocksPlace = data.getBlocksPlace();
		int DiaBroke = data.getDiaBroke();
		int Time = data.getTime();
		int trees = data.getTrees();
		String oldtimer = data.getOldtimer();
			return new Object[] {name, BlocksBroke, BlocksPlace, DiaBroke, Time, trees, oldtimer};}
		
		public static Infop reconvert(Object[] data) {
		// Take individuel data and assemble an Infop
		String name = (String) data[0]; 
		int BlocksBroke = (Integer) data[1];
		int BlocksPlace = (Integer) data[2];
		int DiaBroke = (Integer) data[3];
		int Time = (Integer) data[4];
		int trees = (Integer) data[5];
		String oldtimer = (String) data[6];
			return new Infop(name, BlocksBroke, BlocksPlace, DiaBroke, Time, trees, oldtimer);}
		
}
