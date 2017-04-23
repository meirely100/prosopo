package br.com.prosopo.bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.prosopo.dao.PsicologoDao;
import br.com.prosopo.entity.Psicologo;

/**
 * Servlet implementation class ServletImagemPsico
 */
public class ServletImagemPsico extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletImagemPsico() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long idPsicologo = null;
		try {
			idPsicologo = Long.valueOf(request.getParameter("idPsicologo"));
		} catch (Exception e) {

			return;
		}

		Psicologo psico = new PsicologoDao().buscaPorId(idPsicologo);
		// resposta HTTP com bytes (imagem) incluído
		if (psico.getCaminhoFoto() != null) {
			File file = new File(psico.getCaminhoFoto());
			FileInputStream fi = new FileInputStream(file);

			byte[] conteudo_arquivo = new byte[(int) file.length()];
			fi.read(conteudo_arquivo);

			fi.close();

			response.getOutputStream().write(conteudo_arquivo);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
