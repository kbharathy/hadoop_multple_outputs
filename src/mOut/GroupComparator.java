package mOut;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class GroupComparator extends WritableComparator {

	protected GroupComparator(){
		super(TextPair.class, true);
	}
	
	
	@Override
	public int compare(WritableComparable w1, WritableComparable w2 ){
		TextPair tp1 = (TextPair) w1;
		TextPair tp2 = (TextPair) w2;
		return tp1.getWord().compareTo(tp2.getWord());

	}
	
	
	
}
