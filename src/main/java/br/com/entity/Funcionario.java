package br.com.entity;

import java.util.Date;

import br.com.inteface.Report;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(of = {"idFunc", "nome", "cidade"})
public class Funcionario {
	
	@Report("idFunc")
	private  Integer idFunc;
	
	@Report("nome")
	private  String nome;

	@Report("cidade")
	private  String cidade;

	@Report("estado")
	private  String estado;

	@Report("telefone")
	private  String telefone;

	@Report("cargo")
	private  String cargo;

	@Report("dtAdmissao")
	private  Date dtAdmission;

}
