public interface ListaCircularInterface <T>{
  public void adicionarInicio(T elemento);
  public void adicionarFim(T elemento);
  public void removerInicio();
  public void removerFim();
  public T primeiro();
  public T ultimo();
  public int tamanho();
  public boolean vazia();
  public void adicionar(int posicao, T elemento);
  public T buscar(int posicao);
}