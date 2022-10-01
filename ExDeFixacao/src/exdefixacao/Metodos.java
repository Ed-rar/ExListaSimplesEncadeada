package exdefixacao;

/*
 *  Professor Gerson Risso
 */
public class Metodos {
  private static Elemento inicio = null,atual,aux;
  
  static int identificador = 0;
  public static void inserir(Produto objeto){
      identificador++;
      objeto.setId(identificador);
    if(inicio==null){ 
      inicio=new Elemento(objeto,null);
      aux=inicio;
    }else{
      atual=new Elemento(objeto, null);
      aux.setProx(atual);
      aux=atual;
    } 
    
  }
  
  public static void exibir(){
    Elemento e=inicio;
    while(e!=null){
        System.out.println(e.getObjeto());
        e=e.getProx();
    }
  }
  
    public static int contarItem(){
    int contador=0;
        Elemento e=inicio;
    while(e!=null){
        contador++;
        e=e.getProx();
    }
    return contador;
  }
    
public static double contarPrecoTotal(){
    double contador=0;
        Elemento e=inicio;
    while(e!=null){
        contador+=e.getObjeto().getPreco();
        e=e.getProx();
    }
    return contador;
  }
  

  public static Produto pesquisarPorId(Integer id){
      Elemento e = inicio;
      Produto produto;
      while(e != null){
          produto = e.getObjeto();
          if(produto.getId().equals(id)){
              return produto;
          }
          e=e.getProx();
      }
      return null;
  }
 
public static Produto atualizarPrecoPorId(Integer id, Double precoNovo){
      Elemento e = inicio;
      Produto produto;
      while(e != null){
          produto = e.getObjeto();
          if(produto.getId().equals(id)){
              produto.setPreco(precoNovo);
              return produto;
          }
          e=e.getProx();
      }
      return null;
  }

public static Produto descontoPorCateg(Integer id, Double precoNovo){
      Elemento e = inicio;
      Produto produto;
      while(e != null){
          produto = e.getObjeto();
          if(produto.getId().equals(id)){
              produto.setPreco(precoNovo);
              return produto;
          }
          e=e.getProx();
      }
      return null;
  }
    
  private static Object[] pesquisarParaRemover(Produto produto){
      Object[] v = new Object[2];
      Elemento r = inicio;
      Elemento auxR=r;
      Produto prodPesq;
      
      while(r != null){
          prodPesq = r.getObjeto();
          if(produto.getId().equals(prodPesq.getId())){
             v[0]=r;
             v[1]=auxR;
             return v;
          }
          auxR = r;
          r = r.getProx();
      }
      return null;
  }
  
  public static boolean remover(Integer id){
      Produto produto = pesquisarPorId(id);
//      if(produto == null){
//          return false;
//      }
      Object[] v = pesquisarParaRemover(produto);
      if(v != null){
          Elemento r = (Elemento)v[0];
          Elemento auxR = (Elemento)v[1];
          if(r == inicio){
              inicio = r.getProx();
              r.setProx(null);
          }else if(r == atual){
              atual = auxR;
              aux = auxR;
              atual.setProx(null);
          }
          return true;
      }
      return false;
  }
  
}
