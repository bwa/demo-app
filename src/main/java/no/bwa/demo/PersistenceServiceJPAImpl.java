package no.bwa.demo;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestScoped
@Default // betyr at CDI bruker denne som default impl av  PersistenceService
public class PersistenceServiceJPAImpl implements PersistenceService {

    private static final Logger log = LoggerFactory.getLogger(PersistenceServiceJPAImpl.class);


    @PersistenceContext(name = "jpa-presistenceunit")
    private EntityManager em;

    public PersistenceServiceJPAImpl() {
        log.debug("PersistenceServiceJPAImpl created ... {}", this);
    }



	@Override
	public List<TestEntity> getEntities() {
		   TypedQuery<TestEntity> q = 
	                em.createQuery("SELECT t FROM TestEntity t "
	                ,TestEntity.class);
		   
           List<TestEntity> result =  q
	                .getResultList();
           
   	    	log.info("getEntities {}", result);
		   
		return result;
	}

	@Override
	public boolean addEntity(TestEntity entity) {
        em.persist(entity);
        log.info("addEntity ...Done {}", entity);
		return true;
	}

    
}