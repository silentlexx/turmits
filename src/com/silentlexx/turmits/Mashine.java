package com.silentlexx.turmits;



class Mashine
//extends Thread
 {
	String nextreg;
	int nextcol;
	String text;
	Field field;

	Turmit turmit;
	data[] d;

	Mashine(){
		field = new Field();
		turmit = new Turmit();

			}
//---------------------------
	boolean parse(){
		if(text.isEmpty()!=true){



			String[] t = text.split("[ \\n]+");
			int l=t.length;
			int s=(int)((l/5)+1);
			d = new data[s];
			data.lines=0;
			for (int i = 0; i < l; i=i+5){
              try {
				d[data.lines]=new data();
				d[data.lines].regA=t[i];
				d[data.lines].colA=Integer.parseInt(t[i+1]);
				d[data.lines].colB=Integer.parseInt(t[i+2]);
				d[data.lines].way=Integer.parseInt(t[i+3]);
				d[data.lines].regB=t[i+4];
				 data.lines++;

              } catch (Throwable e){
            	  
            	  Main.gui.ShowMessage("Ошибка в строке "+(data.lines+1));
            	 //System.out.println("Ошибка в строке "+ data.lines);
            	  Main.setRunning(false);
            	  Main.setNew();
            	 return false;
              }

	      		}
			nextstep(0);

			return true;


		} else return false;
	}
//--------------------------
	private void nextstep(int i){

		field.setCol(turmit.getX(), turmit.getY(), d[i].colB);
		turmit.Step(d[i].way);
		nextreg=d[i].regB;

	}


//--------------------------
	public boolean doStep(){
	  if(turmit.Where(4, 4, Main.xsize-4, Main.ysize-4)){
		for (int i=0; i < data.lines; i++){
			if(d[i].regA.compareTo(nextreg)==0){
		       if(field.compareCol(turmit.getX(), turmit.getY(), d[i].colA)){
		      	nextstep(i);
			    return true;
		       }
			 }

		}
		Main.setRunning(false);
		return false;
	  }
	  else {
		  Main.setRunning(false);
		return false;
	  }
	}

//--------------------------


//--------------------------
	public boolean setParse(String s){
		text = s;
		return parse();
	}

}
