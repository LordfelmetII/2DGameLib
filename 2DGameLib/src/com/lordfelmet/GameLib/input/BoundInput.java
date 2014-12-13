package com.lordfelmet.GameLib.input;


import java.lang.reflect.Method;



public abstract class BoundInput {
	public Method action;
	public BoundInput(Method m){
	     action = m;
	}
	public String toString(){
		return action.getName();
	}
	public void doAction(Object obj){
		try {
			action.invoke(obj, (Object[])null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
