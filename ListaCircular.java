public class ListaCircular <T> implements ListaCircularInterface <T>{

  private No<T> cauda;
  private int tamanho;

  public ListaCircular(){
    cauda = null;
    tamanho = 0;
  }

  @Override
  public void adicionarInicio(T elemento){
    if(vazia()) {
      cauda = new No<T>(elemento, null);
      cauda.setProximo(cauda);
    }
  }

  @Override
  public void adicionarFim(T elemento){
    adicionarInicio(elemento);
    cauda = cauda.getProximo();
  }

  @Override
  public void removerInicio() {
    cauda.setProximo(cauda.getProximo().getProximo());
    tamanho--;
  }

@Override
public void removerFim() {
  if (vazia()) 
    throw new RuntimeException("Lista Vazia");

  No ant = cauda;

  for (int i = 1; i <= tamanho - 1; i++) {
    ant = ant.getProximo(); 
    }
  ant.setProximo(cauda.getProximo());

  cauda = ant;
  tamanho--;

  if (vazia())
    cauda = null;

  }

  @Override
  public T primeiro(){
    return cauda.getProximo(getElemento());
  }

  @Override
  public T ultimo(){
    return cauda.getElemento();
  }

  @Override
  public int tamanho(){
    return tamanho + 1;
  }

  @Override
  public boolean vazia(){
    return tamanho == 0;
  }

  @Override
  public T buscar(int posicao){
    if(vazia())
      throw new RuntimeException("Lista Vazia");
    if(posicao >= tamanho || posicao < 0) 
      throw new RuntimeException("Posição Inexistente");

    No<T> pos = cauda;
    
    for(int i = 1; i <= posicao + 1; i++){
      pos = pos.getProximo();
    }
    return pos.getElemento();
  }

  @Override
  public void adicionar(int posicao, T elemento){
    if(posicao < 0 || posicao > tamanho){
        throw new RuntimeException("Posição Inválida");
    }

    No<T> no = new No(elemento, null);

    if (posicao == 0 || vazia()){
        adicionarInicio(elemento);
    } else if (posicao == tamanho){
        adicionarFim(elemento);
    } else{
        No<T> add = cauda;
        for( int i = 0; i < posicao; i++){
        add = add.getProximo();
        this.tamanho++;
      }
      no.setProximo(add.getProximo());
      add.setProximo(no);
    }

  }
}