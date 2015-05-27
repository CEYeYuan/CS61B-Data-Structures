import java.io.*;
class Nuke2{
	public static void main(String[] args) throws Exception{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String get=bf.readLine();
		String output=get.substring(0,1)+get.substring(2);
		System.out.println(output);
	}
}