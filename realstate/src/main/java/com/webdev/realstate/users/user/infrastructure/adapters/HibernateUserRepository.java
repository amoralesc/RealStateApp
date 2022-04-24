package com.webdev.realstate.users.user.infrastructure.adapters;

import com.webdev.realstate.shared.infrastructure.hibernate.HibernateRepository;
import com.webdev.realstate.users.user.domain.User;
import com.webdev.realstate.users.user.domain.ports.UserRepository;
import com.webdev.realstate.users.user.domain.valueobjects.UserEmail;
import com.webdev.realstate.users.user.domain.valueobjects.UserId;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateUserRepository extends HibernateRepository<User> implements UserRepository {

	public HibernateUserRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
		super(sessionFactory, User.class);
	}

	@Override
	public void save(User user) {
		persist(user);
	}

	@Override
	public void update(User user) {
		updateEntity(user);
	}

	@Override
	public void delete(User user) {
		deleteEntity(user);
	}

	@Override
	public Optional<User> findById(UserId userId) {
		return getById(userId);
	}

	@Override
	public Optional<User> findByEmail(UserEmail email) {
		User user = null;

		CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> root = cq.from(User.class);

		cq.
				select(root)
				.where(cb.equal(root.get("userEmail"), email));
		List<User> users =
				sessionFactory.getCurrentSession().createQuery(cq).getResultList();

		if (!users.isEmpty()) {
			user = users.get(0);
		}
		return Optional.ofNullable(user);
	}

	@Override
	public Optional<List<User>> findAll() {
		return getAll();
	}
}
