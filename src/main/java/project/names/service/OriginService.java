package project.names.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import project.names.dao.OriginRepository;
import project.names.http.HttpOrigin;
import project.names.model.Origin;

import java.util.List;

@Service(value="originService")
public class OriginService {

    @Autowired
    private OriginRepository originRepository;

    public List<Origin> getOriginsFromBehindTheNames(){
        HttpOrigin httpOrigin = new HttpOrigin(); // TODO : use dependecy injection
        String originsPage = httpOrigin.getHtmlOriginsPage();
        List<Origin> origins = httpOrigin.getOrigins(originsPage);
        for (Origin origin : origins){
            originRepository.save(origin);
        }
        return origins;
    }
}
