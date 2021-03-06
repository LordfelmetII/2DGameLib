package com.lordfelmet.GameLib.input.keys;

import java.lang.reflect.Method;

import com.lordfelmet.GameLib.input.InputBinder;

public class KeyBinder extends InputBinder {

	public KeyBinder(String workspace) {
		super(workspace);
		for(Method m : methods){
			addInput(m);
		}
	}
	private void addInput(Method m){
		bindings.add(new BoundKey(m));
	}
}
