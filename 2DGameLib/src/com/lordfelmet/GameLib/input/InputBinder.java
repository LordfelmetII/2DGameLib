package com.lordfelmet.GameLib.input;


import static org.reflections.ReflectionUtils.getAllMethods;

import java.awt.event.InputEvent;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.reflections.ReflectionUtils;
import org.reflections.Reflections;


public abstract class InputBinder {
	
	protected Map<InputEvent, BoundInput> inputs = new HashMap<InputEvent, BoundInput>();
	protected Set<Method> methods = new HashSet<Method>();
	protected Set<BoundInput> bindings = new HashSet<BoundInput>();
	
	
	
	public InputBinder(String workspace){
		findMethods(workspace);
	}
		
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Method[] findMethods(String workspace){
		Reflections reflections = new Reflections(workspace);

	     Set<Class<?>> annotated = 
	               reflections.getTypesAnnotatedWith(InputRegistry.class);
	    Class[] m = (Class[]) annotated.toArray();
	    	 	
	    		methods = getAllMethods(m[0], ReflectionUtils.withPrefix("doWhen"), ReflectionUtils.withParametersCount(0)); 
	    	
	   
		return null; 
	}

	public void bindInput(InputEvent key, String s) throws Exception{
		Iterator<BoundInput> i = bindings.iterator();
		BoundInput b;
		
		do{
			b = (BoundInput) i.next();
			
			
		}while((!(b.toString().equals(s)))&&(i.hasNext()));
		if(!(b.toString().equals(s))){
			throw new Exception("invalid Method name");
		}
		inputs.put(key, b);
	}
	public BoundInput getBinding(InputEvent key){
		return ((BoundInput)inputs.get(key));
	}
	
}
