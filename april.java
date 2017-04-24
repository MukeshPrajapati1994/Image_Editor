 // this method has algorithm for converting image into sepia
  public void makeImageSepia(BufferedImage image,int height,int width)
  {
	  for(int y=0;y<height;y++)//outer loop to get each pixel
	  {
		  for(int x=0;x<width;x++) //inner loop to get each pixel
		  {
			  int rgbcolor=image.getRGB(x, y);// get the rgb color value
			  int alpha=(rgbcolor>>24)&0xff; //get the alpha color value
			  int red=(rgbcolor>>16)&0xff;  // get the red color value
			  int green=(rgbcolor>>8)&0xff; // get the green color value
			  int blue=rgbcolor&0xff; //get the blue color value
			  
			  int new_red=(int)(0.393*red+0.769*green+0.189*blue); //calculate new red color value
			  int new_green=(int)(0.349*red+0.686*green+0.168*blue); //calculate new green color value
			  int new_blue=(int)(0.272*red+0.534*green+0.131*blue); //calculate new blue color value
			  if(new_red>255) // 255 is maximum value for any color
			  {
				  red=255;
			  }
			  else 
				  red=new_red;
			  if(new_green>255) // 255 is maximum value for any color
			  {
				  green=255;
			  }
			  else 
				  green=new_green;
			  if(new_blue>255) // 255 is maximum value for any color
			  {
				  blue=255;
			  }
			  else 
				  blue=new_blue;
			  rgbcolor=(alpha<<24) | (red<<16) |(green<<8) | blue; // make new rgb color
			  image.setRGB(x, y, rgbcolor); // set new rgb color to the image
			  
		  }
		  
	  }
  }
  //this method will get the buffer image
  public void convertSepia()
  {
	  BufferedImage bi;
	    if(actionSlided || actionResized || actionRotated || drawn){
	     bi=bufimg;   //store image in buffered image bi  
	    }
	    else{
	     bi=BufferedImg; //store image in buffered image bi 
	    }
	    
	    makeImageSepia(bi,bi.getHeight(),bi.getWidth());//call the method that will do all the filtering work
        
	    actionSepia=true; //set the actionSepia to true to indicate that 
	    repaint();
	  
  }
  // this method conatains algorithm for grayscale filter
  public void makeImageGreyscale(BufferedImage image,int height,int width)
  {
	  for(int x=0;x<height;x++) // outer loop to get each pixel
	  {
		  for(int y=0;y<width;y++) // inner loop to get each pixel
		  {
			  Color color=new Color(image.getRGB(y, x)); // get the rgb color value
			  int red=color.getRed(); // get the red color
			  int green=color.getGreen(); // get the green color
			  int blue=color.getBlue();  // get the blue color
			  int alpha=color.getAlpha(); // get the alpha channel
			  int average_color=(red+green+blue)/3; // get the average value of the red, green and blue color values
			  Color rgb_color=new Color(average_color,average_color,average_color,alpha); // make new rgb color value
			  image.setRGB(y, x, rgb_color.getRGB()); //set the new rgb color value to the image
			  
		  }
	  }
	  
  }
  public void convertGreyscale()
  {
	  BufferedImage bi;
	    if(actionSlided || actionResized || actionRotated || drawn){
	     bi=bufimg;     //store image in buffered image bi 
	    }
	    else{
	     bi=BufferedImg;  //store image in buffered image bi 
	    }
	    
	    makeImageGreyscale(bi,bi.getHeight(),bi.getWidth()); // call the method that has algorithm for grayscale conversion
      
	    actionGreyscale=true; //set the actionSepia to true to indicate that 
	    repaint();
	  
  }
