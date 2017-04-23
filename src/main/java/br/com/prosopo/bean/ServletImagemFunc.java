package br.com.prosopo.bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.prosopo.dao.FuncionarioDao;
import br.com.prosopo.entity.Funcionario;

/**
 * Servlet implementation class ServletImagemFunc
 */
public class ServletImagemFunc extends HttpServlet {
	
       
    /**
	 * 
	 */
	private static final long serialVersionUID = -2460343170781333084L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public ServletImagemFunc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idFuncionario = null;
		try {
			idFuncionario = Long.valueOf(request.getParameter("idFuncionario"));
		} catch (Exception e) {

			return;
		}

		Funcionario f = new FuncionarioDao().buscaPorId(idFuncionario);

		// resposta HTTP com bytes (imagem) incluído
		if (f.getCaminhoFoto() != null) {
			File file = new File(f.getCaminhoFoto());
			FileInputStream fi = new FileInputStream(file);

			byte[] conteudo_arquivo = new byte[(int) file.length()];
			fi.read(conteudo_arquivo);

			fi.close();

			response.getOutputStream().write(conteudo_arquivo);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
