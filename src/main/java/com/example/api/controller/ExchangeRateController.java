package com.example.api.controller;

import com.example.api.model.Currency;
import com.example.api.servise.XMLClient;
import com.example.api.repository.XmlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBException;
import java.util.List;

@RestController
public class ExchangeRateController {
    @Autowired
    private XmlRepository xmlRepository;
    @Autowired
    private XMLClient xmlClient;

    @GetMapping("/xml")
    public ResponseEntity getXMLTable() {
        List<Currency> list = xmlRepository.findAllByOrderByIdDesc();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/xml",
            method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity xmlFiles(@RequestBody String s) throws JAXBException {
        xmlClient.saveXML(s);
        List<Currency> list = xmlRepository.findAllByOrderByIdDesc();
        return new ResponseEntity(list, HttpStatus.OK);
    }
}
