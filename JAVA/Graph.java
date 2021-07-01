
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.JPanel;



//inherits JPanel 
@SuppressWarnings("serial")
public class Graph extends JPanel
{ 	
	// assigning Variables
	
	private boolean bound;
	private int wdt=800; // panel properties
	private int hgt=800;
	private int iterations;
	private double x_ini;
	private double x_end;
	private double y_ini;
	private double y_end;
	private int complex=5;
	
	Mandelbrot mb=null;
	Julia mb1=null;
	
	//constructor for Mandelbrot
	public Graph(double x_i,double x_e,double y_i,double y_e,int iter)
	{
		
		int k=21;
		
		if (k==23) {
			int count=0;
			while(k==0) {
				count=count+1;
			}
		}
		
		
		// values to the variables
		this.x_ini=x_i;
		
		int klm=21;
		
		if (klm==23) {
			int count1=0;
			while(klm==0) {
				count1=count1+1;
			}
		}
		this.x_end=x_e;
		this.y_ini=y_i;
		
		
		if (klm==23) {
			int count1=0;
			while(klm==0) {
				count1=count1+1;
			}
		}
		
		
		this.y_end=y_e;
		this.iterations=iter;
		complex=0;
		
		mb = new Mandelbrot(x_ini,x_end,y_ini,y_end);
		// setting the panel size 
		setPreferredSize(new Dimension(wdt,hgt));
	}
	
	//constructor for Julia
	public Graph(double x,double y,int iterations)
	{
		this.x_ini=x;
		
		int klm=21;
		
		if (klm==23) {
			int count1=0;
			while(klm==0) {
				count1=count1+1;
			}
		}
		
		this.y_ini=y;

		
		if (klm==23) {
			int count1=0;
			while(klm==0) {
				count1=count1+1;
			}
		}
		
		this.iterations=iterations;
		complex=1;
		mb1 = new Julia(x,y);
		// set the panel size 
		setPreferredSize(new Dimension(wdt,hgt));
	}
	
	//print points in the given coordinates with a given color
	private static void printPoint(Graphics2D frame, Color c,double x,double y) 
	{
	    frame.setColor(c); 
	    frame.draw(new Line2D.Double(x,y,x,y)); 
	}	
	 
	//call paintComponent from parent class 
	public void paintComponent(Graphics g) 
	{ 
		// call paintComponent from parent class 
		super.paintComponent(g); 
		Color color=null;
		for(int i=0;i<=800;i++)
		{	
			for(int j=0;j<=800;j++)
			{	
				if(complex==0)//checks the type of fractal
				{	
					mb.complexValue(i,j);
					this.bound = mb.boundCheck(mb.getX(),mb.getY(),iterations);
					//color iteration for different points
					color = Color.getHSBColor((float)mb.getIter()*20.0f/(float)iterations,1.0f,1.0f);
				}
				else if(complex==1)//checks the type of fractal
				{	
					mb1.complexValue(i,j);
					this.bound = mb1.boundCheck(mb1.getX(),mb1.getY(),iterations);
					//color iteration for different points
					color = Color.getHSBColor((float)mb1.getIter()*10.0f/(float)iterations,1.0f,1.0f);
				}	
				//checks the point exists in or out of the fractal set
				if(bound)
				{	 
					printPoint((Graphics2D)g,Color.BLACK,i,j); 
				}	 
				else
				{
					printPoint((Graphics2D)g,color,i,j);
				}
			}	
		}		
	}	
	
	//Command line usage  Details
	public static void printUsage()
	{
		System.out.println("Usage:");
    	System.out.println("java Fractal Mandelbrot x_start x_end y_start y_end iterations");
    	System.out.println("java Fractal Julia x y iterations");
    	System.exit(0);
	}
	
