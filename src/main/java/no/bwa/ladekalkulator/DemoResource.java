package no.bwa.ladekalkulator;

import javax.annotation.security.PermitAll;
import javax.inject.Singleton;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Path("/demo")
@PermitAll()
@Singleton
public class DemoResource {
	
    private static final Logger log = LoggerFactory.getLogger(DemoResource.class);	


    public DemoResource() {
        log.debug("DemoResource created ... {}", this);
    }

    @GET
	@Path("/hello")
    @PermitAll()

	public String versionInfo(
        @Context HttpServletRequest request
    ) {

        log.info("Hei, du er nå inne på DemoResource");
        
    	return "KalkulatorResource OK";		
	}
	
	

}
