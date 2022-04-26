package com.webdev.realstate.appointments.request.infrastructure.adapters;

import com.webdev.realstate.appointments.request.domain.Request;
import com.webdev.realstate.appointments.request.domain.ports.RequestRepository;
import com.webdev.realstate.appointments.request.domain.valueobjects.RequestDate;
import com.webdev.realstate.appointments.request.domain.valueobjects.RequestId;
import com.webdev.realstate.appointments.request.domain.valueobjects.RequestState;
import com.webdev.realstate.shared.infrastructure.hibernate.HibernateRepository;
import com.webdev.realstate.users.user.domain.valueobjects.UserId;
import com.webdev.realstate.users.user.domain.valueobjects.UserIsAgent;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateRequestRepository extends HibernateRepository<Request> implements RequestRepository {

	public HibernateRequestRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
		super(sessionFactory, Request.class);
	}

	@Override
	public void save(Request request) {
		persist(request);
	}

	@Override
	public void update(Request request) {
		updateEntity(request);
	}

	@Override
	public void delete(Request request) {
		deleteEntity(request);
	}

	@Override
	public Optional<Request> findById(RequestId requestId) {
		return getById(requestId);
	}

	@Override
	public Optional<List<Request>> findByUser(UserId userId, UserIsAgent isAgent) {
		CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
		CriteriaQuery<Request> cq = cb.createQuery(Request.class);
		Root<Request> root = cq.from(Request.class);

		if (isAgent.value()) {
			cq.select(root).where(cb.equal(root.get("agentId"), userId));
		} else {
			cq.select(root).where(cb.equal(root.get("userId"), userId));
		}

		List<Request> requests = sessionFactory.getCurrentSession().createQuery(cq).getResultList();
		return Optional.ofNullable(requests);
	}

	@Override
	public Optional<List<Request>> findAll() {
		return getAll();
	}
}
