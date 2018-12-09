/*
  This java coding will do addition operation and can be test using putty and port specified.
  If using port 443, the HTML code will be encrypted but if using port 999, 
  It will show the calclulation of 888 + 10000 = 10888.
  The output will appear on the NetBean and can be captured by wireshark.

  Mohammad Ariff Bin Idris (2017430762)
*/
package sokethaiserver;

import java.io.*;
import java.net.*;

public class SoketHAIServer {

public static void main(String argv[]) throws Exception
      {
 
   		 System.out.println(" Server is Running  " );
         ServerSocket mysocket = new ServerSocket(999);
 
         while(true)
         {
            Socket connectionSocket = mysocket.accept();
 
            BufferedReader reader = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            BufferedWriter writer =	new BufferedWriter(new OutputStreamWriter(connectionSocket.getOutputStream()));
 
            writer.write("*** Welcome to the Calculation Server (Addition Only) ***\r\n\n\n");            
            writer.write("*** Please type in the first number and press Enter : \n");
            writer.flush();
            String data1 = reader.readLine().trim();
 
            writer.write("*** Please type in the second number and press Enter : \n");
            writer.flush();
            String data2 = reader.readLine().trim();
 
            int num1=Integer.parseInt(data1);
            int num2=Integer.parseInt(data2);
 
            int result=num1+num2;            
            System.out.println("Addition operation done " );
 
            writer.write("\r\n=== Result is  : "+result);
            writer.flush();
            connectionSocket.close();
         }
      }
}
