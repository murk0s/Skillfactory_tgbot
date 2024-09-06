package ru.skillfactorydemo.tgbot.service;

import lombok.Value;
import org.springframework.ws.client.core.WebServiceTemplate;
import ru.skillfactorydemo.tgbot.DTO.GetCursOnDateXml;
import ru.skillfactorydemo.tgbot.DTO.GetCursOnDateXmlResponse;
import ru.skillfactorydemo.tgbot.DTO.ValuteCursOnDate;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

//Данный класс наследуется от WebServiceTemplate, который предоставляет удобный способ взаимодействия с SOAP веб сервисами
public class CentralRussianBankService extends WebServiceTemplate {
    //Тут случается некоторая магия Spring и в момент запуска вашего приложения, сюда поставляется значение из application.properties или application.yml
//    @Value("${cbr.api.url}")
//    private String cbrApiUrl;
    //@Value("http://www.cbr.ru/dailyinfowebserv/dailyinfo.asmx?wsdl")
    private final String cbrApiUrl = "http://www.cbr.ru/dailyinfowebserv/dailyinfo.asmx?wsdl";

    public List<ValuteCursOnDate> getCurrenciesFromCbr() throws DatatypeConfigurationException {
        final GetCursOnDateXml getCursOnDateXML = new GetCursOnDateXml();
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(new Date());

        XMLGregorianCalendar xmlGregCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
        getCursOnDateXML.setOnDate(xmlGregCal);
        System.out.println(this.getMarshaller());

        GetCursOnDateXmlResponse response = (GetCursOnDateXmlResponse) marshalSendAndReceive(cbrApiUrl, getCursOnDateXML);

        if (response == null) {
            throw new IllegalStateException("Could not get response from CBR Service");
        }

        //(
        final List<ValuteCursOnDate> courses = response.getGetCursOnDateXmlResult().getValuteData();
        courses.forEach(course -> course.setName(course.getName().trim()));
        //final List<ValuteCursOnDate> courses = new ArrayList<ValuteCursOnDate>();
        //)
        return courses;
    }
}
