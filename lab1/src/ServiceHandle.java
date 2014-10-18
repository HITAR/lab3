
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class ServiceHandle {
     static BufferedReader bf;
     static String tempString;
     static ArrayList <QoS> service=new ArrayList();
     public static void ServiceHandle(String name) throws IOException
     {
    	 bf=new BufferedReader(new FileReader(new File(name)));
    	 while((tempString=bf.readLine())!=null)
    	 {
    		 tempString.trim();
    		 String temp[]=tempString.split(" ");
    		 QoS s=new QoS(temp[0],Float.parseFloat(temp[1]),Float.parseFloat(temp[2]),Float.parseFloat(temp[3]),Float.parseFloat(temp[4]));
    		 //System.out.print(s.name+" "+s.Price+" ");
    		 service.add(s);
    	 }
     }
	
	
}

class QoS
{
	public String name;
	public float Reliablility;
	public float Price;
	float unknown1,unknown2;
	public QoS(String name,float x1,float x2,float x3,float x4)
	{
		this.name=name;
		this.unknown1=x1;
		this.Reliablility=x2;
		this.unknown2=x3;
		this.Price=x4;
	}
	public char GetClass()
	{
		return name.charAt(0);
	}
	}