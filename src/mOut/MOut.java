package mOut;


import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;;



public class MOut {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration conff = new Configuration();

		conff.set("mapred.job.tracker", "localhost:54311"); 
		conff.set("fs.default.name", "hdfs://localhost:54310");
		
		Job job = new Job(conff, "MOut");
	     job.setJarByClass(MOut.class);
	     
	     // Specify various job-specific parameters     
	     job.setJobName("mout");
	     
	     
	     job.setMapperClass(MMapper.class);
	     job.setNumReduceTasks(3);
		 job.setPartitionerClass(MOutPartitioner.class);
		 job.setSortComparatorClass(KeyComparator.class);
		 job.setGroupingComparatorClass(GroupComparator.class);
	     job.setReducerClass(MReducer.class);
	     
		 
		 job.setOutputKeyClass(TextPair.class);
		    
		 job.setOutputValueClass(IntWritable.class);
		 



		  FileInputFormat.setInputPaths(job, new Path("/home/hduser/gutenberg"));
		  FileOutputFormat.setOutputPath(job, new Path("/home/hduser/gutenberg-output"));

	     // Submit the job, then poll for progress until the job is complete
	     job.waitForCompletion(true);
	}

}
