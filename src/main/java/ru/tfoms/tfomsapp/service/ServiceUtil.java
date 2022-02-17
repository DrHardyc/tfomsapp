package ru.tfoms.tfomsapp.service;

import nu.xom.Element;
import org.springframework.stereotype.Service;

@Service
public class ServiceUtil {

    public String getChildValueByName(Element element, String name){
        if (element.getLocalName().equals(name)){
            return element.getValue();
        }
        return "";
    }

    public void showMessagesEx(String str){
        System.out.println(str);
        //Notification.show(str);
    }
}
