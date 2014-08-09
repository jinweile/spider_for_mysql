package com.jt.https.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class send {
	public static String PostTo(String content){
		String responseMessage = null;
		String filePath = "";
		if (!filePath.endsWith("/")) {
			filePath = filePath + "/";
		}
		HttpClient httpclient = new DefaultHttpClient();
		try {
			KeyStore keystore = KeyStore.getInstance("jks");
			KeyStore trustStore = KeyStore.getInstance("jks");

			FileInputStream keystoreInstream = new FileInputStream(new File("F:\\temp\\平安证书\\lz\\pingan2jiangtai_test.jks"));
			FileInputStream trustStoreInstream = new FileInputStream(new File("F:\\temp\\平安证书\\lz\\pingan2jiangtai_test_trust.jks"));
			try {
				keystore.load(keystoreInstream, "123456".toCharArray());
				trustStore.load(trustStoreInstream, "123456".toCharArray());
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (CertificateException e) {
				e.printStackTrace();
			} finally {
				keystoreInstream.close();
				trustStoreInstream.close();
			}
			SSLSocketFactory socketFactory = new SSLSocketFactory(
					SSLSocketFactory.SSL, keystore, "123456",
					trustStore, null, new TrustStrategy() {
						public boolean isTrusted(X509Certificate[] chain,
								String authType) throws CertificateException {
							return true;
						}
					}, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			Scheme sch = new Scheme("https", 8007, socketFactory);

			httpclient.getConnectionManager().getSchemeRegistry().register(sch);
			HttpPost post = new HttpPost("https://222.68.184.181:8007");

			StringEntity entity = new StringEntity(content, "text/html", "UTF-8");
			post.setEntity(entity);
			HttpResponse res = httpclient.execute(post);
			HttpEntity resEntity = res.getEntity();
			if (resEntity != null) {
				responseMessage = convertStreamToString(resEntity.getContent()) ;
				System.out.println("发送数据：" + content);
				System.out.println("结果数据：" + responseMessage);
			}
			
		} catch (KeyStoreException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnrecoverableKeyException e) {
			e.printStackTrace();
		} finally {
			httpclient.getConnectionManager().shutdown();
		}

		return responseMessage;
	}
	
	public static String convertStreamToString(InputStream is) {
		/*
		 * To convert the InputStream to String we use the
		 * BufferedReader.readLine() method. We iterate until the BufferedReader
		 * return null which means there's no more data to read. Each line will
		 * appended to a StringBuilder and returned as String.
		 */
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) throws Exception {
		String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?><ChinaTourinsApply xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"><Head><UserId>0000000000</UserId><CommandId>CTAA0001</CommandId><SeqNo>JT2014_0000000263863</SeqNo></Head><Body><Apply><ApplyId>1201201407256948</ApplyId><TravelAgencyInfo><Id>1129035</Id><Name>临安友好旅行社有限公司</Name><Address>临安市锦城街道临天八弄45号一楼</Address><Zipcode>310000</Zipcode><Telphone>0571-63700288</Telphone><License>L-ZJ00295</License><OrgCode>79093228-2</OrgCode><OutboundTourismCredentials>N</OutboundTourismCredentials><LastYearTouristAmount>0.0</LastYearTouristAmount><LastYearRevenue>0-600万元</LastYearRevenue><last3YearAccidents>N</last3YearAccidents><Last1YearAccidentsFee>0.0</Last1YearAccidentsFee><Last2YearAccidentsFee>0.0</Last2YearAccidentsFee><Last3YearAccidentsFee>0.0</Last3YearAccidentsFee><Contact><Name>沈亚平</Name><Telphone>0571-63700288</Telphone><Mail>385816647@qq.ocm</Mail><Fax>0571-63700288</Fax></Contact><Branches /><Location><ProvinceId>12</ProvinceId><ProvinceName>浙江省</ProvinceName><CityId>1201</CityId><CityName>杭州</CityName></Location><Properties><Key Name=\"LastApplyNo\" /><Key Name=\"LastPolicyNo\" /><Key Name=\"NewNum\" /><Key Name=\"NewLocation\" /></Properties><Last1YearPolicyNoList><Last1YearPolicyNoInfo><UserId /><PolicyNo /></Last1YearPolicyNoInfo></Last1YearPolicyNoList></TravelAgencyInfo><InsurancePolicyInfo><BeginDate>20140801</BeginDate><EndDate>20141231</EndDate><InsuranceDays>153</InsuranceDays><Renewal>N</Renewal><IssuingCompanyId>2014004</IssuingCompanyId><IssuingCompanyName>中国人民财产保险股份有限公司杭州市分公司</IssuingCompanyName><IssuingGeneralCompanyName>中国人民财产保险股份有限公司</IssuingGeneralCompanyName><RetroactiveDate>20140801</RetroactiveDate><MainInsurance><EachAccidentLiabilityLimit>20141000</EachAccidentLiabilityLimit><EachAccidentEveryLiabilityLimit>20142004</EachAccidentEveryLiabilityLimit><Properties><Key Name=\"MainPremium\">3135.4509</Key></Properties></MainInsurance><AdditionalInfo><Properties /></AdditionalInfo><PayDate>20140730</PayDate><PremiumInfo><PremiumAdjustmentFactor><YearTouristAmountRatio>-0.15</YearTouristAmountRatio><DistrictRatio>0</DistrictRatio><EachAccidentEveryLiabilityLimitRatio>0.1</EachAccidentEveryLiabilityLimitRatio><LossRatio>0</LossRatio><PreviousLossRatio>0</PreviousLossRatio><AdditionalRatio>0</AdditionalRatio><RiskControlRatio>0</RiskControlRatio><LoyaltyRatio>0</LoyaltyRatio><CoverageRateSystem>0</CoverageRateSystem><DatePreferentialRatio /></PremiumAdjustmentFactor><PremiumDistribution><TotalPremium>3135.45</TotalPremium><Distribution><RenBao CompanyId=\"2014004\">1442.30</RenBao><TaiBao CompanyId=\"2014058\">501.67</TaiBao><RenShou CompanyId=\"2014049\">250.84</RenShou><PingAn CompanyId=\"2014060\">344.90</PingAn><DaDi CompanyId=\"2014045\">282.19</DaDi><TaiPing CompanyId=\"2014039\">313.55</TaiPing></Distribution></PremiumDistribution><PremiumAdjust><RiskControl>0</RiskControl><Prepaid /></PremiumAdjust></PremiumInfo></InsurancePolicyInfo></Apply></Body></ChinaTourinsApply>";
		PostTo(xml);
	}
	
}
