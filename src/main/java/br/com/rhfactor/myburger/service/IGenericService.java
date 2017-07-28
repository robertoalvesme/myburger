package br.com.rhfactor.myburger.service;

public interface IGenericService<T, Serial extends Number> {

	public abstract void insert(T t);

	public abstract void update(T t);

	public abstract void delete(T t);

	public abstract T get(Serial id);

}
