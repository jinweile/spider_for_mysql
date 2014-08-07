package com.etaoshi.spider.comm;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import javax.activation.DataHandler;
import javax.activation.DataSource;

import com.thoughtworks.xstream.XStream;

public class XMLHelper {
	/**
	 * 默认编码格式
	 */
	private static final String DEFAULT_CHARSET_NAME = "UTF-8";

	/**
	 * 
	 */
	private static final XStream xstream = new XStream();

	/**
	 * 序列化
	 * 
	 * @param object
	 * @return
	 */
	public static <T> String serialize(T object) {
		return xstream.toXML(object);
	}

	/**
	 * 反序列化
	 * 
	 * @param string
	 * @param clz
	 * @return
	 */
	public static <T> T deserialize(String string) {
		return (T) xstream.fromXML(string);
	}

	/**
	 * 加载xml文件
	 * 
	 * @param path
	 * @param clz
	 * @return
	 * @throws IOException
	 */
	public static <T> T load(Path path, Class<T> clz) throws IOException {
		return deserialize(new String(Files.readAllBytes(path),
				DEFAULT_CHARSET_NAME));
	}

	/**
	 * 保存为xml文件
	 * 
	 * @param path
	 * @param object
	 * @throws IOException
	 */
	public static <T> void save(Path path, T object) throws IOException {
		if (Files.notExists(path.getParent())) {
			Files.createDirectories(path.getParent());
		}
		Files.write(path, serialize(object).getBytes(DEFAULT_CHARSET_NAME),
				StandardOpenOption.WRITE, StandardOpenOption.CREATE,
				StandardOpenOption.TRUNCATE_EXISTING);
	}
	
	public static void main(String[] args) throws Exception {
		String xml = "﻿<?xml version=\"1.0\" encoding=\"utf-8\"?><ChinaTourinsApply xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"><Head><UserId>0000000000</UserId><CommandId>CTAA0001</CommandId><SeqNo>JT2014_0000000263863</SeqNo></Head><Body><Apply><ApplyId>1201201407256948</ApplyId><TravelAgencyInfo><Id>1129035</Id><Name>临安友好旅行社有限公司</Name><Address>临安市锦城街道临天八弄45号一楼</Address><Zipcode>310000</Zipcode><Telphone>0571-63700288</Telphone><License>L-ZJ00295</License><OrgCode>79093228-2</OrgCode><OutboundTourismCredentials>N</OutboundTourismCredentials><LastYearTouristAmount>0.0</LastYearTouristAmount><LastYearRevenue>0-600万元</LastYearRevenue><last3YearAccidents>N</last3YearAccidents><Last1YearAccidentsFee>0.0</Last1YearAccidentsFee><Last2YearAccidentsFee>0.0</Last2YearAccidentsFee><Last3YearAccidentsFee>0.0</Last3YearAccidentsFee><Contact><Name>沈亚平</Name><Telphone>0571-63700288</Telphone><Mail>385816647@qq.ocm</Mail><Fax>0571-63700288</Fax></Contact><Branches /><Location><ProvinceId>12</ProvinceId><ProvinceName>浙江省</ProvinceName><CityId>1201</CityId><CityName>杭州</CityName></Location><Properties><Key Name=\"LastApplyNo\" /><Key Name=\"LastPolicyNo\" /><Key Name=\"NewNum\" /><Key Name=\"NewLocation\" /></Properties><Last1YearPolicyNoList><Last1YearPolicyNoInfo><UserId /><PolicyNo /></Last1YearPolicyNoInfo></Last1YearPolicyNoList></TravelAgencyInfo><InsurancePolicyInfo><BeginDate>20140801</BeginDate><EndDate>20141231</EndDate><InsuranceDays>153</InsuranceDays><Renewal>N</Renewal><IssuingCompanyId>2014004</IssuingCompanyId><IssuingCompanyName>中国人民财产保险股份有限公司杭州市分公司</IssuingCompanyName><IssuingGeneralCompanyName>中国人民财产保险股份有限公司</IssuingGeneralCompanyName><RetroactiveDate>20140801</RetroactiveDate><MainInsurance><EachAccidentLiabilityLimit>20141000</EachAccidentLiabilityLimit><EachAccidentEveryLiabilityLimit>20142004</EachAccidentEveryLiabilityLimit><Properties><Key Name=\"MainPremium\">3135.4509</Key></Properties></MainInsurance><AdditionalInfo><Properties /></AdditionalInfo><PayDate>20140730</PayDate><PremiumInfo><PremiumAdjustmentFactor><YearTouristAmountRatio>-0.15</YearTouristAmountRatio><DistrictRatio>0</DistrictRatio><EachAccidentEveryLiabilityLimitRatio>0.1</EachAccidentEveryLiabilityLimitRatio><LossRatio>0</LossRatio><PreviousLossRatio>0</PreviousLossRatio><AdditionalRatio>0</AdditionalRatio><RiskControlRatio>0</RiskControlRatio><LoyaltyRatio>0</LoyaltyRatio><CoverageRateSystem>0</CoverageRateSystem><DatePreferentialRatio /></PremiumAdjustmentFactor><PremiumDistribution><TotalPremium>3135.45</TotalPremium><Distribution><RenBao CompanyId=\"2014004\">1442.30</RenBao><TaiBao CompanyId=\"2014058\">501.67</TaiBao><RenShou CompanyId=\"2014049\">250.84</RenShou><PingAn CompanyId=\"2014060\">344.90</PingAn><DaDi CompanyId=\"2014045\">282.19</DaDi><TaiPing CompanyId=\"2014039\">313.55</TaiPing></Distribution></PremiumDistribution><PremiumAdjust><RiskControl>0</RiskControl><Prepaid /></PremiumAdjust></PremiumInfo></InsurancePolicyInfo></Apply></Body></ChinaTourinsApply>";
		final byte[] result = xml.getBytes(Charset.forName("GBK"));
		//System.out.println(result);
		
		HwWebServiceStub client = new HwWebServiceStub();
		HwWebServiceStub.GetMessage msg = new HwWebServiceStub.GetMessage();
		DataHandler param = new DataHandler(new DataSource() {  
            public InputStream getInputStream() {  
                return new ByteArrayInputStream(result);  
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
		msg.setMsg(param);
		HwWebServiceStub.GetMessageResponse response = client.getMessage(msg);
		InputStream is = response.get_return().getInputStream();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int readcount = 0;
		while((readcount = is.read(buffer, 0, buffer.length)) > 0){
			baos.write(buffer, 0, readcount);
		}
		String xml_result = new String(baos.toByteArray(),Charset.forName("GBK"));
		System.out.println(xml_result);
	}
}
