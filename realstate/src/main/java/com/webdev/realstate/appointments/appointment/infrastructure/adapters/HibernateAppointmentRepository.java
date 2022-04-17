package com.webdev.realstate.appointments.appointment.infrastructure.adapters;

import com.webdev.realstate.appointments.appointment.domain.Appointment;
import com.webdev.realstate.appointments.appointment.domain.ports.AppointmentRepository;
import com.webdev.realstate.appointments.appointment.domain.valueobjects.AppointmentDate;
import com.webdev.realstate.appointments.appointment.domain.valueobjects.AppointmentState;
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
public class HibernateAppointmentRepository extends HibernateRepository<Appointment> implements AppointmentRepository{

    public HibernateAppointmentRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        super(sessionFactory, Appointment.class);
    }

    @Override
    public void save(Appointment appointment) {
        persist(appointment);
    }

    @Override
    public void update(Appointment appointment) {
        updateEntity(appointment);
    }

    @Override
    public Optional<List<Appointment>> findByUserId(UserId userId, UserIsAgent isAgent) {
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Appointment> cq = cb.createQuery(Appointment.class);
        Root<Appointment> root = cq.from(Appointment.class);

        if(isAgent.value()){
            cq.select(root).where(cb.equal(root.get("agentId"), userId));
        } else {
            cq.select(root).where(cb.equal(root.get("userId"), userId));
        }

        List<Appointment> appointments = sessionFactory.getCurrentSession().createQuery(cq).getResultList();
        return Optional.ofNullable(appointments);
    }

    @Override
    public Optional<List<Appointment>> findByDate(AppointmentDate appointmentDate) {
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Appointment> cq = cb.createQuery(Appointment.class);
        Root<Appointment> root = cq.from(Appointment.class);
        cq.select(root).where(cb.equal(root.get("appointmentDate"), appointmentDate));

        List<Appointment> appointments = sessionFactory.getCurrentSession().createQuery(cq).getResultList();
        return Optional.ofNullable(appointments);
    }

    @Override
    public Optional<List<Appointment>> findByState(AppointmentState appointmentState) {
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Appointment> cq = cb.createQuery(Appointment.class);
        Root<Appointment> root = cq.from(Appointment.class);
        cq.select(root).where(cb.equal(root.get("appointmentState"), appointmentState));

        List<Appointment> appointments = sessionFactory.getCurrentSession().createQuery(cq).getResultList();
        return Optional.ofNullable(appointments);
    }
}
