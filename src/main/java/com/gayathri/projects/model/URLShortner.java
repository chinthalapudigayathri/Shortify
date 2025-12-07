package com.gayathri.projects.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/* Java 8+ Date and Time API usage */
import java.time.OffsetDateTime;

/* Lombok annotations */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
/* JPA/Hibernate annotations */
@Entity
@Table(name = "URL_Shortner")

/* our class is public because it allows other packages and classes to use this class
Java Bean Convention = Public Class, Private Fields , Public getters/setters
 */
public class URLShortner
{
    /* @Id annotation means it is marked as primary key in Hibernate */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id", updatable=true, nullable=false)
    private Long id;
    /* All the fields are private because it restricts other methods to modify data directly
    * It also helps in data encapsulation, If we need validation and modification, we can do that
    * by using getters and setter later.
     */
    @Column(name="shorturl" , unique=true)
    private String shorturl;

    @Column(name="longurl", nullable=false)
    private String longurl;

    @Column(name="isActive" , nullable=true , columnDefinition="boolean default true")
    private boolean isActive;

    @Column(name="created_at", nullable=false, updatable=false)
    private OffsetDateTime createdAt;

    @Column(name="updated_at", nullable=true, updatable=true)
    private OffsetDateTime updatedAt;

    /* @PrePersist and @PostPersist are JPA life cycle call annotations
    * These annotations allows us to automatically execute our logic
    * We mark few methods with these annotations inside entity class for that reason
    * These methods need not be public because, hibernate uses reflection to call them.
    * Hence, method visibility doesn't matter. And it also performs method encapsulation
    * Return type for the method is void because JPA doesn't expect a return type. If
    * we return a value, then JPA doesn't know what to do with it, hence this is the correct method signature
    *  */
    @PrePersist
    private void prePersist()
    {
        this.createdAt = OffsetDateTime.now();
        this.updatedAt = OffsetDateTime.now();
    }

    @PreUpdate
    private void preUpdate()
    {
        this.updatedAt = OffsetDateTime.now();
    }

}