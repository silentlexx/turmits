package com.silentlexx.turmits;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


class Painter {
	int xsize;
	int ysize;
	Color color[];
	Field field;
	BufferedImage img;
	Graphics2D g;
	
	Painter(){
		
		
		color = new Color[] {
				new Color(0x000000),
				new Color(0x0000AA),
				new Color(0x00AA00),
				new Color(0x00AAAA),
				new Color(0xAA0000),
				new Color(0xAA00AA),
				new Color(0xAA5500),
				new Color(0xAAAAAA),
				new Color(0x555555),
				new Color(0x5555FF),
				new Color(0x55FF55),
				new Color(0x55FFFF),
				new Color(0xFF5555),
				new Color(0xFF55FF),
				new Color(0xFFFF55),
				new Color(0xFFFFFF)		
		};

				
				
		setSize(Main.xsize,Main.ysize);
		img = new BufferedImage(xsize,ysize,BufferedImage.TYPE_INT_RGB);
		g = img.createGraphics();
	}

	private Color getC(int c){
		if(c>=0 && c<=16){
		return color[c];
		} 
		else {
			return color[0];
		}
	}
	
	public void setSize(int x,int y){
		xsize = x;
		ysize = y;	
	}
	
    public void Paint(Graphics2D gr){
    	
                
    	
        
    	g.setPaint(getC(0));
    	g.fillRect(0, 0, xsize,ysize);

		for(int y=0;y<=ysize;y++){
			for(int x=0;x<=xsize;x++){
				if(field.getCol(x, y)!=0){
					g.setPaint(getC(field.getCol(x, y)));
//			    	g.fillRect(x, y, 1, 1);
					g.drawLine(x, y, x, y);
				}
				
			}
		}
	
		gr.drawImage(img, null, 0, 0);
		
    }
    
    public void setField(Field f){
    	field =f ;
    }
}
