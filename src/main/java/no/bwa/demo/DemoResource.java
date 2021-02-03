package no.bwa.demo;

import java.util.List;
import java.util.UUID;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Path("demo")
@PermitAll()
@Singleton
public class DemoResource {

    private static final Logger log = LoggerFactory.getLogger(DemoResource.class);
    
	@Inject
    DemoService service;


    public DemoResource() {
        log.debug("DemoResource created ... {}", this);
    }

    @GET
    @Path("hello")
    @PermitAll()
    
    
    /*
     *  betyr at alle database operasjoner som utføres i sayHello metoden
     *  blir utført på en transaksjon, og om noe går galt, så rulles alle endringer tilbake
     */
    @Transactional 

    public String sayHello(@Context HttpServletRequest request) {

        log.info("Hei, du er nå inne på DemoResource");

        try {
            // lager en kunstig tenketidspause
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        /*
         * NB! Man skal normalt ikke utføre logikk i REST-Tjenesten, men heller delegere det til 'service'
         * men for demo formål blir dette gjort her
         */
        
        // prøve å lese noe fra database
        
        List<TestEntity> entities = service.getEntities();
        
        // er det lite data å lese, så inserter vi en rad
        if(entities.size()==0) {
        	String randomId = UUID.randomUUID().toString();
        	service.addEntity(new TestEntity(randomId, "navnet til " + randomId));
        }
        
    	return "Greetings fra DemoResource, antall rader fra databasen er " + entities.size();		
	}
	
	

}
