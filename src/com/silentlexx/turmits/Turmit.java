package com.silentlexx.turmits;

class Turmit {
	int x;
	int y;
	int xway = 1;
	int yway = 0;
	
	Turmit(){
		x = (int) (Main.xsize/2);
		y = (int) (Main.ysize/2);	
	}
	
	//--------------------------
	private void left(){
		if(xway==0 && yway==-1){
			   xway= -1;   yway= 0; return;
			}  
		if(xway==-1 && yway==0){
			   xway= 0;   yway= 1; return;
			} 
		if(xway==0 && yway==1){
			   xway= 1;   yway= 0; return;
			} 
		if(xway==1 && yway==0){
			   xway= 0;   yway= -1; return;
			} 
	}
	//--------------------------
	private void right(){
		if(xway==0 && yway==-1){
			   xway= 1;   yway= 0; return;
			}  
		if(xway==1 && yway==0){
			   xway=0;   yway= 1; return;
			} 
		if(xway==0 && yway==1){
			   xway= -1;   yway= 0; return;
			} 
		if(xway==-1 && yway==0){
			   xway= 0;   yway= -1; return;
			} 		
	}
	//-------------------------
	public int getX(){
		return x;
	}
	//-------------------------
	public int getY(){
		return y;
	}
	//------------------------
	public void Step(int k){
		if(k==-1){
			left();
			k=0;
		} else 
		if(k==1){
			right();
			k=0;
		}
		if(k==0){
			x=x+xway;
			y=y+yway;
		}
		
	}
	//------------------
	public boolean Where(int x1,int y1,int x2,int y2){
	
		if(x>=x1 && y>=y1 && x<=x2 && y<=y2 ){
			return true;
		}
		
		return false;
		
	}
	
	
}
