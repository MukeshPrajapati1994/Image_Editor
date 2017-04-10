 public void makeImageSepia(BufferedImage image,int h,int w)
  {
	  for(int y=0;y<h;y++)
	  {
		  for(int x=0;x<w;x++)
		  {
			  int p=image.getRGB(x, y);
			  int a=(p>>24)&0xff;
			  int r=(p>>16)&0xff;
			  int g=(p>>8)&0xff;
			  int b=p&0xff;
			  
			  int tr=(int)(0.393*r+0.769*g+0.189*b);
			  int tg=(int)(0.349*r+0.686*g+0.168*b);
			  int tb=(int)(0.272*r+0.534*g+0.131*b);
			  if(tr>255)
			  {
				  r=255;
			  }
			  else 
				  r=tr;
			  if(tg>255)
			  {
				  r=255;
			  }
			  else 
				  r=tg;
			  if(tb>255)
			  {
				  r=255;
			  }
			  else 
				  r=tb;
			  p=(a<<24) | (r<<16) |(g<<8) | b;
			  image.setRGB(x, y, p);
			  
		  }
		  
	  }
  }
  public void convertSepia()
  {
	  BufferedImage bi;
	    if(actionSlided || actionResized || actionRotated || drawn){
	     bi=bufimg;     
	    }
	    else{
	     bi=BufferedImg;
	    }
	    
	    makeImageSepia(bi,bi.getHeight(),bi.getWidth());
        
	    actionSepia=true; //set the actionSepia to true to indicate that 
	    repaint();
	  
  }
  
  public void makeImageGreyscale(BufferedImage image,int h,int w)
  {
	  for(int x=0;x<w;x++)
	  {
		  for(int y=0;y<w;y++)
		  {
			  Color c=new Color(image.getRGB(y, x));
			  int r=c.getRed();
			  int g=c.getGreen();
			  int b=c.getBlue();
			  int a=c.getAlpha();
			  int gr=(r+g+b)/3;
			  Color gcolor=new Color(gr,gr,gr,a);
			  image.setRGB(y, x, gcolor.getRGB());
			  
		  }
	  }
	  
  }
  public void convertGreyscale()
  {
	  BufferedImage bi;
	    if(actionSlided || actionResized || actionRotated || drawn){
	     bi=bufimg;     
	    }
	    else{
	     bi=BufferedImg;
	    }
	    
	    makeImageGreyscale(bi,bi.getHeight(),bi.getWidth());
      
	    actionGreyscale=true; //set the actionSepia to true to indicate that 
	    repaint();
	  
  }