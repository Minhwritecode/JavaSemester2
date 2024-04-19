package Exercises;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Exercise1 {
	
	public static void main(String[] args) {
		new Window();
	}

}


class Window extends JFrame implements ActionListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JButton save = new JButton("Save as...");;
	JButton open = new JButton("Open");
	
	JTextArea ta = new JTextArea();
	
	JFileChooser fc;
	
	public Window() {
		// TODO Auto-generated constructor stub
		
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		save.addActionListener(this);
		open.addActionListener(this);
		
		this.getContentPane().add(save, "North");
		this.getContentPane().add(open, "South");
		this.getContentPane().add(ta, "Center");
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == open)
		{
			fc = new JFileChooser(".");
			fc.setCurrentDirectory(new java.io.File("."));
			fc.setDialogTitle("Open file");
			if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
			{
				String path = fc.getSelectedFile().getAbsolutePath();
				open(path);
			}
			
		}
		
		if (e.getSource() == save)
		{
			fc = new JFileChooser(".");
			fc.setCurrentDirectory(new java.io.File("."));
			fc.setDialogTitle("Save file as");
			if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
			{
				String path = fc.getSelectedFile().getAbsolutePath();
				saveAs(path);
				fc.rescanCurrentDirectory();
			}
			
		}
	}
	
	
	public void open(String path)
	{

		try {
			ta.setText("");
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			String s;
			while ((s = br.readLine()) != null)
			{
				ta.append(s + "\n");
			}
			fr.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void saveAs(String path)
	{
		try
		{
			String content = ta.getText();
			FileWriter f = new FileWriter(path);
			f.write(content);
			f.flush();
			f.close();
		}
		
		catch(Exception e)
		{
			e. printStackTrace();
		}
	}
	
}