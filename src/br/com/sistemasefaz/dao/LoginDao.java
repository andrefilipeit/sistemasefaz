package br.com.sistemasefaz.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.sistemasefaz.modelo.Login;

public class LoginDao {

	public boolean existe(Login login) {

		EntityManager em = new JPAUtil().getEntityManager();
		TypedQuery<Login> query = em
				.createQuery(
						"select u from Login u where u.user = :pUser and u.senha = :pSenha",
						Login.class);

		query.setParameter("pUser", login.getUser());
		query.setParameter("pSenha", login.getSenha());

		try {
			Login resultado = query.getSingleResult();
		} catch (NoResultException ex) {
			return false;
		}

		em.close();

		return true;
	}

}
