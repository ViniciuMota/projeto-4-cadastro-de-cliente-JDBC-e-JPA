package domain;

import annotations.ColunaTabela;
import annotations.Tabela;
import annotations.TipoChave;
import domain.pedidos.Carrinho;
import domain.pedidos.ProdutoCarrinho;

import java.util.List;

@Tabela("tb_cliente")
public class Cliente implements IPersistente {

    private Carrinho carrinho;

    @TipoChave("getId")
    @ColunaTabela(dbName = "id", setJavaName = "setId")
    protected Long id;

    @ColunaTabela(dbName = "nome", setJavaName = "setNome")
    private String nome;

    @ColunaTabela(dbName = "sobrenome", setJavaName = "setSobrenome")
    private String sobrenome;

    @ColunaTabela(dbName = "cpf", setJavaName = "setCpf")
    private String cpf;

    @ColunaTabela(dbName = "telefone", setJavaName = "setTelefone")
    private String telefone;

    @ColunaTabela(dbName = "endereco", setJavaName = "setEndereco")
    private String endereco;

    @ColunaTabela(dbName = "numero_endereco", setJavaName = "setNumeroEndereco")
    private Long numeroEndereco;

    @ColunaTabela(dbName = "cidade", setJavaName = "setCidade")
    private String cidade;

    @ColunaTabela(dbName = "estado", setJavaName = "setEstado")
    private String estado;

    public Cliente() {

    }

    public Cliente(Long id, String nome, String sobrenome, String cpf, String telefone, String endereco, Long numero, String cidade, String estado) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.numeroEndereco = numero;
    }

    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public Long getNumeroEndereco() {
        return numeroEndereco;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setNumeroEndereco(Long numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<ProdutoCarrinho> verCarrinho() {
        return carrinho.getListaProdutos();
    }

    public void adicionarProduto(Produto produto) {

    }

    public Produto buscarNoCarrinho(Produto produto) {
        return produto;
    }

    public void removerProduto(Produto produto) {

    }

    public void limparCarrinho() {

    }

    public void adicionarPedido() {

    }

}
