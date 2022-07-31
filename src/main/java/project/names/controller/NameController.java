package project.names.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.names.model.Name;
import project.names.service.NameService;

import java.util.List;

@RestController
@RequestMapping("/name")
public class NameController {

    @Autowired
    private NameService nameService;

    @GetMapping("/list/{origin}")
    public List<Name> getNamesByOrigin(@PathVariable String origin){
        return nameService.getNamesFromBehindTheNames(origin);
    }

}
