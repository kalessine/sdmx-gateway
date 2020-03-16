package sdmx.gateway;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class SdmxGateway extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(RegistryService.class);
        classes.add(RepositoryService.class);
        return classes;
    }
}