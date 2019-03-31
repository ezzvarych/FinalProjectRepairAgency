package entitySamples;

import com.cources.finalProject.model.entities.Person;
import com.cources.finalProject.model.entities.Role;

/**
 * Create test examples of db entities to test DAO
 */
public class SampleEntitiesCreator {
    public static Person createUser() {
        return new Person.PersonBuilder()
                .setLogin("user17")
                .setEmail("zhenya.zvarych@gmail.com")
                .setPassword("user17")
                .setRole(Role.CUSTOMER)
                .build();
    }
}
