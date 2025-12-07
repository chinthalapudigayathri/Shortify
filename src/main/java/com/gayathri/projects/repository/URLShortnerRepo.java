package com.gayathri.projects.repository;

import org.springframework.data.jpa.repository.JpaRepository;
/*importing spring repository to define repository*/
import org.springframework.stereotype.Repository;
/* importing model class */
import com.gayathri.projects.model.URLShortner;

/* By adding this annotation, we are telling Spring that this is a Data Access Layer,
which has Data access objects for interacting with Database
 */
@Repository
/* An Interface is a blueprint in java, it provides methods but does not provide an actual implementation
* An interface hides the implementation and only shows the blueprint, hence it exhibits data abstraction
* Interfaces can also exhibit Polymorphism, as multiple classes can implement an interface
* we declared this interface public so that all other layers can interact and pass data to and fro
* JPARepository is a Spring Data Interface which already provides CRUD operations
* In Arguments we pass our model(entity) class and data type of primary key as arguments
* Interface Inheritance is also happening here as one interface is extending another interface
 */
public interface URLShortnerRepo extends JpaRepository<URLShortner, Long> {

    /*First we give model(entity) class name to tell Spring Data JPA which table this repository manages
     * Spring Data JPA looks at these methods and automatically generates required query on its own
     * Ex: findByShortURL("abc")= "select * from short_url where shorturl="abc"
     * And we pass fiends declared in Model(entity) class into these methods to say what cloumn it is
     */

    URLShortner findByShortURL(String shorturl);
    URLShortner findByLongURL(String longurl);

}