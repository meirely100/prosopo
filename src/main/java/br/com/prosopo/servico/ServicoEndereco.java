package br.com.prosopo.servico;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Convert;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import br.com.prosopo.entity.Endereco;

public class ServicoEndereco implements Serializable {

	/**
	 * 
	 */
	// private static final long serialVersionUID = -3166936131275253155L;
	//
	// public Endereco buscarEnderecoPor(String urlJson) {
	// System.out.println("CHAMOU O SERVIÇO....");
	//
	// final GsonBuilder gsonBuilder = new GsonBuilder();
	// final Gson gson = gsonBuilder.create();
	// Gson g = new Gson();
	// Endereco retornoEndereco = gson.fromJson(urlJson, Endereco.class);
	// return retornoEndereco;
	// }

	@Test
	public void ConsultaCepCorreios() {

		try {

			String urlCorreios = "http://m.correios.com.br/movel/buscaCepConfirma.do";

			Document doc = Jsoup.connect(urlCorreios).data("cepEntrada", "83709826").data("tipoCep", "")
					.data("cepTemp", "").data("metodo", "buscarCep")
					// and other hidden fields which are being passed in post
					// request.
					.userAgent("Mozilla").post();

			Elements campos = doc.select(".resposta");
			Elements valores = doc.select(".respostadestaque");
			ArrayList<String> listCep = new ArrayList<String>();
			for (int i = 0; i < campos.size(); i++) {
				Element campo = campos.get(i);
				Element valor = valores.get(i);
				// System.out.println(valor.text().trim());
				 System.out.println("Aqui: " + valores.size());
				 System.out.println("1: " +valores.get(0));
				 System.out.println("2: " +valores.get(1));
				 System.out.println("3: " +valores.get(2));
				 System.out.println("4: " +valores.get(3));

				if (campos.hasText() && valores.hasText()) {

					// System.out.println(campo.text().trim() + ":" +
					// valor.text().trim());
					System.out.println(valor.getAllElements());
					System.out.println(valor.val());
					// String rua = Jsoup.parse(valor);
					// Endereco end;
					// end.setLogradouro((ArrayList<Element>)
					// valor.get(0).text().toString());
					for (Element end : valores) {
						listCep.add(end.data().trim());
						
					}
				}

			}
			
//			for(int c =0; c < listCep.size(); c++){
//				System.out.println("Segundo Array " +listCep.get(c));
//			}

//			System.out.println("Lista " +listCep);
			// return valores;

			// for(int i=0; i < campos.size(); i++){
			// Element campo = campos.get(i);
			// Element valor = valores.get(i);
			// if(campos.hasText() && valores.hasText()){
			// System.out.println(campo.text().trim() + ":" +
			// valor.text().trim());
			// }
			//
			// }

		} catch (IOException e) {
			e.printStackTrace();
			// return null;
		}

	}

}