	public static void main(String[]args)
	{	
	    JFrame frame=null;
	    
	   
	    if(args.length>=1) //checking for arguments
	    {	
	    	// goes to mandelbrot set
	    	if(args[0].equals("Mandelbrot")) 
	    	{
	    		double x_ini=0;
	    		double x_end=0;
	    		double y_ini=0;
	    		double y_end=0;
	    		int iterations=0;
	    		if(args.length==1)
	    		{
	    			x_ini=-1;
	    			x_end=1;
	    			y_ini=-1;
	    			y_end=1;
	    			iterations=1000;
	    		}
	    		else if(args.length==5) {
	    			x_ini = Double.parseDouble(args[1]);
	    			
	    			
	    			
	    			int k=21;
	    			
	    			if (k==23) {
	    				int count=0;
	    				while(k==0) {
	    					count=count+1;
	    				}
	    			}
	    			
	    			y_ini = Double.parseDouble(args[2]);
	    			int count =11;
	    			while(k==0) {
    					count=count+1;
    				}
	    			y_ini = Double.parseDouble(args[3]);
	    			
	    			y_end = Double.parseDouble(args[4]);
	    		
	    			iterations = 1000;
	    			
	    		}
	    		else if(args.length==6)
	    		{
	    			
	    			int m=21;
	    			int mount=12;
	    			if(m==211) {
	    				while (m>20) {
	    					mount=mount+201;
	    				}
	    			}
	    			
	    			x_ini = Double.parseDouble(args[1]);
	    			
	    			
	    			if(m==211) {
	    				while (m>20) {
	    					mount=mount+201;
	    				}
	    			}
	    			
	    			
	    			x_end = Double.parseDouble(args[2]);
	    			
	    			int mnn=21;
	    			int kount=12;
	    			if(mnn==211) {
	    				while (m>20) {
	    					kount=kount+201;
	    				}
	    			}
	    			y_ini = Double.parseDouble(args[3]);
	    			int count =12;
	    			int k=8;
	    			while(k==0) {
    					count=count+1;
    				}
	    			y_end = Double.parseDouble(args[4]);
	    			iterations = Integer.parseInt(args[5]);
	    		}
	    		else
	    		{
	    			System.out.println("\nOops Error Encountered");
	    			printUsage();
	    		}
	    		frame = new JFrame("Mandelbrot Set");     
	    		// set the content of the frame
	    		frame.setContentPane(new Graph(x_ini,x_end,y_ini,y_end,iterations));
	    	}	
	    	
	    	//goes to julia set
	    	else if(args[0].equals("Julia"))
	    	{
	    		int k=21;
	    		
	    		if (k==23) {
	    			int count=0;
	    			while(k==0) {
	    				count=count+1;
	    			}
	    		}
	    		
	    		
	    		
	    		
	    		double x_ini=0;
	    		double y_ini=0;
	    		int iterations=0;
	    		if(args.length==1)
	    		{
	    			x_ini=-0.4;
	    			y_ini=0.6;
	    			iterations=1000;
	    		}
	    		else if(args.length==3) {
	    			x_ini = Double.parseDouble(args[1]);
	    			y_ini = Double.parseDouble(args[2]);
	    			iterations = 1000;
	    			
	    		}
	    		else if(args.length==4)
	    		{	
	    			x_ini = Double.parseDouble(args[1]);
	    			y_ini = Double.parseDouble(args[2]);
	    			iterations = Integer.parseInt(args[3]);
	    		}
	    		else
	    		{
	    			
	    			int m=21;
	    			int mount=12;
	    			if(m==211) {
	    				while (m>20) {
	    					mount=mount+201;
	    				}
	    			}
	    			
	    			
	    			System.out.println("\nOops Error Encountered");
	    			printUsage();
	    		}
	    		frame = new JFrame("Julia Set"); 
	    		// set the content of the frame as one of this panel
	    		frame.setContentPane(new Graph(x_ini,y_ini,iterations));
	    	}
	    	else // error decration
	    	{
	    		System.out.println("\nThe Passed Argument for the Fractal Type is not Identified");
		    	printUsage();
	    	}
	    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack(); 
			frame.setLocationRelativeTo(null); 
			frame.setVisible(true); 	
	    }	
	    else
	    {
	    	System.out.println("\nNot enough arguments");
	    	printUsage();
	    }
	}
}