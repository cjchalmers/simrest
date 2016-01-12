package nl.simplexit.rest;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by colin on 30-12-15.
 */
@Repository
public interface BookRepository extends MongoRepository<Book, String> {

}
