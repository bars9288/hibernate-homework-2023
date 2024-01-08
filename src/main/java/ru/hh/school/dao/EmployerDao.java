package ru.hh.school.dao;

import org.hibernate.SessionFactory;
import ru.hh.school.entity.Employer;

public class EmployerDao extends GenericDao {

  public EmployerDao(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  /**
   * TODO: здесь нужен метод, позволяющий сразу загрузить вакасии, связанные с работодателем и в некоторых случаях
   * избежать org.hibernate.LazyInitializationException
   * Также в запрос должен передаваться параметр employerId
   * <p>
   *
   *
   * https://vladmihalcea.com/the-best-way-to-handle-the-lazyinitializationexception/
   */

  // https://javarush.com/quests/lectures/questhibernate.level16.lecture04
  public Employer getEager(int employerId) {
    return getSession()
        .createQuery(
            "select ru.hh.school.entity.Employer(e.company_name) from Employer e join fetch e.vacancies where e.id = :id", Employer.class
        ).uniqueResult();

  }

}
