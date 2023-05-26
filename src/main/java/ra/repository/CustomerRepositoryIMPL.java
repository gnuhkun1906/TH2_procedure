package ra.repository;

import org.springframework.transaction.annotation.Transactional;
import ra.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Transactional
public class CustomerRepositoryIMPL implements ICustomerRepository{
@PersistenceContext
private EntityManager entityManager;
    @Override
    public boolean insertWithStoredProcedure(Customer customer) {
        String str="CALL Insert_Customer(:firstName, :lastName)";
        Query query= entityManager.createNativeQuery(str);
        query.setParameter("firstName",customer.getFirstName());
        query.setParameter("lastName", customer.getLastName());
        return query.executeUpdate()==0;
    }
}
