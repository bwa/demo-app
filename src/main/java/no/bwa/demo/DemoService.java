package no.bwa.demo;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class DemoService {
    private static final Logger log = LoggerFactory.getLogger(DemoService.class);	

    @Inject
    private PersistenceService persistenceService;

    
    public DemoService(PersistenceService persistenceService) {
        log.info("KalkulatorService(PersistenceService) initialisert med persistenceService: {}", persistenceService);
        this.persistenceService = persistenceService;
    }
    
    public DemoService() {
        log.info("KalkulatorService() initialisert med CDI default persistenceService");
    }

    public boolean addEntity(TestEntity entity) {
        log.info("DemoService adding {}", entity);
        return persistenceService.addEntity(entity);
    }

    public List<TestEntity> getEntities() {
        return persistenceService.getEntities();
    }


}
