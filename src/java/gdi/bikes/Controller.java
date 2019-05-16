package gdi.bikes;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;
import org.primefaces.model.UploadedFile;

@ManagedBean(name = "Controller")
@SessionScoped
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
    private UplodedFile imagem;
    private String retorno;
    
    public void cadastro(){
    
        retorno= "o"+imagem;
        System.out.print("aaa");
    
    }

    public String getNome(){
    
    return nome;
    }
    public void setNome(String nome){
    
    this.nome = nome;
    }
    public String getCpf(){
    
    return cpf;
    }
    public void setCpf(String cpf){
    
    this.cpf = cpf;
    }
    public String getTelefone(){
    
    return telefone;
    }
    public void setTelefone(String telefone){
    
    this.telefone = telefone;
    }
      public String getPais(){
    
    return pais;
    }
    public void setPais(String pais){
    
    this.pais = pais;
    }
      public String getEstado(){
    
    return estado;
    }
    public void setEstado(String estado){
    
    this.estado = estado;
    }
    public String getCidade(){
    
    return cidade;
    }
    public void setCidade(String cidade){
    
    this.cidade = cidade;
    }
    public String getBairro(){
    
    return bairro;
    }
    public void setBairro(String bairro){
    
    this.bairro = bairro;
    }
    public String getNumero(){
    
    return numero;
    }
    public void setNumero(String numero){
    
    this.numero = numero;
    }
  public String getComplemento(){
    
    return complemento;
    }
    public void setComplemento(String complemento){
    
    this.complemento = complemento;
    }
    public UplodedFile getImagem(){
    
    return imagem;
    }
    public void setImagem(UplodedFile imagem){
    
    this.imagem = imagem;
    }
     public String getRetorno(){
    
    return retorno;
    }
    public void setRetorno(String retorno){
    
    this.retorno = retorno;
    }

    private static class UplodedFile {
        
        private UplodedFile uplodedFile;
        
    
    public UplodedFile getUplodedFile(){
    
    return uplodedFile;
    }
    public void setRetorno(UplodedFile uplodedFile){
    
    this.uplodedFile = uplodedFile;
    }
        
    }
}
