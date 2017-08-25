package br.com.aplication;

import java.util.Date;

import br.com.entity.Funcionario;
import br.com.util.ReportUtil;

public class Principal {

	public static void main(String[] args) {

		Funcionario func = new Funcionario();

		func.setNome("Marcos");
		func.setCargo("Analista");
		func.setCidade("Osasco");
		func.setEstado("São Paulo");
		func.setTelefone("11 989707284");
		func.setDtAdmission(new Date());
		
		System.out.println(func);

		ReportUtil.reportParamsFactory(func);

	}

}