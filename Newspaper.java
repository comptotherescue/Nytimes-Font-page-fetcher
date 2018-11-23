import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Newspaper {
public static void main(String arg[]){
	Date d=new Date();
	String date=new SimpleDateFormat("yyyy/MM/dd").format(d);
	String date1=new SimpleDateFormat("yyyy.MM.dd").format(d);
	String url1="http://www.nytimes.com/images/"+date+"/nytfrontpage/scan.pdf";
	URL url = null;
	int bl;
	try {
		url = new URL(url1);
	
	byte[] by=new byte[1024];
	String fi1="nytime"+date1+".pdf";
	File f1=new File(fi1);
	
	try {
		
		FileOutputStream out=new FileOutputStream(f1);
		System.out.print("Connecting to " + url.toString() + " ... ");
		
		try {
			
			 
					
					 InputStream in=url.openStream();
					 
					 while((bl=in.read(by))!=-1){
						 out.write(by,0,bl);
					 }
					 in.close();
					 out.flush();
					 out.close();
					 System.out.print("DONE.\nProcessing the PDF ... ");
					
				 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	} catch (MalformedURLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
}
}
