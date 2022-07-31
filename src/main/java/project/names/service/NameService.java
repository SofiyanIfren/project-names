package project.names.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import project.names.dao.NameRepository;
import project.names.http.HttpName;
import project.names.model.Name;

import java.util.List;

@Service(value="nameService")
public class NameService {

    @Autowired
    private NameRepository nameRepository;

    public List<Name> getNamesFromBehindTheNames(String origin){
        HttpName httpName = new HttpName(); // TODO : use dependecy injection
        String nameHtmlPage = httpName.getHtmlNamesPage(origin);
        List<Name> nameList = httpName.getNames(nameHtmlPage);
        for (Name name : nameList){
            nameRepository.save(name);
        }
        return nameList;
    }

}
