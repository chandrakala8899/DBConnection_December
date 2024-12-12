package com.neoteric.dec_dbconnection.jpa_db;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class EmployeeService {

public List<ProjectEntity> projectAlloctionEmployees(){
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JpaDemo");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    entityManager.getTransaction().begin();

    Query query = entityManager.createQuery("select distinct(p) FROM ProjectEntity p inner join p.employees e ", ProjectEntity.class);

    List<ProjectEntity> projectEntities = query.getResultList();

    entityManager.getTransaction().commit();
  return  projectEntities;
}


    public List<ProjectEntity> projectAlloctionJoinFetch(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JpaDemo");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("select p FROM ProjectEntity p  join fetch p.employees e ", ProjectEntity.class);

        List<ProjectEntity> projectEntities = query.getResultList();

        entityManager.getTransaction().commit();
        return  projectEntities;
    }

    public  List<ProjectEntity> projectAlloctionEmployeesLeftJoin(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JpaDemo");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("select p FROM ProjectEntity p Left join p.employees e ", ProjectEntity.class);

        List<ProjectEntity> projectEntities = query.getResultList();

        entityManager.getTransaction().commit();
        return  projectEntities;
    }


    public  List<ProjectEntity> projectAlloctionEmployeesRightJoin(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JpaDemo");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("select p FROM ProjectEntity p Right join p.employees e ", ProjectEntity.class);

        List<ProjectEntity> projectEntities = query.getResultList();

        entityManager.getTransaction().commit();
        return  projectEntities;
    }


    public static List<EmployeeEntity> projectAlloctionEmployeesEmployeeEntity(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JpaDemo");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("SELECT e FROM EmployeeEntity e", EmployeeEntity.class);

        List<EmployeeEntity> projectEntities = query.getResultList();

        entityManager.getTransaction().commit();
        return  projectEntities;
    }

    public  List<EmployeeEntity> projectAlloctionEmployeesSelfJoin(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JpaDemo");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        String jpql = "select m.name, e from EmployeeEntity e, EmployeeEntity m where e.mid = m.id";

        Query query = entityManager.createQuery(jpql, EmployeeEntity.class);

        List<EmployeeEntity> employeeEntities = query.getResultList();

        entityManager.getTransaction().commit();

        return  employeeEntities;
    }



    public static List<EmployeeEntity> projectAlloctionEmployeesJoin(){
    int projectId = 1;
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JpaDemo");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        String hql = "SELECT p FROM EmployeeEntity p " +
                "INNER JOIN p.project e " +
                "WHERE e.id = :projectId";
        Query query = entityManager.createQuery(hql,EmployeeEntity.class);
        query.setParameter("projectId", projectId);
        List<EmployeeEntity> employees = query.getResultList();
        entityManager.getTransaction().commit();


        return employees;
    }
}
