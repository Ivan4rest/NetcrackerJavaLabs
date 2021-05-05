package JAXB;

import com.Contracts.Contract;
import com.Contracts.DigitalTVContract;
import com.Contracts.MobilePhoneContract;
import com.Contracts.WiredInternetContract;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class ContractXmlAdapter extends XmlAdapter <CommonContract, Contract> {
    @Override
    public Contract unmarshal(CommonContract commonContract) throws Exception {
        if (null == commonContract) {
            return null;
        }
        if (commonContract.channelPackages != null) {
            DigitalTVContract digitalTVContract = new DigitalTVContract(
                    commonContract.id,
                    commonContract.startDate,
                    commonContract.endDate,
                    commonContract.number,
                    commonContract.owner,
                    commonContract.channelPackages);
            return digitalTVContract;
        } else if ((commonContract.numberOfMinutes != 0) ||
                commonContract.numberOfSMS != 0 ||
                commonContract.amountOfTraffic != 0) {
            MobilePhoneContract mobilePhoneContract = new MobilePhoneContract(
                    commonContract.id,
                    commonContract.startDate,
                    commonContract.endDate,
                    commonContract.number,
                    commonContract.owner,
                    commonContract.numberOfMinutes,
                    commonContract.numberOfSMS,
                    commonContract.amountOfTraffic);
            return mobilePhoneContract;
        } else if (commonContract.connectionSpeed != 0) {
            WiredInternetContract wiredInternetContract = new WiredInternetContract(
                    commonContract.id,
                    commonContract.startDate,
                    commonContract.endDate,
                    commonContract.number,
                    commonContract.owner,
                    commonContract.connectionSpeed);
            return wiredInternetContract;
        }
        else{
            return null;
        }
    }

    @Override
    public CommonContract marshal(Contract contract) throws Exception {
        if (contract == null) {
            return null;
        }
        CommonContract commonContract = new CommonContract();
        if (contract instanceof DigitalTVContract) {
            DigitalTVContract digitalTVContract = (DigitalTVContract) contract;
            commonContract.id = digitalTVContract.getId();
            commonContract.startDate = digitalTVContract.getStartDate();
            commonContract.endDate = digitalTVContract.getEndDate();
            commonContract.number = digitalTVContract.getNumber();
            commonContract.owner = digitalTVContract.getOwner();
            commonContract.channelPackages = digitalTVContract.getChannelPackages();
        } else if (contract instanceof MobilePhoneContract) {
            MobilePhoneContract mobilePhoneContract = (MobilePhoneContract) contract;
            commonContract.id = mobilePhoneContract.getId();
            commonContract.startDate = mobilePhoneContract.getStartDate();
            commonContract.endDate = mobilePhoneContract.getEndDate();
            commonContract.number = mobilePhoneContract.getNumber();
            commonContract.owner = mobilePhoneContract.getOwner();
            commonContract.numberOfMinutes = mobilePhoneContract.getNumberOfMinutes();
            commonContract.numberOfSMS = mobilePhoneContract.getNumberOfSMS();
            commonContract.amountOfTraffic = mobilePhoneContract.getAmountOfTraffic();
        } else if (contract instanceof WiredInternetContract) {
            WiredInternetContract wiredInternetContract = (WiredInternetContract) contract;
            commonContract.id = wiredInternetContract.getId();
            commonContract.startDate = wiredInternetContract.getStartDate();
            commonContract.endDate = wiredInternetContract.getEndDate();
            commonContract.number = wiredInternetContract.getNumber();
            commonContract.owner = wiredInternetContract.getOwner();
            commonContract.connectionSpeed = wiredInternetContract.getConnectionSpeed();
        }
        return commonContract;
    }
}
