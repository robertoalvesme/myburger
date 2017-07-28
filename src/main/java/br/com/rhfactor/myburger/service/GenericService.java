package br.com.rhfactor.myburger.service;

import java.lang.reflect.ParameterizedType;

import br.com.rhfactor.myburger.dao.IGenericDao;

public abstract class GenericService<T, Serial extends Number> implements IGenericService<T, Serial> {

	protected final IGenericDao<T, Serial> dao;

	@SuppressWarnings("unused")
	private final Class<T> clazz;

	@SuppressWarnings("unchecked")
	public GenericService(IGenericDao<T, Serial> dao) {
		super();
		this.dao = dao;

		this.clazz = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public void insert(T t) {
		this.dao.insert(t);
	}

	public void update(T t) {
		this.dao.update(t);
	}

	public void delete(T t) {
		this.dao.delete(t);
	}

	public T get(Serial id) {
		return this.dao.get(id);
	}

}