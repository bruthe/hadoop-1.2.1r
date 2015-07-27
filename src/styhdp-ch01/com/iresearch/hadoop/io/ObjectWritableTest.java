package com.iresearch.hadoop.io;

import java.io.IOException;

import org.apache.hadoop.io.ObjectWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.util.StringUtils;

import com.iresearch.hadoop.io.base.WritableTestBase;

public class ObjectWritableTest extends WritableTestBase {

	public static void main(String[] args) throws IOException {
		
		Text text = new Text("\u0041");
		ObjectWritable writable = new ObjectWritable(text);
		System.out.println( StringUtils.byteToHexString( serialize(writable)) );
		//00196f72672e6170616368652e6861646f6f702e696f2e5465787400196f72672e6170616368652e6861646f6f702e696f2e546578740141
	}

}
