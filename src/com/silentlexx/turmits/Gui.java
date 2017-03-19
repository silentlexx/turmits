package com.silentlexx.turmits;


import java.awt.BorderLayout;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.JTextArea;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.io.Reader;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.filechooser.FileFilter;
import javax.swing.JRadioButton;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import java.awt.SystemColor;



public class Gui {

	private JFrame jFrame = null;  //  @jve:decl-index=0:visual-constraint="10,10"
	private JPanel jContentPane = null;
	private JPanel jPole = null;
	private JTextArea jCode = null;
	private JPanel jPanel = null;
	private JButton jStart = null;
	private JButton jNew = null;
	private JButton jOpen = null;
	private JOptionPane messbox = null;
	Graphics2D gr;
	String curdir = ".";
	final String appname = "Тьюрмиты v.0.2.1 ";

	/**
	 * This method initializes jFrame
	 *
	 * @return javax.swing.JFrame
	 */
	JFrame getJFrame() {
		if (jFrame == null) {

			myFile.setFileSelectionMode(JFileChooser.OPEN_DIALOG);
			myFile.setControlButtonsAreShown(true);
			myFile.setDialogType(JFileChooser.OPEN_DIALOG);
			jFrame = new JFrame();
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jFrame.setSize(760, 680);
			jFrame.setPreferredSize(new Dimension(760, 680));
			jFrame.setMinimumSize(new Dimension(760, 680));
			jFrame.setResizable(false);
			jFrame.setContentPane(getJContentPane());
			jFrame.setTitle(appname);
		}
		return jFrame;
	}

	private JOptionPane getmessbox(String s){
		if (messbox == null) {
			messbox = new JOptionPane();
			messbox.setEnabled(true);
			JOptionPane.showMessageDialog(jFrame, s,   "Ошибка!",JOptionPane.ERROR_MESSAGE);
		
		}
		return messbox;
	}

