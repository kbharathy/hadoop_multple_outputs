package mOut;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Partitioner;

public class MOutPartitioner extends Partitioner<TextPair, IntWritable>{
	
	@Override
	public int getPartition(TextPair key, IntWritable value, int numpartitioner){
		if(key.getFilename().toString().contains("pg5000.txt")){
			return 0;
		}else if (key.getFilename().toString().contains("pg4300.txt")){
			return 1;
		}else {
			return 2;
		}
		
			
		
	}
	

}
