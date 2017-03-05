 //The makeCompression method has code to compress the image
  //In java, you can specify the compression quality value by using the IIOImage class
  public  void makeCompression(File outFileName){
   try{
   ImageWriter imgWriter =(ImageWriter) ImageIO.getImageWritersByFormatName("jpg").next();

   //Create image output stream objects from the image files
   ImageOutputStream imgOutStrm = ImageIO.createImageOutputStream(outFileName);

   //Set the image output stream object to the writer
   imgWriter.setOutput(imgOutStrm);
  
   //wrap the image data (read from the file) in IIOImage object
   IIOImage iioImg;
   if(actionSlided || actionResized){ //bufimg not a blank buffered image
    iioImg = new IIOImage(bufimg, null,null);
    }
   else{    
    iioImg = new IIOImage(BufferedImg, null,null); //otherwise compress the original buffered image
    }

   //Create paramter for image writer
   ImageWriteParam jpgWriterParam = imgWriter.getDefaultWriteParam();

   //Set compresson mode
   jpgWriterParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);

   //Set compression quality
   jpgWriterParam.setCompressionQuality(0.7f);

   //Write the image with specified parameters to the file
   imgWriter.write(null, iioImg, jpgWriterParam);

   //clean objects
   imgOutStrm.close();
   imgWriter.dispose();
   }catch(Exception e){}
  
 