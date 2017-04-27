package com.example.common;

public class NvlTransfer {

	public int parseInt(String string){
		
		int value = 0;
		try{
			value = Integer.parseInt(string);
		} catch( NumberFormatException e){
			value = 0;
			System.out.println("InputData> " + string);
			System.out.println("NumberFormatException> " + e);
		} catch (Exception e){
			value = 0;
			System.out.println("InputData> " + string);
			System.out.println("NumberFormatException> " + e);
		}
		return value;
	}
}
