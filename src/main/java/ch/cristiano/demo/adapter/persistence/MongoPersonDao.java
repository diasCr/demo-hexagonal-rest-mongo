package ch.cristiano.demo.adapter.persistence;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;

import ch.cristiano.demo.application.domain.Person;
import ch.cristiano.demo.application.port.out.PersonDao;

@ApplicationScoped
public class MongoPersonDao implements PersonDao {

    @Inject
    MongoClient mongoClient;

    @Override
    public void persistPerson(Person person) {
        Document newPersonDocument = new Document();
        newPersonDocument.append("firstname", person.getFirstname());
        newPersonDocument.append("lastname", person.getLastname());
        newPersonDocument.append("age", person.getAge());
        this.getCollection().insertOne(newPersonDocument);
    }

    @Override
    public Person find(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Person findByIdString(String id) {
        Bson filter = Filters.eq("_id", new ObjectId(id));
        FindIterable<Document> foundPersonDocument = this.getCollection().find(filter);
        MongoCursor<Document> cursor = foundPersonDocument.iterator();
        Person foundPerson = new Person();
        while (cursor.hasNext()) {
            Document document = cursor.next();
            foundPerson.setFirstname(document.getString("firstname"));
            foundPerson.setLastname(document.getString("lastname"));
            foundPerson.setAge(document.getInteger("age"));
        }
        return foundPerson;
    }

    private MongoCollection<Document> getCollection() {
        return mongoClient.getDatabase("cr_person").getCollection("person");
    }

}