	 public void ShowMessage(String s) {
		   getmessbox(s);
		   messbox=null;

	 }
	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJPole(), BorderLayout.WEST);
			jContentPane.add(getJPanel(), BorderLayout.SOUTH);
			jContentPane.add(getJPanel4(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPole
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPole() {
		if (jPole == null) {
			jPole = new JPanel(){
				/**
				 *
				 */

				private static final long serialVersionUID = 1L;

				protected void paintComponent(Graphics g) {
			        super.paintComponent(g);
			        gr = (Graphics2D) g;
			        Main.Paint(gr);
			   	};
			};
			jPole.setLayout(new GridBagLayout());
			jPole.setPreferredSize(new Dimension(600, 600));
			jPole.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
			jPole.setBackground(Color.black);

		}
		return jPole;
	}

	/**
	 * This method initializes jCode
	 *
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJCode() {
		if (jCode == null) {
			jCode = new JTextArea();
			jCode.setPreferredSize(new Dimension(100, 600));
			jCode.setTabSize(8);
			jCode.setColumns(1);
			jCode.setRows(1);
			jCode.setText("A 0 14 0 B\nB 0 14 0 C\nC 0 14 0 E\nE 0 14 0 F\nF 0 14 0 J\nJ 0 13 -1 A\nA 14 13 0 A\nA 13 14 0 A\nJ 14 13 0 A\nJ 13 14 1 A");
		}
		return jCode;
	}

	/**
	 * This method initializes jPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 0;
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel.setPreferredSize(new Dimension(740, 50));
			jPanel.add(getJStart(), gridBagConstraints);
			jPanel.add(getJPanel1(), new GridBagConstraints());
			jPanel.add(getJNew(), gridBagConstraints1);
			jPanel.add(getJPanel2(), new GridBagConstraints());
			jPanel.add(getJOpen(), new GridBagConstraints());
		//	jPanel.add(getjOpenFile(), new GridBagConstraints());
			jPanel.add(getJSave(), new GridBagConstraints());
			jPanel.add(getJPanel3(), gridBagConstraints11);
			jPanel.add(getJImg(), gridBagConstraints21);

		}
		return jPanel;
	}

	/**
	 * This method initializes jStart
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJStart() {
		if (jStart == null) {
			jStart = new JButton();
			jStart.setText("Старт");
			jStart.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Main.Start();
				}
			});
		}
		return jStart;
	}

//------------------------------------
	public String getCode(){
		return jCode.getText();
	}
//-----------------------------------
	public void Repaint(){
		jPole.repaint();
	}
//----------------------------------
	public void setStarted(boolean b){
		if(b){
			jStart.setText("Стоп");
			jNew.setEnabled(false);
			jOpen.setEnabled(false);
			jSave.setEnabled(false);
			jImg.setEnabled(false);
			jCode.setEditable(false);
		} else {
			jCode.setEditable(true);
			jOpen.setEnabled(true);
			jImg.setEnabled(true);
			jSave.setEnabled(true);
			jNew.setEnabled(true);
			jStart.setText("Старт");
		}
	}
//-------------------------------------------------

	public void readRes(){

	}

//--------------------------------------------------
	/**
	 * This method initializes jNew
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJNew() {
		if (jNew == null) {
			jNew = new JButton();
			jNew.setText("Очистить");
			jNew.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Main.setNew();


				}
			});
		}
		return jNew;
	}

	/**
	 * This method initializes jOpen
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJOpen() {
		if (jOpen == null) {
			jOpen = new JButton();
			jOpen.setText("Открыть мозг");
			jOpen.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
				    File dir = null;
					try {
					    dir = new File(new File(curdir).getCanonicalPath());
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					myFile.setCurrentDirectory(dir);
					myFile.setDialogTitle("Открыть мозг");

					FileFilter filter = new ExtensionFileFilter("Файл мозга в *.txt , *.brn", new String[] { "txt", "TXT","brn", "BRN" });
					myFile.setFileFilter(filter);
					int rev=myFile.showOpenDialog(jFrame);
					if(rev==JFileChooser.APPROVE_OPTION){
						try {
							curdir=myFile.getCurrentDirectory().getCanonicalPath();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}

					File file = myFile.getSelectedFile();
					if(file!=null){
					 Reader reader = null;
					try {
						reader = new FileReader(file);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						jCode.read(reader, null);
						jFrame.setTitle(appname+" -- "+file.getCanonicalPath());
						Main.setNew();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					}
					}
				}
			});
		}
		return jOpen;
	}
//------------------------------------------------------------

//	                File file = _fileChooser.getSelectedFile();


//-----------------------------------------------------------
	JFileChooser myFile = new JFileChooser(){
	    /**
		 *
		 */

		private static final long serialVersionUID = 1L;

		protected JDialog createDialog(Component parent) throws HeadlessException {
	        JDialog dialog = super.createDialog(parent);
	        dialog.setResizable(true);
	        return dialog;
	    }


	};
	private JButton jSave = null;
	private JPanel jPanel1 = null;
	private JPanel jPanel2 = null;
	private JRadioButton speed0 = null;
	private JRadioButton speed1 = null;
	private JRadioButton speed2 = null;
	private JPanel jPanel3 = null;
	private JButton jImg = null;
	private JPanel jPanel4 = null;
	private JTextArea jTextArea = null;
	/**
	 * This method initializes jSave
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJSave() {
		if (jSave == null) {
			jSave = new JButton();
			jSave.setText("Сохранить мозг");
			jSave.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
				    File dir = null;
					try {
					    dir = new File(new File(curdir).getCanonicalPath());
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					myFile.setCurrentDirectory(dir);
					myFile.setDialogTitle("Сохранить мозг");
					FileFilter filter = new ExtensionFileFilter("Файл мозга в *.txt , *.brn", new String[] { "txt", "TXT","brn", "BRN" });
					myFile.setFileFilter(filter);
					int rev=myFile.showSaveDialog(jFrame);
					if(rev==JFileChooser.APPROVE_OPTION){
						try {
							curdir=myFile.getCurrentDirectory().getCanonicalPath();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					File file = myFile.getSelectedFile();
					if(file!=null){
					 FileWriter writer = null;
						try {
							writer = new FileWriter(file);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							jCode.write(writer);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
					}

				}
			});
		}

		return jSave;

     }

	/**
	 * This method initializes jPanel1
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			jPanel1 = new JPanel();
			jPanel1.setLayout(new GridBagLayout());
			jPanel1.setPreferredSize(new Dimension(200, 30));
			jPanel1.add(getSpeed0(), gridBagConstraints2);
			jPanel1.add(getSpeed1(), new GridBagConstraints());
			jPanel1.add(getSpeed2(), new GridBagConstraints());
		}
		return jPanel1;
	}

	/**
	 * This method initializes jPanel2
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jPanel2 = new JPanel();
			jPanel2.setLayout(new GridBagLayout());
			jPanel2.setPreferredSize(new Dimension(40, 30));
		}
		return jPanel2;
	}

	/**
	 * This method initializes speed0
	 *
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getSpeed0() {
		if (speed0 == null) {
			speed0 = new JRadioButton();
			speed0.setText("Мед.");
			speed0.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(speed0.isSelected()==false){
						speed0.setSelected(true);
					}
					speed1.setSelected(false);
					speed2.setSelected(false);
					//speed3.setSelected(false);
				 Main.setSpeed(0);
				}
			});
		}
		return speed0;
	}

	/**
	 * This method initializes speed1
	 *
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getSpeed1() {
		if (speed1 == null) {
			speed1 = new JRadioButton();
			speed1.setText("Норм.");
			speed1.setSelected(true);
			speed1.setMnemonic(KeyEvent.VK_UNDEFINED);
			speed1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(speed1.isSelected()==false){
						speed1.setSelected(true);
					}
					speed0.setSelected(false);
					speed2.setSelected(false);
					//speed3.setSelected(false);
					Main.setSpeed(1);
				}
			});
		}
		return speed1;
	}

	/**
	 * This method initializes speed2
	 *
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getSpeed2() {
		if (speed2 == null) {
			speed2 = new JRadioButton();
			speed2.setText("Быст.");
			speed2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(speed2.isSelected()==false){
						speed2.setSelected(true);
					}
					speed0.setSelected(false);
					speed1.setSelected(false);
					//speed3.setSelected(false);
					Main.setSpeed(2);
				}
			});
		}
		return speed2;
	}

	/**
	 * This method initializes jPanel3
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel3() {
		if (jPanel3 == null) {
			jPanel3 = new JPanel();
			jPanel3.setLayout(new GridBagLayout());
			jPanel3.setPreferredSize(new Dimension(20, 30));
		}
		return jPanel3;
	}

	/**
	 * This method initializes jImg
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJImg() {
		if (jImg == null) {
			jImg = new JButton();
			jImg.setText("Сохр. Рис.");
			jImg.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {

				    File dir = null;
					try {
					    dir = new File(new File(curdir).getCanonicalPath());
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					myFile.setCurrentDirectory(dir);
					myFile.setDialogTitle("Сохранить изображение");
					FileFilter filter = new ExtensionFileFilter("Файл изображение в *.png", new String[] { "png", "PNG" });
					myFile.setFileFilter(filter);
					int rev=myFile.showSaveDialog(jFrame);
					if(rev==JFileChooser.APPROVE_OPTION){
						try {
							curdir=myFile.getCurrentDirectory().getCanonicalPath();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					File file = myFile.getSelectedFile();
					if(file!=null){
						try {
							saveComponentAsPNG(jPole,file.toString());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					}
				}
			});
		}
		return jImg;
	}


	@SuppressWarnings("unchecked")
	public void saveComponentAsPNG(Component myComponent, String filename) throws IOException {
	    Dimension size = myComponent.getSize();
	    BufferedImage bi =
	      new BufferedImage(size.width, size.height,
	      BufferedImage.TYPE_INT_RGB);
	    Graphics2D g2 = bi.createGraphics();
	    myComponent.paint(g2);
	    ImageWriter writer = null;
	    try {

	        Iterator writers = ImageIO.getImageWritersByFormatName("png");
	         writer = (ImageWriter)writers.next();



	        File f = new File(filename);
	        ImageOutputStream ios = ImageIO.createImageOutputStream(f);
	        writer.setOutput(ios);

	    }
	    finally{


	        writer.write(bi);


	    }
	}

	/**
	 * This method initializes jPanel4
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel4() {
		if (jPanel4 == null) {
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.fill = GridBagConstraints.BOTH;
			gridBagConstraints4.weighty = 1.0;
			gridBagConstraints4.weightx = 1.0;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.fill = GridBagConstraints.BOTH;
			gridBagConstraints3.gridy = 0;
			gridBagConstraints3.weightx = 1.0;
			gridBagConstraints3.weighty = 1.0;
			gridBagConstraints3.gridx = 0;
			jPanel4 = new JPanel();
			jPanel4.setLayout(new GridBagLayout());
			jPanel4.setPreferredSize(new Dimension(10, 600));
			jPanel4.add(getJTextArea(), gridBagConstraints3);
			jPanel4.add(getJCode(), gridBagConstraints4);
		}
		return jPanel4;
	}

	/**
	 * This method initializes jTextArea
	 *
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextArea() {
		if (jTextArea == null) {
			jTextArea = new JTextArea();
			jTextArea.setPreferredSize(new Dimension(10, 600));
			jTextArea.setEditable(false);
			jTextArea.setBackground(SystemColor.controlHighlight);
			jTextArea.setText("1. \n2. \n3. \n4. \n5. \n6. \n7. \n8. \n9. \n10.\n11.\n12.\n13.\n14.\n15.\n16.\n17.\n18.\n19.\n20.\n21.\n22.\n23.\n24.\n25.\n26.\n27.\n28.\n29.\n30.\n31.\n32.\n33.\n34.\n35.\n36.\n37.\n38.\n39.\n40.\n");
		}
		return jTextArea;
	}

}

class ExtensionFileFilter extends FileFilter {
  String description;

  String extensions[];

  public ExtensionFileFilter(String description, String extension) {
    this(description, new String[] { extension });
  }

  public ExtensionFileFilter(String description, String extensions[]) {
    if (description == null) {
      this.description = extensions[0];
    } else {
      this.description = description;
    }
    this.extensions = (String[]) extensions.clone();
    toLower(this.extensions);
  }

  private void toLower(String array[]) {
    for (int i = 0, n = array.length; i < n; i++) {
      array[i] = array[i].toLowerCase();
    }
  }

  public String getDescription() {
    return description;
  }

  public boolean accept(File file) {
    if (file.isDirectory()) {
      return true;
    } else {
      String path = file.getAbsolutePath().toLowerCase();
      for (int i = 0, n = extensions.length; i < n; i++) {
        String extension = extensions[i];
        if ((path.endsWith(extension) && (path.charAt(path.length() - extension.length() - 1)) == '.')) {
          return true;
        }
      }
    }
    return false;
  }
}




