package com.aaron.reflect;

public class Dog6 implements Animal {
	 
    public final static String name = "dog";
     
    @Override
    public String sayHello(String str) {
        return String.format("%s  says : %s", this.name, str);
    }
}