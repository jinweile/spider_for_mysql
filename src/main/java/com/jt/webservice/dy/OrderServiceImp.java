package com.jt.webservice.dy;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import javax.activation.DataHandler;
import javax.activation.DataSource;

import com.jt.webservice.dy.AcciInfServiceStub.ApplyExecute;
import com.jt.webservice.dy.AcciInfServiceStub.EndorExecute;

public class OrderServiceImp implements OrderService {

	//private String url;
	/**
	 * 太平导游险地址
	 * @param url
	 */
	/*public void setUrl(String url){
		this.url = url;
	}*/
	
	private AcciInfServiceStub wclient;
	/**
	 * 
	 * @param wclient
	 */
	public void setWclient(AcciInfServiceStub wclient) {
		this.wclient = wclient;
	}

	/**
	 * 出单
	 */
	public String applyExecute(byte[] xml) throws Exception {
		final byte[] xml_in = xml;
		//AcciInfServiceStub wclient = new AcciInfServiceStub(url);
        ApplyExecute obj = new ApplyExecute();
        DataHandler param = new DataHandler(new DataSource() {  
            public InputStream getInputStream() {  
                return new ByteArrayInputStream(xml_in);  
            }  
            public OutputStream getOutputStream() {  
                return null;  
            }  
            public String getContentType() {  
                return "";  
            }  
            public String getName() {  
                return "";  
            }  
        });
        obj.setXml(param);
        
        AcciInfServiceStub.ApplyExecuteResponse response = wclient.applyExecute(obj);
        InputStream is = response.getApplyExecuteReturn().getInputStream();
		String xml_result = ConvertStreamToString(is);
		
		return xml_result;
	}

	/**
	 * 契撤
	 */
	public String endorExecute(byte[] xml) throws Exception {
		final byte[] xml_in = xml;
		//AcciInfServiceStub wclient = new AcciInfServiceStub(url);
		EndorExecute obj = new EndorExecute();
        DataHandler param = new DataHandler(new DataSource() {  
            public InputStream getInputStream() {  
                return new ByteArrayInputStream(xml_in);  
            }  
            public OutputStream getOutputStream() {  
                return null;  
            }  
            public String getContentType() {  
                return "";  
            }  
            public String getName() {  
                return "";  
            }  
        });
        obj.setXml(param);
        
        AcciInfServiceStub.EndorExecuteResponse response = wclient.endorExecute(obj);
        InputStream is = response.getEndorExecuteReturn().getInputStream();
		String xml_result = ConvertStreamToString(is);
		
		return xml_result;
	}
	
	/**
	 * is转成string
	 * @param is
	 * @return
	 * @throws IOException
	 */
	private static String ConvertStreamToString(InputStream is) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = reader.readLine()) != null) {
			sb.append(line + "\n");
		}
		return sb.toString();
	}
	
}
