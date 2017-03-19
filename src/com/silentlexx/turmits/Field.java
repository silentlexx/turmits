package com.silentlexx.turmits;

class Field {
	public int xsize;
	public int ysize;

	
	int f[][];
//---------------------------------------------	
	Field(){
		xsize = Main.xsize;
		ysize = Main.ysize;
		f = new int[xsize][ysize];
		clean();
	}
//---------------------------------------------	
	boolean chxy(int x,int y){
		if(x>0 && y>0 && x<xsize && y<ysize){
			return true;
		} 
		else {
			return false;
		}
	}
//---------------------------------------------	
	public void clean(){

		for(int y=0;y<=ysize;y++){
			for(int x=0;x<=xsize;x++){
				setCol(x,y,0);
			}
		}
	}
//---------------------------------------------	
	public boolean setCol(int x,int y,int c){
	   if(chxy(x,y)){  
		f[x][y] = c;
		return true;
	   }
	   else {
		   return false;
	   }
	}
//---------------------------------------------	
	public int getCol(int x,int y){
		   if(chxy(x,y)){  
				return f[x][y];
			   }
			   else {
				   return -1;
			   }
	}
//---------------------------------------------	
	public boolean compareCol(int x,int y,int c){
			   if(chxy(x,y)){  
				if(f[x][y] == c){
				return true;
				} 
				else {
					return false;
				}
			   }
			   else {
				   return false;
			   }
	}
//---------------------------------------------

}
