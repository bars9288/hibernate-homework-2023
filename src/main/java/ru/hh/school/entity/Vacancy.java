package ru.hh.school.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;

//TODO: оформите entity +++++
@Entity
@Table (name = "vacancy")

public class Vacancy {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "vacancy_id")
  private Integer id;

  @ManyToOne // тут фитч не нужен тк по умолчанию будет ЕГЕР - 1 значение
  @JoinColumn(name = "employer_id")
  private Employer employer;

  @ManyToOne // тут фитч не нужен тк по умолчанию будет ЕГЕР - 1 значение
  @JoinColumn(name = "area_id")
  private Area area;

@Column(name = "title", length = 100, nullable = false)
  private String title;

// @Column(name = "description")
  private String description;

@Column(name = "compensation_from")
  private Integer compensationFrom;

@Column(name = "compensation_to")
  private Integer  compensationTo;

@Column(name = "compensation_gross")
  private Boolean compensationGross;

@Column(name = "creation_time")
  private LocalDateTime creationTime;

  @Column(name = "archiving_time")
  private LocalDateTime archivingTime;

  public Vacancy() {
  }

  public Vacancy(Employer employer) {
    this.employer = employer;
  }

  public void setArea(Area area) {
    this.area = area;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Employer getEmployer() {
    return employer;
  }

  public void setEmployer(Employer employer) {
    this.employer = employer;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setCompensationFrom(Integer compensationFrom) {
    this.compensationFrom = compensationFrom;
  }

  public void setCompensationTo(Integer compensationTo) {
    this.compensationTo = compensationTo;
  }

  public LocalDateTime getArchivingTime() {
    return archivingTime;
  }

  public void setArchivingTime(LocalDateTime archivingTime) {
    this.archivingTime = archivingTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null) return false;
    if (!(o instanceof Vacancy)) return false;
    Vacancy vacancy = (Vacancy) o;  // сравнение после приведения типов

    return (
            Objects.equals(id, vacancy.id)  &&
            Objects.equals(description, vacancy.description)
    );

  }

  @Override
  public int hashCode() {
    return Objects.hash(id, description);
  }

}
