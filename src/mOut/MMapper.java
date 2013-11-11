package mOut;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

public class MMapper extends Mapper<LongWritable, Text, TextPair, IntWritable> {
//	private static final IntWritable one = new IntWritable(1);
	private Text word = new Text();
	private Text filename = new Text();
	private IntWritable one = new IntWritable(1);
	public void map(LongWritable key, Text values,
			 Context context) throws IOException, InterruptedException {
	     StringTokenizer itr = new StringTokenizer(values.toString());
	 	 FileSplit fileSplit = (FileSplit)context.getInputSplit();
		 String file_name = fileSplit.getPath().getName();
		 filename.set(file_name);	
		 
	     while (itr.hasMoreTokens()) {
	       word.set(itr.nextToken());
	       context.write(new TextPair(filename, word), one);
	     }
	     
	}

}
