package br.com.amazonia.ecommerce;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.amazonia.ecommerce.domain.Carrinho;
import br.com.amazonia.ecommerce.domain.Cliente;
import br.com.amazonia.ecommerce.domain.DetalheEnvio;
import br.com.amazonia.ecommerce.domain.ItemCarrinho;
import br.com.amazonia.ecommerce.domain.OrdemCompra;
import br.com.amazonia.ecommerce.domain.Produto;
import br.com.amazonia.ecommerce.repository.CarrinhoRepositoryImpl;
import br.com.amazonia.ecommerce.repository.ClienteRepository;
import br.com.amazonia.ecommerce.repository.ClienteRepositoryImpl;
import br.com.amazonia.ecommerce.repository.OrdemCompraRepositoryImpl;
import br.com.amazonia.ecommerce.repository.ProdutoRepository;
import br.com.amazonia.ecommerce.repository.ProdutoRepositoryImpl;
import br.com.amazonia.ecommerce.service.CarrinhoServiceImpl;
import br.com.amazonia.ecommerce.service.ClienteServiceImpl;
import br.com.amazonia.ecommerce.service.EmailServiceImpl;
import br.com.amazonia.ecommerce.service.OrdemCompraServiceImpl;
import br.com.amazonia.ecommerce.service.ProdutoServiceImpl;

public class EcommerceTest {

	//@Test
	public void cadastrarCliente_ClienteCadastradoComSucesso() {
		
		//arrange
		Cliente cliente = new Cliente("bruno@mail.com");
		ClienteRepository clienteRepository = ClienteRepositoryImpl.getInstance();
		ClienteServiceImpl clienteService = ClienteServiceImpl.getInstance();
		
		
		//act
		clienteService.addCliente(cliente);
		
		//assert
		assertEquals(cliente, clienteRepository.getClienteById("bruno@mail.com"));
		
	}
	
	//@Test
	public void cadastrarProduto_produtoCadastradoComSucesso() {
		Produto produto = new Produto("123", 10, "PS4", false);
		ProdutoRepository produtoRepository = ProdutoRepositoryImpl.getInstance();
		ProdutoServiceImpl produtoServiceImpl = new ProdutoServiceImpl(produtoRepository);
		
		produtoServiceImpl.addProduct(produto);
		
		
		assertEquals(produto , produtoRepository.getProdutoById("123"));
		
	}	
	
	//@Test
	public void adicionarProdutoCarrinho_ProdutoAdicionadoComSucesso() {
		Produto produto = new Produto("123", 10, "PS4", false);
		//Cliente cliente = new Cliente("bruno@mail.com");
		Carrinho carrinho = new Carrinho(1);
		ItemCarrinho itemCarrinho = new ItemCarrinho(produto);
		
		CarrinhoRepositoryImpl carrinhoRepositoryImpl = CarrinhoRepositoryImpl.getInstance();
		CarrinhoServiceImpl carrinhoServiceImpl = CarrinhoServiceImpl.getInstance();
		
		carrinhoServiceImpl.criarCarrinho(carrinho);
		
		carrinho.addItem(itemCarrinho);
		
		assertEquals(produto, carrinhoRepositoryImpl.getCarrinho(1).getItens().get(produto.getId()).getProduto());
		
	}
	
	@Test
	public void realizarCompra_compraRealizadaComSucesso() {
		
		Produto produto1 = new Produto("11",10, "PS4",false);
		Produto produto2 = new Produto("22", 10, "Celular", false);
		
		Cliente cliente = new Cliente("bop_bruno@hotmail.com");
		Carrinho carrinho = new Carrinho(1);
		ItemCarrinho itemCarrinho1 = new ItemCarrinho(produto1);
		ItemCarrinho itemCarrinho2 = new ItemCarrinho(produto2);
		
		DetalheEnvio detalheEnvio = new DetalheEnvio();

		OrdemCompraRepositoryImpl ordemCompraRepositoryImpl = OrdemCompraRepositoryImpl.getInstance();
		CarrinhoServiceImpl carrinhoServiceImpl = CarrinhoServiceImpl.getInstance();
		OrdemCompraServiceImpl ordemCompraServiceImpl = new OrdemCompraServiceImpl();
		
		carrinhoServiceImpl.criarCarrinho(carrinho);
		
		carrinho.addItem(itemCarrinho1);
		carrinho.addItem(itemCarrinho2);
		
		OrdemCompra ordemCompra = new OrdemCompra(cliente, carrinho, detalheEnvio);
		
		ordemCompraServiceImpl.finalizarOrderCompra(ordemCompra);
		
		EmailServiceImpl emailService = EmailServiceImpl.getInstance();
		String corpoEmail = gerarCorpoOrdemFinalizada(ordemCompra);
		
		emailService.enviarEmail(ordemCompra.getCliente().getEmail(), "Compra realizada.", corpoEmail);
		
		assertEquals(ordemCompra, ordemCompraRepositoryImpl.getListaDeOrdens(ordemCompra.getId()));
		
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
