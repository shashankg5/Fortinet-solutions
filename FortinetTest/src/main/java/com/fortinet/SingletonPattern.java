package com.fortinet;


public class SingletonPattern {
	
	private static final SingletonPattern INSTANCE = new SingletonPattern();
    // Prevents creating another instance of SingletonPattern
    private SingletonPattern(){
    }

    public static SingletonPattern getSingletonPattern(){
        return INSTANCE;
    }
}
