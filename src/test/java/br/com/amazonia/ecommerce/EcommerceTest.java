package br.com.amazonia.ecommerce;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.amazonia.ecommerce.domain.Carrinho;
import br.com.amazonia.ecommerce.domain.Cliente;
import br.com.amazonia.ecommerce.domain.DetalheFrete;
import br.com.amazonia.ecommerce.domain.Imposto;
import br.com.amazonia.ecommerce.domain.ItemCarrinho;
import br.com.amazonia.ecommerce.domain.OrdemCompra;
import br.com.amazonia.ecommerce.domain.Produto;
import br.com.amazonia.ecommerce.enuns.TipoProdutoEnum;
import br.com.amazonia.ecommerce.exception.CupomInvalidoException;
import br.com.amazonia.ecommerce.repository.OrdemCompraRepositoryImpl;
import br.com.amazonia.ecommerce.service.CalculadoraImpostoServiceImpl;
import br.com.amazonia.ecommerce.service.CarrinhoServiceImpl;
import br.com.amazonia.ecommerce.service.EmailServiceImpl;
import br.com.amazonia.ecommerce.service.FreteServiceImpl;
import br.com.amazonia.ecommerce.service.OrdemCompraServiceImpl;
import br.com.amazonia.ecommerce.service.PromocaoServiceImpl;

public class EcommerceTest {
	
	@Test
	public void realizarCompra_compraRealizadaComSucesso() {
		
		Produto produto1 = new Produto("11",10, "livro 1",false);
		Produto produto2 = new Produto("22", 10, "Celular", false);
		produto1.setTipo(TipoProdutoEnum.LIVRO);
		produto1.addCopunsPromocionais("cupom10");
		
		Cliente cliente = new Cliente("bop_bruno@hotmail.com");
		
		List<TipoProdutoEnum> tpProdutos = new ArrayList<>();
		tpProdutos.add(TipoProdutoEnum.LIVRO);
		tpProdutos.add(TipoProdutoEnum.REVISTA);
		tpProdutos.add(TipoProdutoEnum.JORNAL);
		tpProdutos.add(TipoProdutoEnum.E_READER);
		
		Imposto impostoIsento =  new Imposto(tpProdutos, 0.0);
		
		ItemCarrinho itemCarrinho1 = new ItemCarrinho(produto1);
		ItemCarrinho itemCarrinho2 = new ItemCarrinho(produto2);
		
		CarrinhoServiceImpl carrinhoServiceImpl = CarrinhoServiceImpl.getInstance();
		OrdemCompraServiceImpl ordemCompraServiceImpl = OrdemCompraServiceImpl.getOrdemCompraService();
		CalculadoraImpostoServiceImpl calculadoraImpostoServiceImpl = CalculadoraImpostoServiceImpl.getInstance();
		FreteServiceImpl freteServiceImpl = FreteServiceImpl.getInstance();
		PromocaoServiceImpl promocaoServiceImpl = PromocaoServiceImpl.getInstance();
		
		promocaoServiceImpl.addPromocao("cupom10", 0.1);
		
		calculadoraImpostoServiceImpl.addImposto(impostoIsento);
		
		Carrinho carrinho = carrinhoServiceImpl.criarCarrinho();
		
		carrinho.addItem(itemCarrinho1);
		carrinho.addItem(itemCarrinho2);
		
		DetalheFrete detalheEnvio = null;
		try {
			int peso = 0;
			for(String key : carrinho.getItens().keySet()) {
				ItemCarrinho itemLocal = carrinho.getItens().get(key);
				if(!itemLocal.getProduto().isEntregaDigital()) {
					peso++;
				}
			}
			if(peso>0) {
				String cdAvisoRecebimento = "N";
				String cdMaoPropria = "N";
			    String cdServico="04510";
			    String cepDestino = "90619900";
				detalheEnvio = freteServiceImpl.calcularFrete(cdAvisoRecebimento, cdMaoPropria, cdServico, cepDestino, carrinho);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
				
		try {
			promocaoServiceImpl.aplicarCupomPromocional(carrinho, "cupom10");
		} catch (CupomInvalidoException e) {
			System.out.println(e.getMessage());
		}
		
		OrdemCompra ordemCompra = new OrdemCompra(cliente, carrinho, detalheEnvio);
		
		ordemCompraServiceImpl.finalizarOrderCompra(ordemCompra);
		
		EmailServiceImpl emailService = EmailServiceImpl.getInstance();
		String corpoEmail = gerarCorpoOrdemFinalizada(ordemCompra);
		
		emailService.enviarEmail(ordemCompra.getCliente().getEmail(), "Compra realizada.", corpoEmail);
		
		
		OrdemCompraRepositoryImpl ordemCompraRepositoryImpl = OrdemCompraRepositoryImpl.getInstance();
		
		assertEquals(ordemCompra, ordemCompraRepositoryImpl.getListaDeOrdens(ordemCompra.getId()));
		
		DetalheFrete freteEsperado = ordemCompra.getDetalheEnvio();
		assertNotEquals(0, freteEsperado.getCustoEnvio());
		
		Double descontoEsperado = ordemCompra.getCarrinho().getItens().get("11").getPrecoTotal();
		assertEquals(9, descontoEsperado,0.001);
		
		assertEquals(0, ordemCompra.getTotalImposto(), 0.001);
		
	}

	private String gerarCorpoOrdemFinalizada(OrdemCompra ordemCompra) {
		
		String retorno = "Produtos comprados: \n";
		
		for(String key : ordemCompra.getCarrinho().getItens().keySet()) {
			ItemCarrinho item = ordemCompra.getCarrinho().getItens().get(key);
			retorno += "-  Produto:" +item.getProduto().getNome() +"  Quantidade:" + item.getQuantidade() + "  Preço:" + item.getPrecoTotal()  + "\n";
		}
		
		return retorno;
	}
	
}
