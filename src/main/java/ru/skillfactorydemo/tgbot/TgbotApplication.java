package ru.skillfactorydemo.tgbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.skillfactorydemo.tgbot.DTO.GetCursOnDateXml;
import ru.skillfactorydemo.tgbot.DTO.GetCursOnDateXmlResponse;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
//(
import org.springframework.ws.client.core.WebServiceTemplate;
import ru.skillfactorydemo.tgbot.DTO.ValuteCursOnDate;
import ru.skillfactorydemo.tgbot.service.CentralRussianBankService;
//)

@SpringBootApplication
public class TgbotApplication {
	private static final CentralRussianBankService centralRussianBankService = new CentralRussianBankService();

	public static void main(String[] args) {
		try {
			//List<ValuteCursOnDate> listValute = centralRussianBankService.getCurrenciesFromCbr();
			SpringApplication.run(TgbotApplication.class, args);
		} catch (Exception e) {
			System.out.println("не сработало");
		}


//		final GetCursOnDateXml getCursOnDateXML = new GetCursOnDateXml();
//		GregorianCalendar cal = new GregorianCalendar();
//		cal.setTime(new Date());
//
//		try {
//			XMLGregorianCalendar xmlGregCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
//			getCursOnDateXML.setOnDate(xmlGregCal);
//
//			GetCursOnDateXmlResponse response = (GetCursOnDateXmlResponse) new WebServiceTemplate().marshalSendAndReceive("http://www.cbr.ru/dailyinfowebserv/dailyinfo.asmx?wsdl", getCursOnDateXML);
//			if (response == null) {
//				throw new IllegalStateException("Could not get response from CBR Service");
//			}
//		}
//		catch (Exception e){}
	}

}
