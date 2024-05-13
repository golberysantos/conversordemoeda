package br.com.conversordemoeda.api;

public class MyGsonGenericType<T> {
	// T stands for "Type"
	// T stands for "Type"
	private T t;

	public void set(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}

}
