package br.com.amazonia.ecommerce.service;

import java.math.BigDecimal;

import br.com.correios.CResultado;
import br.com.correios.CalcPrecoPrazoWSLocator;
import br.com.correios.CalcPrecoPrazoWSSoap;

public final class FreteServiceImpl {

	private static FreteServiceImpl freteService = new FreteServiceImpl();
	
	private FreteServiceImpl() {}
	
	public static FreteServiceImpl getInstance() {
		return freteService;
	}
	
	public CResultado calcularFrete(String sCepDestino,String nVlPeso,BigDecimal nVlComprimento,BigDecimal nVlAltura,BigDecimal nVlLargura,BigDecimal nVlDiametro,BigDecimal nVlValorDeclarado,String nCdServico) {
		
		String nCdEmpresa = "";
		String sDsSenha = "";
		//String nCdServico = "04510";
		String sCepOrigem = "04094-050";
		//String sCepDestino = "90619-900";
		//String nVlPeso = "0.3";
		int nCdFormato = 1;
		//BigDecimal nVlComprimento = new BigDecimal(30);
		//BigDecimal nVlAltura = new BigDecimal(2);
		//BigDecimal nVlLargura = new BigDecimal(15);
		//BigDecimal nVlDiametro = new BigDecimal(0.0);
		String sCdMaoPropria = "N";
		//BigDecimal nVlValorDeclarado = new BigDecimal(0.00);
		String sCdAvisoRecebimento = "N";
		
		try {
			CalcPrecoPrazoWSLocator loc = new CalcPrecoPrazoWSLocator();
			CalcPrecoPrazoWSSoap calc = loc.getCalcPrecoPrazoWSSoap();
			CResultado resultado = calc.calcPrecoPrazo(nCdEmpresa, sDsSenha, nCdServico, sCepOrigem, sCepDestino, nVlPeso, nCdFormato, nVlComprimento, nVlAltura, nVlLargura, nVlDiametro, sCdMaoPropria, nVlValorDeclarado, sCdAvisoRecebimento);
			 return resultado;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}	
}