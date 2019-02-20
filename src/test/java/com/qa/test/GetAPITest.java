package com.qa.test;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.util.TestUtil;

public class GetAPITest extends TestBase {

	TestBase testBase;
	RestClient restClient;
	String serviceURL;
	String apiURL;
	String url;

	@BeforeMethod
	public void setUp() {
		testBase = new TestBase();

		serviceURL = prop.getProperty("serviceURL");
		apiURL = testBase.prop.getProperty("apiURL");
		url = serviceURL + apiURL;
	}

	@Test
	public void getAPITestWithoutheader() throws ClientProtocolException, IOException {
		restClient = new RestClient();
		CloseableHttpResponse httpResponse = restClient.get(url);

		// a. Get Status code
		int statusCode = httpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code is--->" + statusCode);

		// b. Get Json Response
		String responseString = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responseString);
		System.out.println("Response JSON is--->" + responseJson);

		// single value assertion:
		// per_page:
		String perPageValue = TestUtil.getValueByJPath(responseJson, "/per_page");
		System.out.println("Per page value is--->" + perPageValue);
		Assert.assertEquals(Integer.parseInt(perPageValue), 3);

		// total:
		String totalValue = TestUtil.getValueByJPath(responseJson, "/total");
		System.out.println("value of total is-->" + totalValue);
		Assert.assertEquals(Integer.parseInt(totalValue), 12);
		
		//get the value from JSON ARRAY:
		String lastName = TestUtil.getValueByJPath(responseJson, "/data[0]/last_name");
		String id = TestUtil.getValueByJPath(responseJson, "/data[0]/id");
		String avatar = TestUtil.getValueByJPath(responseJson, "/data[0]/avatar");
		String firstName = TestUtil.getValueByJPath(responseJson, "/data[0]/first_name");
		
		System.out.println(lastName);
		System.out.println(id);
		System.out.println(avatar);
		System.out.println(firstName);
		
		// c. Get all headers
		Header[] headerArray = httpResponse.getAllHeaders();

		HashMap<String, String> allHeaders = new HashMap<String, String>();

		for (Header header : headerArray) {
			allHeaders.put(header.getName(), header.getValue());
		}

		System.out.println("Headers Array--->" + allHeaders);
	}
	
	@Test
	public void getAPITestWithHeader() throws ClientProtocolException, IOException {
		restClient = new RestClient();
		CloseableHttpResponse httpResponse = restClient.get(url);

		// a. Get Status code
		int statusCode = httpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code is--->" + statusCode);

		// b. Get Json Response
		String responseString = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responseString);
		System.out.println("Response JSON is--->" + responseJson);

		// single value assertion:
		// per_page:
		String perPageValue = TestUtil.getValueByJPath(responseJson, "/per_page");
		System.out.println("Per page value is--->" + perPageValue);
		Assert.assertEquals(Integer.parseInt(perPageValue), 3);

		// total:
		String totalValue = TestUtil.getValueByJPath(responseJson, "/total");
		System.out.println("value of total is-->" + totalValue);
		Assert.assertEquals(Integer.parseInt(totalValue), 12);
		
		//get the value from JSON ARRAY:
		String lastName = TestUtil.getValueByJPath(responseJson, "/data[0]/last_name");
		String id = TestUtil.getValueByJPath(responseJson, "/data[0]/id");
		String avatar = TestUtil.getValueByJPath(responseJson, "/data[0]/avatar");
		String firstName = TestUtil.getValueByJPath(responseJson, "/data[0]/first_name");
		
		System.out.println(lastName);
		System.out.println(id);
		System.out.println(avatar);
		System.out.println(firstName);
		
		// c. Get all headers
		Header[] headerArray = httpResponse.getAllHeaders();

		HashMap<String, String> allHeaders = new HashMap<String, String>();

		for (Header header : headerArray) {
			allHeaders.put(header.getName(), header.getValue());
		}

		System.out.println("Headers Array--->" + allHeaders);
	}
}
