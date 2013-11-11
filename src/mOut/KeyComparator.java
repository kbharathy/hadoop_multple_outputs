package mOut;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class KeyComparator extends WritableComparator {
	protected KeyComparator(){
		super(TextPair.class, true);
	}
	
	@Override
	public int compare(@SuppressWarnings("rawtypes") WritableComparable w1, @SuppressWarnings("rawtypes") WritableComparable w2 ){
		TextPair ip1 = (TextPair) w1;
		TextPair ip2 = (TextPair) w2;
		return ip1.compareTo(ip2);
		
	}

}
