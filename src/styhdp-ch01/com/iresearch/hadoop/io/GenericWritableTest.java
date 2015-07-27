package com.iresearch.hadoop.io;

import java.io.IOException;
//import java.util.EmptyStackException;

import org.apache.hadoop.io.GenericWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.util.StringUtils;

import com.iresearch.hadoop.io.base.WritableTestBase;

public class GenericWritableTest extends WritableTestBase{
	
	public static void main(String[] args) throws IOException {
		Text text = new Text("My GenericWritable Test");
		MyGenericWritable writable = new MyGenericWritable(text);
		
		System.out.println(StringUtils.byteToHexString( serialize(text) ));
		System.out.println(StringUtils.byteToHexString( serialize(writable) ));
	}
}


@SuppressWarnings("unchecked")
class MyGenericWritable extends GenericWritable {
	
	public MyGenericWritable(Writable writable){
		set(writable);
	}
	
	public static Class<? extends Writable>[] classes = null;

	static {
		classes = (Class<? extends Writable>[])new Class[]{
			Text.class
		};
	}
	
	@Override
	protected Class<? extends Writable>[] getTypes() {
		return classes;
	}
	
}

// Class<? extends Writable>[] classess = (Class<? extends Writable>[])new Class[]{Text.class};

/*class TestGenericArray <E>{
	private E[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	public TestGenericArray(){
		elements = new E[DEFAULT_INITIAL_CAPACITY]; //Cannot create a generic array of E
	}
	
	public E pop(){
		if(size ==0){
			throw new EmptyStackException();
		}
		E result = elements[--size];
		elements[size] = null;
		return result;
	}
}*/

/*class TestGenericArray <E>{
	private E[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	@SuppressWarnings("unchecked")
	public TestGenericArray(){
		elements = (E[])new Object[DEFAULT_INITIAL_CAPACITY]; //Cannot create a generic array of E
	}
	
	public E pop(){
		if(size ==0){
			throw new EmptyStackException();
		}
		E result = elements[--size];
		elements[size] = null;
		return result;
	}
}*/

/*class TestGenericArray<E>{
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	public TestGenericArray(){
		elements = new Object[DEFAULT_INITIAL_CAPACITY]; //Cannot create a generic array of E
	}
	
	public E pop(){
		if(size ==0){
			throw new EmptyStackException();
		}
		@SuppressWarnings("unchecked")
		E result = (E)elements[--size];
		elements[size] = null;
		return result;
	}
}*/