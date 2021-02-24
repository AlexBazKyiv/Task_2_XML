package com.example.api;

import com.example.api.model.Currency;
import com.example.api.repository.XmlRepository;
import com.example.api.servise.XMLClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.bind.JAXBException;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest
class RateApplicationTests {
    @Autowired
    private XMLClient xmlClient;

    @Autowired
    private XmlRepository xmlRepository;

    private String xmlFile = "<exchange>\n" +
            "<currency>\n" +
            "<r030>36</r030>\n" +
            "<txt>Австралійський долар</txt>\n" +
            "<rate>21.8806</rate>\n" +
            "<cc>AUD</cc>\n" +
            "<exchangedate>22.02.2021</exchangedate>\n" +
            "</currency>\n" +
            "<currency>\n" +
            "<r030>124</r030>\n" +
            "<txt>Канадський долар</txt>\n" +
            "<rate>22.0805</rate>\n" +
            "<cc>CAD</cc>\n" +
            "<exchangedate>22.02.2021</exchangedate>\n" +
            "</currency>\n" +
            "<currency>\n" +
            "<r030>156</r030>\n" +
            "<txt>Юань Женьміньбі</txt>\n" +
            "<rate>4.3148</rate>\n" +
            "<cc>CNY</cc>\n" +
            "<exchangedate>22.02.2021</exchangedate>\n" +
            "</currency>\n" +
            "<currency>\n" +
            "<r030>191</r030>\n" +
            "<txt>Куна</txt>\n" +
            "<rate>4.4574</rate>\n" +
            "<cc>HRK</cc>\n" +
            "<exchangedate>22.02.2021</exchangedate>\n" +
            "</currency>\n" +
            "</exchange>";

    @Test
    void contextLoads() {
    }

    @Test
    public void testXMLClient() throws JAXBException {
        xmlClient.saveXML(xmlFile);
        List<Currency> list = xmlRepository.findAllByOrderByIdDesc();
        assertThat(list, is(notNullValue()));
        assertThat(list.get(0).getCc(), is("HRK"));
        assertThat(list.get(0).getR030(), is("191"));
        assertThat(list.get(0).getRate(), is("4.4574"));
        assertThat(list.get(0).getTxt(), is("Куна"));
        assertThat(list.get(0).getExchangedate(), is("22.02.2021"));
    }
}
