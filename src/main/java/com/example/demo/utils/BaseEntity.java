package com.example.demo.utils;

import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@MappedSuperclass
public class BaseEntity implements Persistable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Version
    protected Long version;

    @CreationTimestamp
    protected Instant createdAt;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return id == null;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }


    @Override
    public boolean equals (Object o){
        if(this == o) {
            return true;
        }

        if(!(o instanceof BaseEntity)) {
            return false;
        }
        BaseEntity that = (BaseEntity) o;

        return Objects.equals(id, that.getId()) && Objects.equals(
                Hibernate.unproxy(this).getClass().getName(),
                Hibernate.unproxy(that).getClass().getName()
                );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id =" + id +
                '}';
    }
}
