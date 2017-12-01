package br.edu.up.provaRR.controler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.edu.up.provaRR.dao.PassagemDao;
import br.edu.up.provaRR.entity.Passagem;

@ManagedBean
public class MBeanPassagem {

	static private ArrayList<Passagem> listaPassagem = new ArrayList<Passagem>();
	private Integer id;
	private String destino;
	private String tipo;
	private Integer assento;
	private Date data;
	private BigDecimal valor;
	private String desc;
	
	@PostConstruct
	public void atualizaTela() {
		listaPassagem = new PassagemDao().listar();
	}
	
	
	public void salvar() {
		
		Passagem pass = new Passagem();
		pass.setId(this.id);
		pass.setDestino(destino);
		pass.setAssento(assento);
		pass.setData(data);
		pass.setValor(valor);
		pass.setDesc(desc);
		
		if(tipo.equals("null")) {
			 FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Selecione o TIPO da Passagem",""));
			
		}else {
			
			pass.setTipo(tipo);
			if(this.id == null) {
				new PassagemDao().salvar(pass);
			}else {
				new PassagemDao().alterar(pass);
			}
			listaPassagem = new PassagemDao().listar();
			limpar();
		}
		
		
	}
	
	public void limpar() {
		this.id = null;
		this.destino = "";
		this.tipo = "";
		this.assento = null;
		this.data = null;
		this.valor = null;
		this.desc = "";
		}
	
	public void alterar(Passagem pass) {
		this.id = pass.getId();
		this.destino = pass.getDestino();
		this.tipo = pass.getTipo();
		this.assento = pass.getAssento();
		this.data = pass.getData();
		this.valor = pass.getValor();
		this.desc = pass.getDesc();
		this.data = pass.getData();
	}
	
	public void remover(Passagem pass) {
		
		new PassagemDao().remover(pass.getId());
		listaPassagem = new PassagemDao().listar();
	}
	
	public  ArrayList<Passagem> getListaPassagem() {
		return listaPassagem;
	}
	public  void setListaPassagem(ArrayList<Passagem> listaPassagem) {
		this.listaPassagem = listaPassagem;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public Integer getAssento() {
		return assento;
	}


	public void setAssento(Integer assento) {
		this.assento = assento;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public BigDecimal getValor() {
		return valor;
	}


	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
}
