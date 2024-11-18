package com.ryy.giftlist.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class CrudDaoService {

	@PersistenceContext(name = "GiftlistDS")
	protected EntityManager em;

	protected <T> T insert(T t) throws RuntimeException {
		em.persist(t);
		return t;
	}

	protected <T> T update(T t) throws RuntimeException {
		em.merge(t);
		return t;
	}
}
