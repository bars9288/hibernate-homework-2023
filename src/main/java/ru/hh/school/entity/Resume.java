package ru.hh.school.entity;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

//TODO: оформите entity ++++

@Entity
@Table(name = "resume")
public class Resume {
  // TODO: сделать так, чтобы id брался из sequence-а
  // таким образом, мы сможем отправлять в бд запросы батчами.
  // нужно учитывать, что описание sequence при создании таблицы также должно соответствовать
  // хиберовской сущности (см. create_resume.sql)
  //
  // Подробнее:
  // https://vladmihalcea.com/how-to-batch-insert-and-update-statements-with-hibernate/
  // https://vladmihalcea.com/from-jpa-to-hibernates-legacy-and-enhanced-identifier-generators/

  @Id
// шаблон взят с офф мануала по Гиберу
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "sequence-generator"
  )
  @SequenceGenerator(
      name = "sequence-generator",
      sequenceName = "resume_id_seq",
      allocationSize = 10
  )

  // https://habr.com/ru/companies/haulmont/articles/653843/ - добавьте в свои лекци к cсылкам
  //@Column (name = "id")
  private Integer id;

  //@Column (name = "description")
  private String description;

  Resume() {}

  public Resume(String description) {
    this.description = description;
  }

}
