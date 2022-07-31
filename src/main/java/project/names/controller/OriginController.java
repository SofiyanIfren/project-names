package project.names.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.names.model.Origin;
import project.names.service.OriginService;

import java.util.List;

@RestController
@RequestMapping("/origin")
public class OriginController {

    @Autowired
    private OriginService originService;

    @GetMapping("/list")
    public List<Origin> getOrigins(){
        return originService.getOriginsFromBehindTheNames();
    }

}
