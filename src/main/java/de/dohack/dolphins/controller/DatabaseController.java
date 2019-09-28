package de.dohack.dolphins.controller;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

public class DatabaseController {

  //  public static final Logger logger = LogManager.getLogger("DolphinLogger");

  private final String persistence_unit_name = "dolphins";
  private EntityManagerFactory factory;
  private EntityManager manager;
  private CriteriaBuilder builder;
  private Properties properties;

  public DatabaseController() {
    setup();
  }

  public DatabaseController(Properties properties) {
    this.properties = properties;
    setup();
  }

  private void setup() {
    getEntityManagerFactory();
    manager = factory.createEntityManager();
    builder = factory.getCriteriaBuilder();
  }

  public final EntityManagerFactory getEntityManagerFactory() {
    if (factory == null) {
      try {
        factory = Persistence.createEntityManagerFactory(persistence_unit_name);
      } catch (Exception e) {
        //        logger.error(e);
      }
    }
    return factory;
  }

  public boolean persist(Collection<? extends Serializable> entities) {
    EntityTransaction transaction = null;
    try {
      transaction = manager.getTransaction();
      if (!transaction.isActive()) transaction.begin();

      for (Serializable entity : entities) manager.persist(entity);

      transaction.commit();
    } catch (Exception ex) {
      // If there are any exceptions, roll back the changes
      if (transaction != null) {
        transaction.rollback();
      }
      //      logger.error(ex);
      return false;
    }
    return true;
  }

  public boolean persist(Serializable entity) {
    return persist(
        (Collection<? extends Serializable>)
            Stream.of(entity).collect(Collectors.toCollection(HashSet::new)));
  }

  public <C extends Serializable> C find(Class<C> clazz, Object id) {
    C entity = null;
    try {
      entity = manager.find(clazz, id);
    } catch (Exception ex) {
      //      logger.error(ex);
      manager.flush();
    }
    return entity;
  }

  public List execNamedQuery(String queryName, List params) {
    List objs = null;
    //    logger.trace("Execute query '" + queryName + "'" + "with params {" + params.toString() +
    // "}");
    try {
      Query query = manager.createNamedQuery(queryName);
      int i = 1;
      for (Object obj : params) {
        query.setParameter(i++, obj);
      }
      objs = query.getResultList();
    } catch (Exception ex) {
      //      logger.error(ex);
    }
    return objs;
  }

  public Object execSingleResultNamedQuery(String queryName, List params) {
    Object res = null;
    try {
      Query query = manager.createNamedQuery(queryName);
      int i = 1;
      for (Object obj : params) {
        query.setParameter(i++, obj);
      }
      res = query.getSingleResult();
    } catch (Exception ex) {
      //      logger.error(ex);
    }
    return res;
  }

  @Deprecated
  public EntityManager getEntityManager() {
    return manager;
  }

  public void shutdown() {
    if (factory != null) {
      factory.close();
    }
    if (manager != null) {
      manager.close();
    }
  }

  public void flush() {
    EntityTransaction t = manager.getTransaction();
    if (!t.isActive()) t.begin();
    t.commit();
  }
}
