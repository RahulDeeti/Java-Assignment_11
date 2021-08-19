//Assignment 11
//Reading from file and counting frequency of each character.
//Writing to file character and it's frequency to the file.
import java.io.*;
import java.util.*;
class ReadingFromFile
{
 
  Map<Character, Integer> readFromFile(String fileName) throws Exception
  {  
    FileReader reader = new FileReader(fileName);
    int i;
	HashMap<Character, Integer> hm = new HashMap<>();
	char ch = '\0';
	int count;
    while ((i = reader.read()) != -1)
	{
		ch = (char)i;
		if(hm.get(ch) != null)
		{
			count = hm.get(ch);
			count++;
			hm.put(ch,count);
		}
		else
		{
			hm.put(ch, 1);
		}
	}
	return hm;
  }
  
}
class WritingToFile
{
	void writeToFile(Map<Character, Integer> mp) throws Exception
	{
		String str = "";
		int count;
		FileWriter writer = new FileWriter("keyvalpair.txt");
		for(char key : mp.keySet())
		{
			count = mp.get(key);
			str += " "+key+" "+count ;
		}
		//System.out.println(str);
		writer.write(str);
		writer.flush();
	}
}
public class ReadWriteMain
{
	public static void main(String args[]) throws Exception
	{
		String fileName = args[0];
		ReadingFromFile read = new ReadingFromFile();
		Map<Character, Integer> mp ;
		mp = read.readFromFile(fileName);
		WritingToFile write = new WritingToFile();
		write.writeToFile(mp);
	}
}