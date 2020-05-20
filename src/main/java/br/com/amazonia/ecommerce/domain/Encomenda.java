package br.com.amazonia.ecommerce.domain;

public class Encomenda {

	private double peso;
	private double comprimento;
	private double altura;
	private double largura;
	private double diametro;
	private int cdFormato;
	private double valorDeclarado;
		
	public Encomenda(double peso,double comprimento,double altura,double largura,double diametro,int cdFormato,double valorDeclarado) {
		this.peso = peso;
		this.comprimento = comprimento;
		this.altura = altura;
		this.largura = largura;
		this.diametro = diametro;
		this.cdFormato = cdFormato;
		this.valorDeclarado= valorDeclarado;
	}
	
	
	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getComprimento() {
		return comprimento;
	}

	public void setComprimento(double comprimento) {
		this.comprimento = comprimento;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getLargura() {
		return largura;
	}

	public void setLargura(double largura) {
		this.largura = largura;
	}

	public double getDiametro() {
		return diametro;
	}

	public void setDiametro(double diametro) {
		this.diametro = diametro;
	}

	public int getCdFormato() {
		return cdFormato;
	}

	public void setCdFormato(int cdFormato) {
		this.cdFormato = cdFormato;
	}

	public double getValorDeclarado() {
		return valorDeclarado;
	}

	public void setValorDeclarado(double valorDeclarado) {
		this.valorDeclarado = valorDeclarado;
	}
	
}
