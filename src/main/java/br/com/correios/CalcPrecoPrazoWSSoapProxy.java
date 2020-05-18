package br.com.correios;

public class CalcPrecoPrazoWSSoapProxy implements br.com.correios.CalcPrecoPrazoWSSoap {
  private String _endpoint = null;
  private br.com.correios.CalcPrecoPrazoWSSoap calcPrecoPrazoWSSoap = null;
  
  public CalcPrecoPrazoWSSoapProxy() {
    _initCalcPrecoPrazoWSSoapProxy();
  }
  
  public CalcPrecoPrazoWSSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initCalcPrecoPrazoWSSoapProxy();
  }
  
  private void _initCalcPrecoPrazoWSSoapProxy() {
    try {
      calcPrecoPrazoWSSoap = (new br.com.correios.CalcPrecoPrazoWSLocator()).getCalcPrecoPrazoWSSoap();
      if (calcPrecoPrazoWSSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)calcPrecoPrazoWSSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)calcPrecoPrazoWSSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (calcPrecoPrazoWSSoap != null)
      ((javax.xml.rpc.Stub)calcPrecoPrazoWSSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.com.correios.CalcPrecoPrazoWSSoap getCalcPrecoPrazoWSSoap() {
    if (calcPrecoPrazoWSSoap == null)
      _initCalcPrecoPrazoWSSoapProxy();
    return calcPrecoPrazoWSSoap;
  }
  
  public br.com.correios.CResultado calcPrecoPrazo(java.lang.String nCdEmpresa, java.lang.String sDsSenha, java.lang.String nCdServico, java.lang.String sCepOrigem, java.lang.String sCepDestino, java.lang.String nVlPeso, int nCdFormato, java.math.BigDecimal nVlComprimento, java.math.BigDecimal nVlAltura, java.math.BigDecimal nVlLargura, java.math.BigDecimal nVlDiametro, java.lang.String sCdMaoPropria, java.math.BigDecimal nVlValorDeclarado, java.lang.String sCdAvisoRecebimento) throws java.rmi.RemoteException{
    if (calcPrecoPrazoWSSoap == null)
      _initCalcPrecoPrazoWSSoapProxy();
    return calcPrecoPrazoWSSoap.calcPrecoPrazo(nCdEmpresa, sDsSenha, nCdServico, sCepOrigem, sCepDestino, nVlPeso, nCdFormato, nVlComprimento, nVlAltura, nVlLargura, nVlDiametro, sCdMaoPropria, nVlValorDeclarado, sCdAvisoRecebimento);
  }
  
  public br.com.correios.CResultado calcPrecoPrazoData(java.lang.String nCdEmpresa, java.lang.String sDsSenha, java.lang.String nCdServico, java.lang.String sCepOrigem, java.lang.String sCepDestino, java.lang.String nVlPeso, int nCdFormato, java.math.BigDecimal nVlComprimento, java.math.BigDecimal nVlAltura, java.math.BigDecimal nVlLargura, java.math.BigDecimal nVlDiametro, java.lang.String sCdMaoPropria, java.math.BigDecimal nVlValorDeclarado, java.lang.String sCdAvisoRecebimento, java.lang.String sDtCalculo) throws java.rmi.RemoteException{
    if (calcPrecoPrazoWSSoap == null)
      _initCalcPrecoPrazoWSSoapProxy();
    return calcPrecoPrazoWSSoap.calcPrecoPrazoData(nCdEmpresa, sDsSenha, nCdServico, sCepOrigem, sCepDestino, nVlPeso, nCdFormato, nVlComprimento, nVlAltura, nVlLargura, nVlDiametro, sCdMaoPropria, nVlValorDeclarado, sCdAvisoRecebimento, sDtCalculo);
  }
  
  public br.com.correios.CResultado calcPrecoPrazoRestricao(java.lang.String nCdEmpresa, java.lang.String sDsSenha, java.lang.String nCdServico, java.lang.String sCepOrigem, java.lang.String sCepDestino, java.lang.String nVlPeso, int nCdFormato, java.math.BigDecimal nVlComprimento, java.math.BigDecimal nVlAltura, java.math.BigDecimal nVlLargura, java.math.BigDecimal nVlDiametro, java.lang.String sCdMaoPropria, java.math.BigDecimal nVlValorDeclarado, java.lang.String sCdAvisoRecebimento, java.lang.String sDtCalculo) throws java.rmi.RemoteException{
    if (calcPrecoPrazoWSSoap == null)
      _initCalcPrecoPrazoWSSoapProxy();
    return calcPrecoPrazoWSSoap.calcPrecoPrazoRestricao(nCdEmpresa, sDsSenha, nCdServico, sCepOrigem, sCepDestino, nVlPeso, nCdFormato, nVlComprimento, nVlAltura, nVlLargura, nVlDiametro, sCdMaoPropria, nVlValorDeclarado, sCdAvisoRecebimento, sDtCalculo);
  }
  
  public br.com.correios.CResultado calcPreco(java.lang.String nCdEmpresa, java.lang.String sDsSenha, java.lang.String nCdServico, java.lang.String sCepOrigem, java.lang.String sCepDestino, java.lang.String nVlPeso, int nCdFormato, java.math.BigDecimal nVlComprimento, java.math.BigDecimal nVlAltura, java.math.BigDecimal nVlLargura, java.math.BigDecimal nVlDiametro, java.lang.String sCdMaoPropria, java.math.BigDecimal nVlValorDeclarado, java.lang.String sCdAvisoRecebimento) throws java.rmi.RemoteException{
    if (calcPrecoPrazoWSSoap == null)
      _initCalcPrecoPrazoWSSoapProxy();
    return calcPrecoPrazoWSSoap.calcPreco(nCdEmpresa, sDsSenha, nCdServico, sCepOrigem, sCepDestino, nVlPeso, nCdFormato, nVlComprimento, nVlAltura, nVlLargura, nVlDiametro, sCdMaoPropria, nVlValorDeclarado, sCdAvisoRecebimento);
  }
  
  public br.com.correios.CResultado calcPrecoData(java.lang.String nCdEmpresa, java.lang.String sDsSenha, java.lang.String nCdServico, java.lang.String sCepOrigem, java.lang.String sCepDestino, java.lang.String nVlPeso, int nCdFormato, java.math.BigDecimal nVlComprimento, java.math.BigDecimal nVlAltura, java.math.BigDecimal nVlLargura, java.math.BigDecimal nVlDiametro, java.lang.String sCdMaoPropria, java.math.BigDecimal nVlValorDeclarado, java.lang.String sCdAvisoRecebimento, java.lang.String sDtCalculo) throws java.rmi.RemoteException{
    if (calcPrecoPrazoWSSoap == null)
      _initCalcPrecoPrazoWSSoapProxy();
    return calcPrecoPrazoWSSoap.calcPrecoData(nCdEmpresa, sDsSenha, nCdServico, sCepOrigem, sCepDestino, nVlPeso, nCdFormato, nVlComprimento, nVlAltura, nVlLargura, nVlDiametro, sCdMaoPropria, nVlValorDeclarado, sCdAvisoRecebimento, sDtCalculo);
  }
  
  public br.com.correios.CResultado calcPrazo(java.lang.String nCdServico, java.lang.String sCepOrigem, java.lang.String sCepDestino) throws java.rmi.RemoteException{
    if (calcPrecoPrazoWSSoap == null)
      _initCalcPrecoPrazoWSSoapProxy();
    return calcPrecoPrazoWSSoap.calcPrazo(nCdServico, sCepOrigem, sCepDestino);
  }
  
  public br.com.correios.CResultado calcPrazoData(java.lang.String nCdServico, java.lang.String sCepOrigem, java.lang.String sCepDestino, java.lang.String sDtCalculo) throws java.rmi.RemoteException{
    if (calcPrecoPrazoWSSoap == null)
      _initCalcPrecoPrazoWSSoapProxy();
    return calcPrecoPrazoWSSoap.calcPrazoData(nCdServico, sCepOrigem, sCepDestino, sDtCalculo);
  }
  
  public br.com.correios.CResultado calcPrazoRestricao(java.lang.String nCdServico, java.lang.String sCepOrigem, java.lang.String sCepDestino, java.lang.String sDtCalculo) throws java.rmi.RemoteException{
    if (calcPrecoPrazoWSSoap == null)
      _initCalcPrecoPrazoWSSoapProxy();
    return calcPrecoPrazoWSSoap.calcPrazoRestricao(nCdServico, sCepOrigem, sCepDestino, sDtCalculo);
  }
  
  public br.com.correios.CResultado calcPrecoFAC(java.lang.String nCdServico, java.lang.String nVlPeso, java.lang.String strDataCalculo) throws java.rmi.RemoteException{
    if (calcPrecoPrazoWSSoap == null)
      _initCalcPrecoPrazoWSSoapProxy();
    return calcPrecoPrazoWSSoap.calcPrecoFAC(nCdServico, nVlPeso, strDataCalculo);
  }
  
  public br.com.correios.CResultadoObjeto calcDataMaxima(java.lang.String codigoObjeto) throws java.rmi.RemoteException{
    if (calcPrecoPrazoWSSoap == null)
      _initCalcPrecoPrazoWSSoapProxy();
    return calcPrecoPrazoWSSoap.calcDataMaxima(codigoObjeto);
  }
  
  public br.com.correios.CResultadoServicos listaServicos() throws java.rmi.RemoteException{
    if (calcPrecoPrazoWSSoap == null)
      _initCalcPrecoPrazoWSSoapProxy();
    return calcPrecoPrazoWSSoap.listaServicos();
  }
  
  public br.com.correios.CResultadoServicos listaServicosSTAR() throws java.rmi.RemoteException{
    if (calcPrecoPrazoWSSoap == null)
      _initCalcPrecoPrazoWSSoapProxy();
    return calcPrecoPrazoWSSoap.listaServicosSTAR();
  }
  
  public br.com.correios.CResultadoModal verificaModal(java.lang.String nCdServico, java.lang.String sCepOrigem, java.lang.String sCepDestino) throws java.rmi.RemoteException{
    if (calcPrecoPrazoWSSoap == null)
      _initCalcPrecoPrazoWSSoapProxy();
    return calcPrecoPrazoWSSoap.verificaModal(nCdServico, sCepOrigem, sCepDestino);
  }
  
  public br.com.correios.Versao getVersao() throws java.rmi.RemoteException{
    if (calcPrecoPrazoWSSoap == null)
      _initCalcPrecoPrazoWSSoapProxy();
    return calcPrecoPrazoWSSoap.getVersao();
  }
  
  
}