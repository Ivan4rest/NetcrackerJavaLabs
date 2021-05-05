package JAXB;

import com.Contracts.Person;

import javax.xml.bind.annotation.*;
import java.util.Calendar;

@XmlAccessorType(XmlAccessType.FIELD)
public class CommonContract {
    @XmlAttribute(name = "contractId")
    public int id;

    @XmlAttribute(name = "contractStartDate")
    public Calendar startDate;

    @XmlAttribute(name = "contractEndDate")
    public Calendar endDate;

    @XmlAttribute(name = "contractNumber")
    public int number;

    @XmlElement(name = "contractOwner")
    public Person owner;

    @XmlElement(name = "contractChannelPackage")
    @XmlElementWrapper
    public String[] channelPackages;

    @XmlAttribute(name = "contractNumberOfMinutes")
    public int numberOfMinutes;

    @XmlAttribute(name = "contractNumberOfSMS")
    public int numberOfSMS;

    @XmlAttribute(name = "contractAmountOfTraffic")
    public int amountOfTraffic;

    @XmlAttribute(name = "contractConnectionSpeed")
    public int connectionSpeed;

    public CommonContract() {
    }
}
