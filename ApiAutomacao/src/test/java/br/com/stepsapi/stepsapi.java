package br.com.stepsapi;

import br.com.controladorapi.Controladorapi;
import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Entao;
import static org.junit.Assert.*;

public class stepsapi {
	Controladorapi controladorapi = new Controladorapi();

	private String cpf;
	private String StatusCod;
	private String nome;
	private String email;
	private Integer valor;
	private Integer parcelas;
	private Boolean seguro;
    private String id;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public Integer getParcelas() {
		return parcelas;
	}

	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}

	public Boolean getSeguro() {
		return seguro;
	}

	public void setSeguro(Boolean seguro) {
		this.seguro = seguro;
	}

	public String getStatusCod() {
		return StatusCod;
	}

	public void setStatusCod(String statusCod) {
		StatusCod = statusCod;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Dado("^fornece os cpf \"([^\"]*)\"$")
	public void fornece_os_cpf(String cpf) throws Throwable {
		setCpf(cpf);
		
		
	}
	
	@Dado("^deleto todas as simulacoes$")
	public void deleto_todas_as_simulacoes() throws Throwable {
		
		String host = "http://localhost:8080";
		for (int i = 0; i < 20; i++) {
			String urlAPI = host + "/api/v1/simulacoes/" + i;
			setStatusCod(controladorapi.apiDELETESimulacao(urlAPI));
		}

	}
	
	@Dado("^fornece os cpf nome email valor parcela seguro \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" <(\\d+)> <(\\d+)> \"([^\"]*)\"$")
	public void fornece_os_cpf_nome_email_valor_parcela_seguro(String cpf, String nome, String email, int valor, int parcela, String seguro) throws Throwable {
	
		setCpf(cpf);
		setNome(nome);
		setEmail(email);
		setValor(valor);
		setParcelas(parcela);
		if(seguro.equalsIgnoreCase("true")) {
			setSeguro(true);
		}else {
			setSeguro(false);
		}
		
		
	}
	
	@Dado("^fornece o id \"([^\"]*)\"$")
	public void fornece_o_id(String id) throws Throwable {
		setId(id);
	}

	@Quando("^que executa api\"([^\"]*)\"$")
	public void que_executa_api(String api) throws Throwable {

		String urlAPI = "";
		String host = "http://localhost:8080";

	
		if (api.equals("1")) {
			urlAPI = host + "/api/v1/simulacoes";
			setStatusCod(controladorapi.apiPOSTsimulacoes(urlAPI,getCpf(),nome,email,valor,parcelas,seguro));
		}
		if (api.equals("2")) {
			urlAPI = host + "/api/v1/simulacoes/"+getCpf();
			setStatusCod(controladorapi.apiPUTsimulacoes(urlAPI,getCpf(),nome,email,valor,parcelas,seguro));

		}
		if (api.equals("3")) {
			urlAPI = host + "/api/v1/restricoes/" + getCpf();
			setStatusCod(controladorapi.apiGETRestricoes(urlAPI));
		}
		if (api.equals("4")) {
			urlAPI = host + "/api/v1/simulacoes";
			setStatusCod(controladorapi.apiGETSimulacao(urlAPI));
		}
		if (api.equals("5")) {
			urlAPI = host + "/api/v1/simulacoes/" + getCpf();
			setStatusCod(controladorapi.apiGETSimulacao(urlAPI));
		}
		if (api.equals("6")) {
			urlAPI = host + "/api/v1/simulacoes/" + getId();
			setStatusCod(controladorapi.apiDELETESimulacao(urlAPI));
		}

	}

	@Entao("^retorna com sucesso \"([^\"]*)\"$")
	public void retorna_com_sucesso(String status) throws Throwable {
			
		assertEquals(status,StatusCod);
	}

}