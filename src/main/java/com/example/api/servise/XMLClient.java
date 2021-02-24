package com.example.api.servise;

import com.example.api.model.Currency;
import com.example.api.model.Exchange;
import com.example.api.repository.XmlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

@Service
public class XMLClient {
    @Autowired
    private XmlRepository xmlRepository;

    private Currency[] currencies;


    public void saveXML(String s) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(Exchange.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Reader reader = new StringReader(s);
        Exchange exchange = (Exchange) unmarshaller.unmarshal(reader);
        currencies = exchange.getCurrency();
        for (Currency c : currencies) {
            xmlRepository.save(c);
        }
    }
}
