package vn.fis.training;

import vn.fis.training.domain.Customer;
import vn.fis.training.domain.CustomerStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
public class CustomerManagementApplication
{
    public static void main( String[] args )
    {

        System.out.println( "Welcome to Fis Java Training Course!" );
    }
    // TODO: Implement method to test all CustomerService

    CustomerStatus customerStatus1 = CustomerStatus.ACTIVE;
    CustomerStatus customerStatus2 = CustomerStatus.INACTIVE;
    Customer customer = new Customer("01","Hien", LocalDate.now(),"000",customerStatus1,LocalDateTime.now());
    Customer customer2 = new Customer("02","Anh", LocalDate.now(),"001",customerStatus2,LocalDateTime.now());
    Customer customer3 = new Customer("03","Phuong", LocalDate.now(),"002",customerStatus1,LocalDateTime.now());
}
