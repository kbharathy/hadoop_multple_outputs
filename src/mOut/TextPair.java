package mOut;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

public class TextPair implements WritableComparable<TextPair>{
	private Text filename;
	private Text word;
	
	public TextPair(){
		set(new Text(), new Text());
	}
	
	public TextPair(String inFilename, String inWord){
		set(new Text(inFilename), new Text(inWord));
		
	}
	
	public TextPair(Text inFilename, Text inWord){
		set(inFilename, inWord);
	}

	public void set(Text filename, Text word){
		this.filename = filename;
		this.word = word;
	}
	
	public Text getFilename(){
		return filename;
	}
	
	public Text getWord(){
		return word;
	}
	
	@Override
	public void write(DataOutput out) throws IOException{
		filename.write(out);
		word.write(out);
	}
	
	@Override
	public void readFields(DataInput in) throws IOException{
		filename.readFields(in);
		word.readFields(in);
	}
	
	@Override
	public int hashCode() {
		return filename.hashCode() * 163 + word.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof TextPair) {
		TextPair tp = (TextPair) o;
		return filename.equals(tp.filename) && word.equals(tp.word);
		}
		return false;
	}
	
	@Override
	public String toString() {
		return filename + "\t" + word;
	}
	

	@Override
	public int compareTo(TextPair tp) {
		int cmp = filename.compareTo(tp.filename);
		if (cmp != 0) {
			return cmp;
		}
		return word.compareTo(tp.word);
	}
	
}
