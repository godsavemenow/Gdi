/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gdibike;

import java.io.IOException;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


/**
 *
 * @author Young Luke
 */
@ManagedBean
@RequestScoped
public class Controller {
    
    private String nome;
    private String cpf;
    private String telefone;
    private String pais;
    private String estado;
    private String cidade;
    private String bairro;
    private String numero;
    private String complemento;
    private String cep;
    private String imagem;
    private String retorno;
    private byte[] imagemarray;
    
    
        
    public void cadastro() throws IOException, SQLException{
        //retorno = nome + "check"+imagem;
            insertUser();
        // insertUser(nome,cpf,telefone,imagem);
        // insertUserAddress(cpf, pais, estado, cidade, bairro, numero, cep);
    }
    public Cadastro[] getList() throws SQLException {
        return Interface.all_users();
    }
    public void insertUser() throws SQLException {
        Interface.insert(cpf, nome, telefone, imagem, pais, estado, cidade, bairro, numero, cep);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
     public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getRetorno() {
        return retorno;
    }

    public void setRetorno(String retorno) {
        this.retorno = retorno;
    }

    public byte[] getImagemarray() {
        return imagemarray;
    }

    public void setImagemarray(byte[] imagemarray) {
        this.imagemarray = imagemarray;
    }

}