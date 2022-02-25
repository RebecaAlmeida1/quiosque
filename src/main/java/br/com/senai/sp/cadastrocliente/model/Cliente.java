package br.com.senai.sp.cadastrocliente.model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

public class Cliente {
	private Long id;
	private String nome;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Calendar dataNascimento;
	private int genero;
	private String endereco;
	private String email;
	private String telefone;
	private String produto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public int getIdade() {
		int dia = dataNascimento.get(Calendar.DAY_OF_MONTH);
		int mes = dataNascimento.get(Calendar.MONTH);
		int ano = dataNascimento.get(Calendar.YEAR);
		LocalDate dataNasc = LocalDate.of(ano, mes, dia);
		LocalDate dataAtual = LocalDate.now();
		Period periodo = Period.between(dataNasc, dataAtual);
		return periodo.getYears();
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public int getGenero() {

		return genero;
	}

	public void setGenero(int genero) {
		this.genero = genero;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	
}
