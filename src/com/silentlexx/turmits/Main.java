package com.silentlexx.turmits;






import java.awt.Graphics2D;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {
	public static int xsize = 600;
	public static int ysize = 600;
	static int slow = 1;
	static Gui gui;
	static Painter paint;
	static boolean first;
	static boolean running = false;
	private static Mashine mashina;



public static boolean isRunning(){
		   return running;
		}
//---------------------------------------
    static void guiStart(){
	/*
    	try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	*/
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Gui app = new Gui();
				app.getJFrame().setVisible(true);
				gui = app;
			}
		});
    }


//----------------------------------------
public static void Paint(Graphics2D g){
   if(first==false){
	paint.Paint(g);
   }
}
//----------------------------------------


//-----------------------------------------

//---------------------------------------
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		New();
		guiStart();
		paint = new Painter();

	}
//----------------------------
	static void runThreads(){

		 new Thread(new Runnable() {
			  public void run() {
			   try {
				boolean r=running;
			    while(r && running){
				 Thread.sleep(slow);
			      r=mashina.doStep();
			    }
			     return;
			   } catch (Exception ex) {
				   New();
			   }
			  }
			 }).start();

		 new Thread(new Runnable() {
			  public void run() {
			   try {

			    while(running){
				 Thread.sleep(100);
					gui.Repaint();
			    }
			    return;
			   } catch (Exception ex) {
				   New();
				   return;
			   }
			  }
			 }).start();


	}
//----------------------------------------
	public static void Start(){
	 boolean test = true;
	  if(isRunning()==false){
		if(first){

			test=mashina.setParse(gui.getCode()) ;
			paint.setField(mashina.field);
			runThreads();

			first=false;
		}
		if(test){
			  setRunning(true);
			  runThreads();
		}
	  } else {
		  setRunning(false);

	  }
	}
//----------------------------------------
public static void setNew() {
	New();

}

	static void New(){
		mashina = new Mashine();
		first=true;
		if(gui!=null){
		gui.Repaint();
		}
	}
//----------------------------------------

	static void setSpeed(int s){
		int[] sp = new int[] {10,1,0};
		  slow=sp[s];
     	}

	public static void setRunning(boolean b){
		running = b;
		gui.setStarted(b);
		gui.Repaint();
	}


}
