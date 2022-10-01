package exdefixacao;

public class Elemento {
  private Produto objeto;
  private Elemento prox;

    public Elemento(Produto objeto, Elemento prox) {
        this.objeto = objeto;
        this.prox = prox;
    }

    public Produto getObjeto() {
        return objeto;
    }

    public void setObjeto(Produto objeto) {
        this.objeto = objeto;
    }

    public Elemento getProx() {
        return prox;
    }

    public void setProx(Elemento prox) {
        this.prox = prox;
    }
}
