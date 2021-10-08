package com.example.DataJPA.repository;

import com.example.DataJPA.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findEmployeeByLastName(String lastName);

    Employee findEmployeeByFirsNameAndLastName( String firstName, String lastName);

    @Query(value = "SELECT(*) FROM Employee ", nativeQuery = true)
    Employee getEmployeeUsingCustomQuery();

    @Query("Select e from Employee e")
    Employee getEmployeeUsingJPQL();

    @Query("Select e from Employee e where e.firsName =?1 and e.age =?2")
    Employee getByNameAndAge(String firstName, int age);

    @Query("Select e from Employee e where e.firsName = :firstName and e.age = :age")
    Employee getByNameAndAgeUsingNamed(@Param("firstName") String firstName, @Param("age") int age);

    @Modifying
    @Query("Update Employee e set e.age=:age where e.id=:id")
    void updateUsingJPQL(@Param("age") int age, @Param("id") Long id);
}
