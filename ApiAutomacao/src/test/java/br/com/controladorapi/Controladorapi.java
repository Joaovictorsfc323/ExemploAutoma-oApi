package br.com.controladorapi;

import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;

public class Controladorapi {

	@Test
	
	public String apiGETRestricoes(String urlAPI) {
		Response resp = RestAssured.get(urlAPI);
		String code = Integer.toString(resp.getStatusCode());
		return code;
	}


	public String apiPOSTsimulacoes(String urlAPI, String cpf, String nome, String email, Integer valor,
			Integer parcelas, Boolean seguro) {
		System.out.print("\nURL: "+urlAPI);
		JSONObject requestParams = new JSONObject();
		//requestParams.put("id", 1);
		requestParams.put("nome", nome);
		requestParams.put("cpf", cpf);
		requestParams.put("email", email);
		requestParams.put("valor", valor);
		requestParams.put("parcelas", parcelas);
		requestParams.put("seguro", seguro);
		
		System.out.print("\n"+requestParams);
		Response resp = RestAssured
				.given()
				.header("Content-Type","application/json;charset=UTF-8")
				.body(requestParams.toString())
				.when()
				.post(urlAPI);
		
		

		
		//Response resp = RestAssured.post(urlAPI, pathParams)
		String code = Integer.toString(resp.getStatusCode());
		System.out.print("\n Status: "+code);
		return code;
	}

	public String apiPUTsimulacoes(String urlAPI, String cpf, String nome, String email, Integer valor,
			Integer parcelas, Boolean seguro) {
		System.out.print("\nURL: "+urlAPI);
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("nome", nome);
		requestParams.put("cpf", cpf);
		requestParams.put("email", email);
		requestParams.put("valor", valor);
		requestParams.put("parcelas", parcelas);
		requestParams.put("seguro", seguro);
		
		System.out.print("\n"+requestParams);
		Response resp = RestAssured
				.given()
				.header("Content-Type","application/json;charset=UTF-8")
				.body(requestParams.toString())
				.when()
				.put(urlAPI);
		
		

		
		//Response resp = RestAssured.post(urlAPI, pathParams)
		String code = Integer.toString(resp.getStatusCode());
		System.out.print("\n Status: "+code);
		return code;
	}

	public String apiGETSimulacao(String urlAPI) {
		Response resp = RestAssured.get(urlAPI);
		String code = Integer.toString(resp.getStatusCode());
		return code;
	}

	public String apiDELETESimulacao(String urlAPI) {
		Response resp = RestAssured.delete(urlAPI);
		String code = Integer.toString(resp.getStatusCode());
		return code;
	}

}
