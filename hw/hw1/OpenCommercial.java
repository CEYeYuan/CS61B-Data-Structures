/* OpenCommercial.java 
Write a program that reads a String from the keyboard.  The program should then
construct a URL for http://www.X.com/, replacing X with the String read in, and
print the first five lines of the Web page at that URL in REVERSE ORDER; i.e.,
the fifth, fourth, third, second, and first lines.*/

import java.net.*;
import java.io.*;

/**  A class that provides a main function to read five lines of a commercial
 *   Web page and print them in reverse order, given the name of a company.
 */

class OpenCommercial {

  /** Prompts the user for the name X of a company (a single string), opens
   *  the Web site corresponding to www.X.com, and prints the first five lines
   *  of the Web page in reverse order.
   *  @param arg is not used.
   *  @exception Exception thrown if there are any problems parsing the 
   *             user's input or opening the connection.
   */
  public static void main(String[] arg) throws Exception {

    BufferedReader keyboard,readnet;
    String inputLine;

    keyboard = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Please enter the name of a company (without spaces): ");
    System.out.flush();        /* Make sure the line is printed immediately. */
    inputLine = keyboard.readLine();

    /* Replace this comment with your solution.  */
    URL url=new URL("http://www."+inputLine+".com/");
    readnet = new BufferedReader(new InputStreamReader(url.openStream()));
    String first=new String(readnet.readLine());
    String second=readnet.readLine();
    String third=readnet.readLine();
    String fourth=readnet.readLine();
    String fifth=readnet.readLine();
    System.out.println(fifth);
    System.out.println(fourth);
    System.out.println(third);
    System.out.println(second);
    System.out.println(first);
  }
}
