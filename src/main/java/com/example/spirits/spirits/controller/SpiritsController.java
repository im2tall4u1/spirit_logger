package com.example.spirits.spirits.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spirits.spirits.model.Spirit;
import com.example.spirits.spirits.repository.SpiritsRepository;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin()
@RestController
public class SpiritsController{
    @Autowired
    SpiritsRepository spiritsRepository;

    @RequestMapping(value="/spirit", method=RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Spirit> insertSpirit(@RequestBody Spirit spirit){
        long existingSprits = spiritsRepository.count(); 
        spirit.setSpiritId((int)(existingSprits + 1000));
        Spirit s = spiritsRepository.save(spirit);
        return new ResponseEntity<Spirit>(s, HttpStatus.CREATED);
    }

    @RequestMapping(value="/spirit/{spiritId}", method=RequestMethod.PUT)
    public ResponseEntity<Spirit> updateSpiritUsingPathVariable(@Validated @RequestBody Spirit spirit, @PathVariable int spiritId ){
        Optional<Spirit> selectedSpirit = spiritsRepository.findById(spiritId);
        if (selectedSpirit.isPresent()){
            Spirit updatedSpirit = spiritsRepository.save(spirit);
            return new ResponseEntity<Spirit>(updatedSpirit, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<Spirit>(HttpStatus.NOT_FOUND);
        }
        
    }

    @RequestMapping(value="/spiritbyid", method=RequestMethod.GET)
    public ResponseEntity<Spirit> singularSpirit(@RequestParam int spiritId){
        Optional<Spirit> selectedSpirit = spiritsRepository.findById(spiritId);
        if (selectedSpirit.isPresent()){
            return new ResponseEntity<Spirit>(selectedSpirit.get(), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<Spirit>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/spirit/{spiritId}", method=RequestMethod.GET) // {} is a path variable. So in this case, it is id
    public ResponseEntity<Spirit> singularSpiritUsingPathVariable(@PathVariable int spiritId){
        Optional<Spirit> selectedSpirit = spiritsRepository.findById(spiritId);
        if (selectedSpirit.isPresent()){
            return new ResponseEntity<Spirit>(selectedSpirit.get(), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<Spirit>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/spirit", method=RequestMethod.GET)
    public ResponseEntity<List<Spirit>> allSpirits(){
        List<Spirit> spirits = spiritsRepository.findAll();
        return new ResponseEntity<List<Spirit>>(spirits, HttpStatus.ACCEPTED);
    }

    

    @RequestMapping(value="/spirit/{spiritId}", method=RequestMethod.DELETE)
    public ResponseEntity<Spirit> deleteSpirit(@PathVariable int spiritId){
        Optional<Spirit> selectedSpirit = spiritsRepository.findById(spiritId);
        if (selectedSpirit.isPresent()){
            spiritsRepository.deleteById(spiritId);
            return new ResponseEntity<Spirit>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<Spirit>(HttpStatus.NOT_FOUND);
        }
    }
    
}