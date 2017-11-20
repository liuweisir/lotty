package com.game.www.wfcc.util;

import net.sf.json.xml.XMLSerializer;

import net.sf.json.JSONObject;

public class XmlJSON {

    public static String json2XML(String json){
        JSONObject jobj = JSONObject.fromObject(json);
        String xml =  new XMLSerializer().write(jobj);
        return xml;
    }
}