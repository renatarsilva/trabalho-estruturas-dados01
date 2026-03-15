public class VetorObject {
    private Object[] elementos;
    private int tamanho;

    public VetorObject(int capacidade){
        this.elementos = new Object[capacidade];
        this.tamanho = 0;
    }

    public void aumentaCapacidade(){
        if(this.tamanho == this.elementos.length){
            Object[] novoArray = new Object[this.elementos.length * 2];
            for(int i = 0; i < this.elementos.length; i++){
                novoArray[i] = this.elementos[i];
            }
            this.elementos = novoArray;
        }
    }

    public int tamanho(){
        return this.tamanho;
    }

    public void adiciona(Object elemento){
        aumentaCapacidade();
        elementos[tamanho] = elemento;
        tamanho++;
    }

    public int busca(Object elemento){
        for(int i = 0; i < this.tamanho; i++){
            if(this.elementos[i].equals(elemento)){
                return i;
            }
        }
        return -1;
    }

    public Object busca(int posicao) throws Exception{
        if(posicao >= 0 && posicao < this.tamanho){
            return this.elementos[posicao];
        }

        throw new Exception("Posição Inválida!");
    }

    public void remover(int posicao) throws Exception{
         if(posicao < 0 || posicao >= this.tamanho){
             throw new Exception("Posição Inválida!");
         }
         for(int i = posicao; i < this.tamanho -1; i++){
             this.elementos[i] = this.elementos[i + 1];
         }
         this.elementos[tamanho - 1] = null;
         this.tamanho--;
    }

    public void remover(Object elemento) throws Exception {
        remover(busca(elemento));
    }

    public void editar(int posicao, Object elemento) throws Exception {
        if(posicao >= 0 && posicao < this.tamanho){
            this.elementos[posicao] = elemento;
            return;
        }
        throw new Exception("Posição Inválida!");
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("[");

        for(int i = 0; i < this.tamanho - 1; i++){
            s.append(this.elementos[i]);
            s.append(", ");
        }

        if(this.tamanho > 0){
            s.append(this.elementos[this.tamanho - 1]);
        }

        s.append("]");
        return s.toString();
    }
}
