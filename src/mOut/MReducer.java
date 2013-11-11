package mOut;

import java.io.IOException;


import org.apache.hadoop.io.IntWritable;


import org.apache.hadoop.mapreduce.Reducer;
//import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;

public class MReducer extends Reducer<TextPair, IntWritable, TextPair, IntWritable> {
//	private MultipleOutputs<NullWritable, IntWritable> mos;
	
//	@Override
//	protected void setup(Context context)
//			throws IOException, InterruptedException{
//		mos = new MultipleOutputs<NullWritable, IntWritable>(context);
//	}

	@Override
	public void reduce(TextPair key, Iterable<IntWritable> values,
			Context context) throws IOException, InterruptedException {
		int sum = 0;
		for (IntWritable val : values) {
	       sum += val.get();
	     }
		context.write(key, new IntWritable(sum));
	}

}
