
/**
 * Write a description of Inversions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
public class Inversions {
    public ImageResource makeInversion (ImageResource inImage){  
    ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        for (Pixel pixel: outImage.pixels()) {
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            pixel.setRed(255-inPixel.getRed());
            pixel.setBlue(255-inPixel.getBlue());
            pixel.setGreen(255-inPixel.getBlue());
    }
    return outImage;
    }

    public void selectAndConvert(){
        DirectoryResource directory = new DirectoryResource();
	for(File file: directory.selectedFiles()){
            ImageResource image = new ImageResource(file);
            ImageResource invertedImage = makeInversion(image);
            String fname = image.getFileName();
            String newName = "inverted-"+ fname;
            invertedImage.setFileName(newName);
            invertedImage.draw();
            invertedImage.save();		
	}
    }

    }
