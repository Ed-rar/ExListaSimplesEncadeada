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
  
public static Integer contarItem(){
    int contador=0;
        Elemento e=inicio;
    while(e!=null){
        contador++;
        e=e.getProx();
    }
    return contador;
  }
    
public static Double contarPrecoTotal(){
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
  
    public static Integer pesquisarPorIdPosicao(Integer id){
    int contador=0;
    Elemento e=inicio;
    Produto produto;
    while(e!=null){
        produto = e.getObjeto();
        if(produto.getId().equals(id)){
            return contador;
        }
        contador++;
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

    private static Elemento[] pesquisarRemove(int id) {
        Elemento x = inicio, auxRem = null;
        Elemento[] v = {x, auxRem};
        Produto prod;
        while (x != null) {
            prod = (Produto) x.getObjeto();
            if (id == prod.getId()) {
                v[0]=x;
                v[1]=auxRem;
                return v;
            }
            auxRem = x;
            x = x.getProx();
        }
        return null;
    }

    public static boolean remover(int id) {
        Elemento[] v = pesquisarRemove(id);
        if (v != null) {//Verifica se achou!
            Elemento x = v[0];
            Elemento auxRem = v[1];
            if (x == inicio) {//Verifica se é o primeiro elemento
              inicio=x.getProx();
              x.setProx(null);
            } else if (x == atual) {//Verifica se é o último
               atual=auxRem;
               aux=auxRem;
               auxRem.setProx(null);
            } else {//Verifica se um elemento qualquer
                auxRem.setProx(x.getProx());
                x.setProx(null);
            }
           return true;
        }
        return false;//Informa que não removeu
    }


public static Double descontoPorCateg(String categoria, Double desconto){
      Elemento e = inicio;
      Produto produto;
      while(e != null){
          produto = e.getObjeto();
          if(produto.getCategoria().equals(categoria)){
              produto.setPreco((produto.getPreco()-desconto));
              return produto.getPreco();
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
