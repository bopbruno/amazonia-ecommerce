package br.com.amazonia.ecommerce.service;

import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import br.com.amazonia.ecommerce.domain.DetalheFrete;
import br.com.amazonia.ecommerce.domain.Encomenda;
import br.com.amazonia.ecommerce.exception.FreteNaoCalculadoException;
import br.com.amazonia.ecommerce.interfaces.Enviavel;

public final class FreteServiceImpl {

	private static FreteServiceImpl freteService = new FreteServiceImpl();
	
	private static final String USER_AGENT = "Mozilla/5.0";
	
	private FreteServiceImpl() {}
	
	public static FreteServiceImpl getInstance() {
		return freteService;
	}
	
	public DetalheFrete calcularFrete(String cdAvisoRecebimento,String cdMaoPropria,String cdServico, String cepDestino, Enviavel enviavel) throws Exception {
		
		Encomenda encomenda = enviavel.getEncomendaASerEnviada();
		double custoEnvio = 0;
		int prazoEntrega = 0;
		
		String GET_URL = "http://ws.correios.com.br/calculador/CalcPrecoPrazo.aspx?"
				+"sCepOrigem=04094-050"
				+"&sCepDestino="+cepDestino
				+"&nVlPeso="+ encomenda.getPeso()
				+"&nVlComprimento="+ encomenda.getComprimento()
				+"&nVlAltura="+ encomenda.getAltura()
				+"&nVlLargura="+ encomenda.getLargura()
				+"&nVlDiametro="+encomenda.getDiametro()
				+"&nCdFormato="+encomenda.getCdFormato()
				+"&sCdMaoPropria="+cdMaoPropria
				+"&sCdAvisoRecebimento="+cdAvisoRecebimento
				+"&nVlValorDeclarado="+encomenda.getValorDeclarado()
				+"&nCdServico="+cdServico
				+"&nCdEmpresa=&sDsSenha=&StrRetorno=xml";
		
		
		Document document = null;
		
		try {

			URL obj = new URL(GET_URL);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", USER_AGENT);
			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
				document = documentBuilder.parse(con.getInputStream());
			} else {
				throw new Exception("Erro na requisição de calculo de frete enviada ao correio. Retorno: Codigo Http  "+responseCode);
			}
			
			
			String custoEnvioString = document.getElementsByTagName("Valor").item(0).getTextContent();
			String prazoEntregaString = document.getElementsByTagName("PrazoEntrega").item(0).getTextContent();
			
			if( !document.getElementsByTagName("Erro").item(0).getTextContent().equals("0")) {
				throw new FreteNaoCalculadoException("Erro ao calcular o frete."+document.getElementsByTagName("MsgErro").item(0).getTextContent());
			}
			
			custoEnvioString = custoEnvioString.replace(",", ".");
			prazoEntregaString = prazoEntregaString.replace(",", ".");
			
			custoEnvio = Double.parseDouble(custoEnvioString);
			prazoEntrega = Integer.parseInt(prazoEntregaString);
			
			DetalheFrete detalheFrete = new DetalheFrete(cepDestino, custoEnvio, prazoEntrega);
			
			return detalheFrete;
		} catch (Exception e) {
			throw e;
		}
	}
}