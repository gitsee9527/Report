package com.example.demo.util;

import java.io.Reader;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class XmlBuilder {
	/**
	 * 将xml转为指定的pojo
	 * 
	 * @return
	 */
	public static Object xmlStrToObject(Class<?> clazz, String xmlStr) throws Exception {
		Object xmlObject = null;
		Reader reader = null;
		JAXBContext context = JAXBContext.newInstance(clazz);
		// XML zhuanwei 对象的接口
		Unmarshaller unmarshaller = context.createUnmarshaller();
		reader = new StringReader(xmlStr);
		xmlObject = unmarshaller.unmarshal(reader);

		if (null != reader) {
			reader.close();
		}
		return xmlObject;
	}
}
