import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
//Author Name: Zen Himes
//Date: 1/27/2022
//Program Name: Himes_spell checking
//Purpose: spell checking
public class Himes_spellChecking {
	public static void main(String args[]) throws IOException {
		JButton open= new JButton();
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new java.io.File("C:/Users"));
		fc.setDialogTitle("Choose text to spellcheck"); //text shown on file chooser
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY); //only accepts files
		fc.addChoosableFileFilter(new FileNameExtensionFilter("*.txt","txt"));//only accepts .txt
		if (fc.showOpenDialog(open)==JFileChooser.APPROVE_OPTION) {
			
		}
		File text = new File(fc.getSelectedFile().getAbsoluteFile().toString()); //saves the file 
		fc.setDialogTitle("Choose dictionary");
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.addChoosableFileFilter(new FileNameExtensionFilter("*.txt","txt"));//only accepts .txt
		if (fc.showOpenDialog(open)==JFileChooser.APPROVE_OPTION) {
			
		}
		File dictionary = new File(fc.getSelectedFile().getAbsoluteFile().toString());//saves the dictionary
		Scanner textScan = new Scanner(text);
		ArrayList<String> textList = new ArrayList<String>();
		while (textScan.hasNext()) { //scans every line of the text and adds it to the ArrayList
			textList.add(textScan.next());
		}
		textScan.close();
		Scanner dictionaryScan = new Scanner(dictionary); 
		ArrayList<String> dictionaryList = new ArrayList<String>();
		while (dictionaryScan.hasNext()) { //scans every lines of text and adds it to the arraylist
			dictionaryList.add(dictionaryScan.next());
		}
		dictionaryScan.close();
		System.out.println("These words are mispelled");
		spellcheck(textList,dictionaryList); 
	}
	public static void spellcheck(ArrayList<String> text, ArrayList<String> dictionary) {
		for (String str: text) { //for every string in the text
			if(!dictionary.contains(str)) { //if the dictionary doesn't have the string
				System.out.println(str);
			}
		}
	}
}
