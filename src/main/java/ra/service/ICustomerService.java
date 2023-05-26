package ra.service;

import ra.model.Customer;

public interface ICustomerService {
    boolean insertWithStoredProcedure(Customer customer);
}
